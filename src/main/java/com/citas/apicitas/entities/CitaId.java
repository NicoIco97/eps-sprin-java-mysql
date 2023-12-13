/**
 * Clase que representa la clave compuesta (ID) para la entidad Cita.
 * Esta clave incorpora los identificadores del profesional, el número de cédula
 * y la fecha y hora de la cita.
 */
package com.citas.apicitas.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Embeddable;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class CitaId implements Serializable {

    /**
     * Identificador del profesional asociado a la cita.
     */
    private long idProfesional;

    /**
     * Número de cédula asociado a la cita.
     */
    private long idNumeroCedula;

    /**
     * Fecha y hora de la cita.
     */
    private LocalDateTime fechaHora;
}
