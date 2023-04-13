package co.edu.poli.usertaller1.controller;

import co.edu.poli.usertaller1.persistence.entity.Usuario;
import co.edu.poli.usertaller1.services.UsuarioService;
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
    public Usuario createUsuario(@Valid @RequestBody UsuarioDTO usuarioDTO){
        return usuarioService.createUsuario(usuarioDTO);
    }

   @GetMapping()
    public List<Usuario> findAll(){return usuarioService.findAll();}
}
