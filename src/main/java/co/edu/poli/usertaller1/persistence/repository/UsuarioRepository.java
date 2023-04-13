package co.edu.poli.usertaller1.persistence.repository;

import co.edu.poli.usertaller1.persistence.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsuarioRepository extends JpaRepository <Usuario, Integer>{

}
