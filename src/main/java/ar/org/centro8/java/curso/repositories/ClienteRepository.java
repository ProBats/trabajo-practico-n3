package ar.org.centro8.java.curso.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import ar.org.centro8.java.curso.entidades.Cliente;
import ar.org.centro8.java.curso.repositories.interfaces.IClienteRepository;

@Repository
public class ClienteRepository implements IClienteRepository{

    private final DataSource dataSource;

    private static final String SQL_CREATE = "INSERT INTO clientes( nombre, apellido, dni, telefono, email, direccion, estado, activo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_FIND_BY_ID = "SELECT * FROM cliente WHEREidCliente=?";
    private static final String SQL_FIND_ALL = "SELECT * FROM clientes";
    private static final String SQL_UPDATE = "UPDATE clientes SET nombre=?, apellido=?, dni=?, telefono=?, email=?, direccion=?, estado=?, activo=? WHERE idCliente=?";
    private static final String SQL_DELETE = "DELETE FROM clientes WHERE idCliente=?";

    public ClienteRepository(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Override
    public void create(Cliente cliente) throws SQLException {
        try (Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(SQL_CREATE, Statement.RETURN_GENERATED_KEYS)
            ){
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setString(3, cliente.getDni());
            ps.setString(4, cliente.getTelefono());
            ps.setString(5, cliente.getEmail());
            ps.setString(6, cliente.getDireccion());
            ps.setString(7, cliente.getEstado().name());
            ps.setBoolean(8, cliente.isActivo());
            ps.executeUpdate();

            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) cliente.setIdCliente(1);
            }
        } 
    }

    @Override
    public Cliente findById(int id) throws SQLException {
        try (Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(SQL_FIND_BY_ID)
            ) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return mapRow(rs);
            }  
        } 
        return null;
    }

    @Override
    public List<Cliente> findAll() throws SQLException {
        List<Cliente> clientes = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(SQL_FIND_ALL);
            ResultSet rs = ps.executeQuery()
            ) {
            while (rs.next()) {
                clientes.add(mapRow(rs));
            }
        }
        return clientes;
    }

    @Override
    public int update(Cliente cliente) throws SQLException {
        try (Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(SQL_UPDATE)
            ) {
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setString(3, cliente.getDni());
            ps.setString(4, cliente.getTelefono());
            ps.setString(5, cliente.getEmail());
            ps.setString(6, cliente.getDireccion());
            ps.setString(7, cliente.getEstado().name());
            ps.setBoolean(8, cliente.isActivo());
            ps.setInt(9, cliente.getIdCliente());
            return  ps.executeUpdate();
        }
    }

    @Override
    public int delete(int id) throws SQLException {
        try (Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(SQL_DELETE)
            ){
            ps.setInt(1, id);
            int filaAfectada = ps.executeUpdate();
            return filaAfectada;
        } 
    }

    private Cliente mapRow(ResultSet rs) throws SQLException {
        Cliente cliente = new Cliente();
        cliente.setIdCliente(rs.getInt("idCliente"));
        cliente.setNombre(rs.getString("nombre"));
        cliente.setApellido(rs.getString("apellido"));
        cliente.setDni(rs.getString("dni"));
        cliente.setTelefono(rs.getString("telefono"));
        cliente.setEmail(rs.getString("email"));
        cliente.setDireccion(rs.getString("direccion"));
        cliente.setEstado(Enum.valueOf(ar.org.centro8.java.curso.entidades.enums.EstadoCliente.class, rs.getString("estado")));
        cliente.setActivo(rs.getBoolean("activo"));
        return cliente;
    }
}
