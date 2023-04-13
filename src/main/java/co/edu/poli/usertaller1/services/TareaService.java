package co.edu.poli.usertaller1.services;

import co.edu.poli.usertaller1.mapper.TareaInDTOToTarea;
import co.edu.poli.usertaller1.mapper.UsuarioInDTOToUsuario;
import co.edu.poli.usertaller1.persistence.entity.Tarea;
import co.edu.poli.usertaller1.persistence.entity.Usuario;
import co.edu.poli.usertaller1.persistence.repository.TareaRepository;
import co.edu.poli.usertaller1.persistence.repository.UsuarioRepository;
import co.edu.poli.usertaller1.services.dto.TareaDTO;
import co.edu.poli.usertaller1.services.dto.UsuarioDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TareaService {
    private final TareaRepository tareaRepository;

    private final TareaInDTOToTarea tareaInDTOToTarea;
    public Tarea createTarea(TareaDTO tareaDTO){
        return tareaRepository.save(tareaInDTOToTarea.mapper(tareaDTO));
    }
    public Tarea deleteTarea(Integer idTarea){
        Optional<Tarea> task= this.tareaRepository.findById(idTarea);
        if(task.isEmpty()) return null;
        this.tareaRepository.deleteById(idTarea);
        return task.orElse(null);
    }

    public Tarea modifyTarea(TareaDTO tareaDTO){
        Tarea tarea = tareaRepository.findById(tareaDTO.getIdTarea()).orElseThrow(() -> new NoSuchElementException("no existe."));

        tarea.setNombre(tareaDTO.getNombre());
        try {
            tareaRepository.save(tarea);
            return null;
        } catch (Exception e) {
            throw new RuntimeException("Error al modificar la tarea con id " + tarea.getIdTarea(), e);
        }

    }


    public List<Tarea> findAll(){return tareaRepository.findAll();}
}
