package co.edu.poli.usertaller1.services.dto;

import co.edu.poli.usertaller1.persistence.entity.Dependencia;
import co.edu.poli.usertaller1.persistence.entity.Fila;
import co.edu.poli.usertaller1.persistence.entity.Perfil;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Past;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
@Data
public class UsuarioDTO {
    @Past
    private LocalDate fecha_nacimiento;
    private Boolean activo;
    private Dependencia dependencia;
    private Perfil perfil;
    private List<Fila> fila;

    @AssertTrue(message = "El usuario debe tener al menos 18 años")
    public boolean isMayorDeEdad() {
        LocalDate ahora = LocalDate.now();
        LocalDate mayorDeEdad = fecha_nacimiento.plusYears(18);
        return mayorDeEdad.isBefore(ahora) || mayorDeEdad.isEqual(ahora);
    }
}
