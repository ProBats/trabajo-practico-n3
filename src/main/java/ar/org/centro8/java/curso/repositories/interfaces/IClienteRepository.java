package ar.org.centro8.java.curso.repositories.interfaces;

import java.sql.SQLException;
import java.util.List;

import ar.org.centro8.java.curso.entidades.Cliente;

public interface IClienteRepository {

    /**
     * * Metodo para crear un nuevo cliente y guardarlo en la base de datos.
     * @throws SQLException
     */
    void create(Cliente Cliente) throws SQLException;
    /**
     * Metodo para buscar un cliente por su id.
     * @param id -> Id del cliente a buscar
     * @return -> Objeto de la clase Cliente
     * @throws SQLException
     */
    Cliente findById(int id) throws SQLException;
    /**
     * Metodo para obtener todos los clientes de la base de datos.
     * @return -> Lista de objetos de la clase Cliente
     * @throws SQLException
     */
    List<Cliente> findAll() throws SQLException;
    /**
     * Metodo para actualizar un cliente.
     * @param cliente -> Objeto de la clase Cliente
     * @return -> Cantidad de filas afectadas
     * @throws SQLException
     */
    int update(Cliente cliente) throws SQLException;
    /**
     * Metodo para eliminar un cliente por su id.
     * @param id -> Id del cliente a eliminar
     * @return -> Cantidad de filas afectadas
     * @throws SQLException
     */
    int delete(int id) throws SQLException;

    /*
     * Metodos adicionales si es necesario para filtrar
     * //Buscar por apellido
     * List<Cliente> findByApellido(String apellido) throws SQLException;
     * //
     */
}
