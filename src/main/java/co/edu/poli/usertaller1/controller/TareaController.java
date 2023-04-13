package co.edu.poli.usertaller1.controller;

import co.edu.poli.usertaller1.persistence.entity.Tarea;
import co.edu.poli.usertaller1.persistence.entity.Usuario;
import co.edu.poli.usertaller1.services.TareaService;
import co.edu.poli.usertaller1.services.UsuarioService;
import co.edu.poli.usertaller1.services.dto.TareaDTO;
import co.edu.poli.usertaller1.services.dto.UsuarioDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarea")
@RequiredArgsConstructor
public class TareaController {

    private final TareaService tareaService;


    @PostMapping
    public Tarea createTarea(@RequestBody TareaDTO tareaDTO){
        return tareaService.createTarea(tareaDTO);
    }

    @PutMapping("/{id}")
    public Tarea modifyTarea(@PathVariable("id") Integer id, @RequestBody TareaDTO tareaDTO){
        tareaDTO.setIdTarea(id);
        return tareaService.modifyTarea(tareaDTO);
    }

    @DeleteMapping("/{id}")
    public Tarea deleteTarea(@PathVariable("id") Integer id) {
        return tareaService.deleteTarea(id);
    }

    @GetMapping()
    public List<Tarea> findAll(){return tareaService.findAll();}
}
