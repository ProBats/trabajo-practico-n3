package ar.org.centro8.java.curso.entidades;

import ar.org.centro8.java.curso.entidades.enums.EstadoCategoria;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Categoria {
    private int idCategoria;
    private String nombre;
    private String descripcion;
    private EstadoCategoria estado;
    private boolean activo;
}
