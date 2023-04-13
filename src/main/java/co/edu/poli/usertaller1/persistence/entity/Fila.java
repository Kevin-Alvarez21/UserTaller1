package co.edu.poli.usertaller1.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "filas")
public class Fila {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_fila")
    private Integer idFila;


    /*@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tarea")
    private Tarea tarea;*/

    @Column(name = "duracion")
    private Integer duracion;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fila fila = (Fila) o;
        return Objects.equals(idFila, fila.idFila);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFila);
    }

}
