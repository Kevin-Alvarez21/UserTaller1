package co.edu.poli.usertaller1.persistence.repository;

import co.edu.poli.usertaller1.persistence.entity.Tarea;
import co.edu.poli.usertaller1.persistence.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TareaRepository extends JpaRepository<Tarea, Integer> {

}
