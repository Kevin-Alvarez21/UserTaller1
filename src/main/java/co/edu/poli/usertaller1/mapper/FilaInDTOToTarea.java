package co.edu.poli.usertaller1.mapper;

import co.edu.poli.usertaller1.persistence.entity.Fila;
import co.edu.poli.usertaller1.persistence.entity.Tarea;
import co.edu.poli.usertaller1.services.dto.FilaDTO;
import co.edu.poli.usertaller1.services.dto.TareaDTO;
import org.springframework.stereotype.Component;

@Component
public class FilaInDTOToTarea implements IMapper<FilaDTO, Fila>{
    @Override
    public Fila mapper(FilaDTO in) {
        Fila fila = new Fila();
        fila.setDuracion(in.getDuracion());
        fila.setUsuario(in.getUsuario());
        /*fila.setTarea(in.getTarea());*/
        return fila;
    }
}
