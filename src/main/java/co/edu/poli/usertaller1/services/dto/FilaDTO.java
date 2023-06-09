package co.edu.poli.usertaller1.services.dto;

import co.edu.poli.usertaller1.persistence.entity.Tarea;
import co.edu.poli.usertaller1.persistence.entity.Usuario;
import lombok.Data;

import java.util.List;

@Data
public class FilaDTO {
    private Integer idFila;
    private Tarea tarea;
    private Integer duracion;
    private Usuario usuario;
}
