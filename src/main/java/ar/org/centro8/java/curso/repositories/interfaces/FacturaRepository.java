package ar.org.centro8.java.curso.repositories.interfaces;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

import javax.sql.DataSource;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

import ar.org.centro8.java.curso.entidades.Factura;

public class FacturaRepository implements IFacturaRepository {

    private final DataSource dataSource;

    private static final String SQL_CREATE ="INSERT INTO facturas ( idCliente, fecha, total, estado, metodoPago) VALUES (?, ?, ?, ?, ?)";
    private static final String SQL_FIND_BY_ID="SELECT * FROM facturas WHERE idCurso = ?";
    private static final String SQL_FIND_ALL="SELECT * FROM facturas";
    
    public FacturaRepository(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Override
    public void create(Factura factura) throws SQLException {
        try (Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(SQL_CREATE, Statement.RETURN_GENERATED_KEYS)
            ) {
            ps.setInt(1, factura.getIdCliente());
            ps.setTimestamp(2,toTimesStamp(factura.getFecha()));
            ps.setDouble(3, factura.getTotal());
            ps.setString(4, factura.getEstado().name());
            ps.setString(5, factura.getMetodoPago().name());
        } 
    }

    @Override
    public Factura findById(int id) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public List<Factura> findAll() throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }


    private Timestamp toTimesStamp(LocalDate date){
        return Timestamp.valueOf(date.atStartOfDay());
    }
}
/*
 * @Repository
public class DetalleFacturaRepository {

    private final DataSource dataSource;

    private static final String SQL_CREATE = 
        "INSERT INTO detalle_factura (idFactura, idProducto, cantidad, precio) VALUES (?, ?, ?, ?)";
    private static final String SQL_FIND_BY_ID = 
        "SELECT * FROM detalle_factura WHERE idFactura=? AND idProducto=?";
    private static final String SQL_FIND_ALL = 
        "SELECT * FROM detalle_factura";
    private static final String SQL_UPDATE = 
        "UPDATE detalle_factura SET cantidad=?, precio=? WHERE idFactura=? AND idProducto=?";
    private static final String SQL_DELETE = 
        "DELETE FROM detalle_factura WHERE idFactura=? AND idProducto=?";

    public DetalleFacturaRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void create(DetalleFactura detalle) throws SQLException {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(SQL_CREATE)) {
            ps.setInt(1, detalle.getId().getIdFactura());
            ps.setInt(2, detalle.getId().getIdProducto());
            ps.setInt(3, detalle.getCantidad());
            ps.setDouble(4, detalle.getPrecio());
            ps.executeUpdate();
        }
    }

    public DetalleFactura findById(DetalleFacturaId id) throws SQLException {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(SQL_FIND_BY_ID)) {
            ps.setInt(1, id.getIdFactura());
            ps.setInt(2, id.getIdProducto());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new DetalleFactura(
                        id,
                        rs.getInt("cantidad"),
                        rs.getDouble("precio")
                    );
                }
            }
        }
        return null;
    }

    public List<DetalleFactura> findAll() throws SQLException {
        List<DetalleFactura> list = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(SQL_FIND_ALL);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(new DetalleFactura(
                    new DetalleFacturaId(
                        rs.getInt("idFactura"),
                        rs.getInt("idProducto")
                    ),
                    rs.getInt("cantidad"),
                    rs.getDouble("precio")
                ));
            }
        }
        return list;
    }

    public void update(DetalleFactura detalle) throws SQLException {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(SQL_UPDATE)) {
            ps.setInt(1, detalle.getCantidad());
            ps.setDouble(2, detalle.getPrecio());
            ps.setInt(3, detalle.getId().getIdFactura());
            ps.setInt(4, detalle.getId().getIdProducto());
            ps.executeUpdate();
        }
    }

    public void delete(DetalleFacturaId id) throws SQLException {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(SQL_DELETE)) {
            ps.setInt(1, id.getIdFactura());
            ps.setInt(2, id.getIdProducto());
            ps.executeUpdate();
        }
    }
}
 */
