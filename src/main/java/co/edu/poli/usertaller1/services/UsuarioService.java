package co.edu.poli.usertaller1.services;

import co.edu.poli.usertaller1.mapper.UsuarioInDTOToUsuario;
import co.edu.poli.usertaller1.persistence.entity.Tarea;
import co.edu.poli.usertaller1.persistence.entity.Usuario;
import co.edu.poli.usertaller1.persistence.repository.UsuarioRepository;
import co.edu.poli.usertaller1.services.dto.TareaDTO;
import co.edu.poli.usertaller1.services.dto.UsuarioDTO;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private final UsuarioInDTOToUsuario usuarioInDTOToUsuario;
    public Usuario createUsuario(UsuarioDTO usuarioDTO){
        return usuarioRepository.save(usuarioInDTOToUsuario.mapper(usuarioDTO));
    }

    public List<Usuario> findAll(){return usuarioRepository.findAll();}

    public Usuario deleteUsuario(Integer idUsuario){
        Optional<Usuario> usuario= this.usuarioRepository.findById(idUsuario);
        if(usuario.isEmpty()) return null;
        this.usuarioRepository.deleteById(idUsuario);
        return usuario.orElse(null);
    }

    public Usuario modifyUsuario(UsuarioDTO usuarioDTO){
        Usuario usuario = usuarioRepository.findById(usuarioDTO.getIdUsuario()).orElseThrow(() -> new NoSuchElementException("no existe."));

        usuario.setPerfiles(usuarioDTO.getPerfil());
        usuario.setFilas(usuarioDTO.getFila());
        usuario.setDependencia(usuarioDTO.getDependencia());
        usuario.setActivo(usuarioDTO.getActivo());
        usuario.setFechaNacimiento(usuarioDTO.getFecha_nacimiento());
        try {
            usuarioRepository.save(usuario);
            return null;
        } catch (Exception e) {
            throw new RuntimeException("Error al modificar la tarea con id " + usuario.getIdUsuario(), e);
        }

    }



}
