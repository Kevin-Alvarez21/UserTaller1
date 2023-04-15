package co.edu.poli.usertaller1.services.dto;

import co.edu.poli.usertaller1.persistence.entity.Fila;
import lombok.Data;

@Data
public class TareaDTO {
    private Integer idTarea;
    private String nombre;
    private Fila fila;

}
