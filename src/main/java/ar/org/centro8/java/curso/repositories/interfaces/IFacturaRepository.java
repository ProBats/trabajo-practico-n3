package ar.org.centro8.java.curso.repositories.interfaces;

import java.sql.SQLException;
import java.util.List;

import ar.org.centro8.java.curso.entidades.Factura;

public interface IFacturaRepository {

    void create(Factura factura) throws SQLException;
    Factura findById(int id) throws SQLException;
    List<Factura> findAll() throws SQLException;
    //UPDATE (solo si esta en borrador o pendiente, no cuando se emite, o pagada)
    //DELETE (solo si esta como borrador o pendiente)

}
