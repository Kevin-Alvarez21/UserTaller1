package co.edu.poli.usertaller1.mapper;

import co.edu.poli.usertaller1.persistence.entity.Usuario;
import co.edu.poli.usertaller1.services.dto.UsuarioDTO;
import org.springframework.stereotype.Component;

@Component
public class UsuarioInDTOToUsuario implements IMapper<UsuarioDTO, Usuario>{

    @Override
    public Usuario mapper(UsuarioDTO in) {
        Usuario user = new Usuario();
        user.setFechaNacimiento(in.getFecha_nacimiento());
        user.setDependencia(in.getDependencia());
        user.setPerfil(in.getPerfil());
        user.setActivo(false);
        user.setFilas(in.getFila());
        return user;
    }



}
