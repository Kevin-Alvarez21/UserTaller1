package co.edu.poli.usertaller1.controller;

import co.edu.poli.usertaller1.persistence.entity.Fila;
import co.edu.poli.usertaller1.persistence.entity.Tarea;
import co.edu.poli.usertaller1.services.FilaService;
import co.edu.poli.usertaller1.services.dto.FilaDTO;
import co.edu.poli.usertaller1.services.dto.TareaDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fila")
@RequiredArgsConstructor
public class FilaController {
    private final FilaService filaService;


    @PostMapping
    public Fila createFila(@RequestBody FilaDTO filaDTO){
        return filaService.createFila(filaDTO);
    }

    @PutMapping("/{id}")
    public Fila modifyFila(@PathVariable("id") Integer id, @RequestBody FilaDTO filaDTO){
        filaDTO.setIdFila(id);
        return filaService.modifyFila(filaDTO);
    }

    @DeleteMapping("/{id}")
    public Fila deleteFila(@PathVariable("id") Integer id) {
        return filaService.deleteFila(id);
    }


    @GetMapping()
    public List<Fila> findAll(){return filaService.findAll();}

}
