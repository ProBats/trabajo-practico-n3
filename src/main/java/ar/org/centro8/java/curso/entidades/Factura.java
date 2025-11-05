package ar.org.centro8.java.curso.entidades;

import java.util.Date;

import ar.org.centro8.java.curso.entidades.enums.EstadoFactura;
import ar.org.centro8.java.curso.entidades.enums.MetodoPago;
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
public class Factura {

    private int idFactura;
    private Cliente cliente;
    private Date fecha;
    private double total;
    private EstadoFactura estado;
    private MetodoPago metodoPago;

}
