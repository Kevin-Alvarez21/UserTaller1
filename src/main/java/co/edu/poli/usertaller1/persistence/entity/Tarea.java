package co.edu.poli.usertaller1.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Entity
@Setter
@Getter
@Table(name = "tarea")
@JsonIgnoreProperties({"hibernateLazyInitializer", "otherPropertyToIgnore"})
public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tarea")
    private Integer idTarea;
    @Column(name = "nombre")
    private String nombre;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tarea that = (Tarea) o;
        return Objects.equals(idTarea, that.idTarea);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTarea);
    }


}
