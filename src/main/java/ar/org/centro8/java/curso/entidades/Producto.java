package ar.org.centro8.java.curso.entidades;

import ar.org.centro8.java.curso.entidades.enums.EstadoProducto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Producto {
    
    private int idProducto;
    private String nombre;
    private int idCategoria;
    private double precioCompra;
    private double precioVenta;
    private int stock;
    private EstadoProducto estado;
    private boolean activo;
}
