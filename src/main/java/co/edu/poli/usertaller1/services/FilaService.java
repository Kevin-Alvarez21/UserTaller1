package co.edu.poli.usertaller1.services;

import co.edu.poli.usertaller1.mapper.FilaInDTOToTarea;
import co.edu.poli.usertaller1.mapper.TareaInDTOToTarea;
import co.edu.poli.usertaller1.persistence.entity.Fila;
import co.edu.poli.usertaller1.persistence.entity.Tarea;
import co.edu.poli.usertaller1.persistence.repository.FilaRepository;
import co.edu.poli.usertaller1.persistence.repository.TareaRepository;
import co.edu.poli.usertaller1.services.dto.FilaDTO;
import co.edu.poli.usertaller1.services.dto.TareaDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FilaService {
    private final FilaRepository filaRepository;

    private final FilaInDTOToTarea filaInDTOToTarea;
    @Transactional
    public Fila createFila(FilaDTO filaDTO){
        return filaRepository.save(filaInDTOToTarea.mapper(filaDTO));
    }

    public List<Fila> findAll(){return filaRepository.findAll();}

    public Fila deleteFila(Integer idFila){
        Optional<Fila> fila= this.filaRepository.findById(idFila);
        if(fila.isEmpty()) return null;
        this.filaRepository.deleteById(idFila);
        return fila.orElse(null);
    }

    public Fila modifyFila(FilaDTO filaDTO){
        Fila fila = filaRepository.findById(filaDTO.getIdFila()).orElseThrow(() -> new NoSuchElementException("no existe."));

       /* fila.setTarea(filaDTO.getTarea());*/
        fila.setDuracion(filaDTO.getDuracion());
        try {
            filaRepository.save(fila);
            return null;
        } catch (Exception e) {
            throw new RuntimeException("Error al modificar la tarea con id " + fila.getIdFila(), e);
        }

    }


}
