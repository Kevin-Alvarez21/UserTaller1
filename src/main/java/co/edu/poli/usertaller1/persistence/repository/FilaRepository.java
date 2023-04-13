package co.edu.poli.usertaller1.persistence.repository;

import co.edu.poli.usertaller1.persistence.entity.Fila;
import co.edu.poli.usertaller1.persistence.entity.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilaRepository extends JpaRepository<Fila, Integer> {
}
