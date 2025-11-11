package ar.org.centro8.java.curso.repositories;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import ar.org.centro8.java.curso.entidades.Producto;
import ar.org.centro8.java.curso.repositories.interfaces.IProductoRepository;

@Repository
public class ProductoRepository implements IProductoRepository{

    private final DataSource dataSource;

    private static final String SQL_CREATE = "INSERT INTO productos(nombre, idCategoria, precioCompra, precioVenta, stock, estado, activo) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_FIND_BY_ID = "SELECT * FROM prodductos WHERE idProducto=?";
    private static final String SQL_FIND_ALL = "SELECT * FROM productos";
    private static final String SQL_UPDATE = "UPDATE productos SET nombre=?, idCategoria=?, precioCompra=?, precioVenta=?, stock=?, estado=?, activo=? WHERE idProducto=?";
    private static final String sQL_DELETE = "DELETE FROM productos WHERE idProducto=?";

    public ProductoRepository(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Override
    public void create(Producto producto) throws SQLException {
        try (Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(SQL_CREATE, Statement.RETURN_GENERATED_KEYS)
            ){
                ps.setString(1, producto.getNombre());
                ps.setInt(2, producto.getIdCategoria());
                ps.setDouble(3, producto.getPrecioCompra());
                ps.setDouble(4, producto.getPrecioVenta());
                ps.setInt(5, producto.getStock());
                ps.setString(6, producto.getEstado().name());
                ps.setBoolean(7, producto.isActivo());
                ps.executeUpdate();

                try (ResultSet keys = ps.getGeneratedKeys()) {
                    if (keys.next()) producto.setIdProducto(1);
                }
            }
    }

    @Override
    public Producto findById(int id) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public List<Producto> findAll() throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public int update(Producto producto) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public int delete(int id) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
