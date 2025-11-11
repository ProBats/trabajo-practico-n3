package ar.org.centro8.java.curso.repositories.interfaces;

import java.sql.SQLException;
import java.util.List;

import ar.org.centro8.java.curso.entidades.Producto;

public interface IProductoDAO {

    /**
     * Metodo para crear un nuevo producto y guardarlo en la base de datos.
     * @param producto -> Objeto de la clase Producto
     * @throws SQLException
     */
    void create(Producto producto) throws SQLException;

    /**
     * Metodo para buscar un producto por su id.
     * @param id -> Id del producto a buscar
     * @return -> Objeto de la clase Producto
     * @throws SQLException
     */
    Producto findById(int id) throws SQLException;

    /**
     * Metodo para obtener todos los productos de la base de datos.
     * @return -> Lista de objetos de la clase Producto
     * @throws SQLException
     */
    List<Producto> findAll() throws SQLException;

    /**
     * Metodo para actualizar un producto.
     * @param producto -> Objeto de la clase Producto
     * @return -> Cantidad de filas afectadas
     * @throws SQLException
     */
    int update(Producto producto) throws SQLException;

    /**
     * Metodo para eliminar un producto por su id.
     * @param id -> Id del producto a eliminar
     * @return -> Cantidad de filas afectadas
     * @throws SQLException
     */
    int delete(int id) throws SQLException;

    /*
     * Metodos adicionales si es necesario para filtrar
     * //Buscar productos por categoria
     * List<Producto> findByCatergoria(int idCategoria) throws SQLException;
     * 
     * //Buscar productos por nombre
     * Producto findByNombre(String nombre) throws SQLException;
     * 
     * //Buscar por fragmento de nombre
     * List<Producto> findLikeNombre(String nombre) throws SQLException;
     * 
     * //Buscar productos por un stock mayor a ?
     * Lista<Producto> findByStockMinimo
     * 
     * //Buscar productos por activo o inactivo
     * List<Producto> findByActivo(boolean activo) throws SQLException;
     */
}
