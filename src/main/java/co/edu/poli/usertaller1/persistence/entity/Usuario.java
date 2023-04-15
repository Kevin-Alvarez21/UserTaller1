package co.edu.poli.usertaller1.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.*;

@Getter
@Setter
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;
    @Column(name = "activo")
    private boolean activo;
    @Enumerated(EnumType.STRING)
    @Column(name = "dependencia")
    private Dependencia dependencia;

    @ElementCollection(targetClass = Perfil.class)
    @CollectionTable(name = "usuario_perfil",
            joinColumns = @JoinColumn(name = "id_usuario"))
    @Column(name = "perfil", nullable = false)
    @Enumerated(EnumType.STRING)
    private Set<Perfil> perfiles = new HashSet<>();


    @JsonManagedReference
    @OneToMany(mappedBy = "usuario",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Fila> filas;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(idUsuario, usuario.idUsuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash();
    }



}
