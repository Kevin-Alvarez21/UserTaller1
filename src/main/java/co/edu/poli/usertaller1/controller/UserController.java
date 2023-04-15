package co.edu.poli.usertaller1.controller;

import co.edu.poli.usertaller1.persistence.entity.Tarea;
import co.edu.poli.usertaller1.persistence.entity.Usuario;
import co.edu.poli.usertaller1.services.UsuarioService;
import co.edu.poli.usertaller1.services.dto.TareaDTO;
import co.edu.poli.usertaller1.services.dto.UsuarioDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UserController {
    private final UsuarioService usuarioService;

    @PostMapping
    public Usuario createUsuario(@RequestBody UsuarioDTO usuarioDTO){
        if (!usuarioDTO.isMayorDeEdad()) {
            throw new IllegalArgumentException("El usuario debe tener más de 18 años.");
        }

        return usuarioService.createUsuario(usuarioDTO);
    }

   @GetMapping()
    public List<Usuario> findAll(){return usuarioService.findAll();}

    @PutMapping("/{id}")
    public Usuario modifyUsuario(@PathVariable("id") Integer id, @RequestBody UsuarioDTO usuarioDTO){
        usuarioDTO.setIdUsuario(id);
        return usuarioService.modifyUsuario(usuarioDTO);
    }

    @DeleteMapping("/{id}")
    public Usuario deleteUsuario(@PathVariable("id") Integer id) {
        return usuarioService.deleteUsuario(id);
    }

}
