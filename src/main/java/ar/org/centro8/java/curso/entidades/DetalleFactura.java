package ar.org.centro8.java.curso.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DetalleFactura {

    private int idProducto;
    private int idFactura;
    private int cantidad;
    private double precioUnitario;
    private double subtotal;
}
