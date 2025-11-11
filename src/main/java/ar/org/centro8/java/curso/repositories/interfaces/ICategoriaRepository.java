package ar.org.centro8.java.curso.repositories.interfaces;

import java.sql.SQLException;
import java.util.List;

import ar.org.centro8.java.curso.entidades.Categoria;

public interface ICategoriaRepository {

    /**
     * Metodo para crear una nueva categoria y guardarla en la base de datos.
     * @param categoria -> Objeto de la clase Categoria
     * @throws SQLException
     */
    void create(Categoria categoria) throws SQLException;

    /**
     * Metodo para buscar una categoria por su id.
     * @param id -> Id de la categoria a buscar
     * @return -> Objeto de la clase Categoria
     * @throws SQLException
     */
    Categoria findById(int id) throws SQLException;

    /**
     * Metodo para obtener todas las categorias de la base de datos.
     * @return-> Lista de objetos de la clase Categoria
     * @throws SQLException
     */
    List<Categoria> findAll() throws SQLException;

    /**
     * Metodo para actualizar una categoria.
     * @param categoria-> Objeto de la clase Categoria
     * @return-> Cantidad de filas afectadas
     * @throws SQLException
     */
    int update(Categoria categoria) throws SQLException;

    /**
     * Metodo para eliminar una categoria por su id.
     * @param id-> Id de la categoria a eliminar
     * @return-> Cantidad de filas afectadas
     * @throws SQLException
     */
    int delete(int id) throws SQLException;

    //Metodos adicionales si es necesario para filtrar
    /*
     * //Buscar categoria por nombre
     * Categoria findByName(String nombre) throws SQLException;
     * //Buscar categorias por fragmento de nombre
     * List<Categoria> findLikeNombre(String nombre) throws SQLException;
     * //Buscar categorias por activo o inactivo
     * List<Categoria> findByActivo(boolean activo) throws SQLException;
     */
}
