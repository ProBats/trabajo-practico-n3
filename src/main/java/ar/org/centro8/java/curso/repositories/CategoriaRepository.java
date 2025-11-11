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

import ar.org.centro8.java.curso.entidades.Categoria;
import ar.org.centro8.java.curso.entidades.enums.EstadoCategoria;
import ar.org.centro8.java.curso.repositories.interfaces.ICategoriaRepository;

@Repository
public class CategoriaRepository implements ICategoriaRepository{

    private final DataSource dataSource;
    
    private static final String SQL_CREATE = "INSERT INTO categorias(nombre, descripcion, estado, activo) VALUES(?,?,?,?)";
    private static final String SQL_FIND_BY_ID = "SELECT * FROM categorias WHERE idCategoria = ?;";
    private static final String SQL_FIND_ALL = "SELECT * FROM categorias";
    private static final String SQL_UPDATE = "UPDATE categorias SET nombre=?, descripcion=?, estado=?, activo=? WHERE idCategoria=?";
    private static final String SQL_DELETE = "DELETE FROM categorias WHERE idProducto=?";


    public  CategoriaRepository(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Override
    public void create(Categoria categoria) throws SQLException {
        try (Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(SQL_CREATE,Statement.RETURN_GENERATED_KEYS)
            ) {
            ps.setString(1, categoria.getNombre());
            ps.setString(2, categoria.getDescripcion());
            ps.setString(3, categoria.getEstado().name());
            ps.setBoolean(4, categoria.isActivo());
            ps.executeUpdate();

            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) {
                    categoria.setIdCategoria(1);
                }
            } 
        } 
    }

    @Override
    public Categoria findById(int id) throws SQLException {
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
    public List<Categoria> findAll() throws SQLException {
        List<Categoria> categorias = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(SQL_FIND_ALL);
            ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                categorias.add(mapRow(rs));
            }
        }
        return null;
    }

    @Override
    public int update(Categoria categoria) throws SQLException {
        try (Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(SQL_UPDATE)
            ) {
            ps.setString(1, categoria.getNombre());
            ps.setString(2, categoria.getDescripcion());
            ps.setString(3, categoria.getEstado().name());
            ps.setBoolean(4, categoria.isActivo());
            ps.setInt(5, categoria.getIdCategoria());
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas = ps.executeUpdate();
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

    private Categoria mapRow(ResultSet rs) throws SQLException{
        Categoria c = new Categoria();
        c.setIdCategoria(rs.getInt("idCategoria"));
        c.setNombre(rs.getString("nombre"));
        c.setDescripcion(rs.getString("descripcion"));
        c.setEstado(EstadoCategoria.valueOf(rs.getString("estado").toUpperCase()));
        c.setActivo(rs.getBoolean("activo"));
        return c;
    }
}
