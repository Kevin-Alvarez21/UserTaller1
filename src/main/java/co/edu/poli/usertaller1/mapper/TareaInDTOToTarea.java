package co.edu.poli.usertaller1.mapper;

import co.edu.poli.usertaller1.persistence.entity.Tarea;
import co.edu.poli.usertaller1.persistence.entity.Usuario;
import co.edu.poli.usertaller1.services.dto.TareaDTO;
import co.edu.poli.usertaller1.services.dto.UsuarioDTO;
import org.springframework.stereotype.Component;

@Component
public class TareaInDTOToTarea implements IMapper<TareaDTO, Tarea>{

    @Override
    public Tarea mapper(TareaDTO in) {
        Tarea task = new Tarea();
        task.setIdTarea(in.getIdTarea());
        task.setNombre(in.getNombre());
        task.setFila(in.getFila());
        return task;
    }
}
