package ar.org.centro8.java.curso.entidades;

import ar.org.centro8.java.curso.entidades.enums.EstadoCliente;
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
public class Cliente {

    private int idCliente;
    private String nombre;
    private String apellido;
    private String dni;
    private String telefono;
    private String email;
    private String direccion;
    private EstadoCliente estado;
    private boolean activo;
}
