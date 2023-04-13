package co.edu.poli.usertaller1.services;

import co.edu.poli.usertaller1.mapper.UsuarioInDTOToUsuario;
import co.edu.poli.usertaller1.persistence.entity.Usuario;
import co.edu.poli.usertaller1.persistence.repository.UsuarioRepository;
import co.edu.poli.usertaller1.services.dto.UsuarioDTO;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private final UsuarioInDTOToUsuario usuarioInDTOToUsuario;
    public Usuario createUsuario(UsuarioDTO usuarioDTO){
        return usuarioRepository.save(usuarioInDTOToUsuario.mapper(usuarioDTO));
    }

    public List<Usuario> findAll(){return usuarioRepository.findAll();}


}
