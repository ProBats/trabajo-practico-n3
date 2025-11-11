package ar.org.centro8.java.curso.repositories.interfaces;


import java.sql.SQLException;
import java.util.List;

import ar.org.centro8.java.curso.entidades.DetalleFactura;

public interface IDetalleFacturaRepository {

    void create(DetalleFactura detalleFactura) throws SQLException;
    List<DetalleFactura> findAll() throws SQLException;
    //UPDATE (solo si esta en borrador o pendiente, no cuando se emite, o pagada)
    //DELETE (solo si esta como borrador o pendiente)
}
