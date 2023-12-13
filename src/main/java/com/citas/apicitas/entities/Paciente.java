/**
 * Clase que representa la entidad Paciente en el sistema de citas médicas.
 * Cada instancia de esta clase corresponde a un paciente con información asociada.
 */
package com.citas.apicitas.entities;

import java.time.LocalDateTime;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;

import jakarta.persistence.*;
import lombok.*;

/**
 * Clase que representa la entidad Paciente en el sistema de citas médicas.
 * Cada instancia de esta clase corresponde a un paciente con información asociada.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "paciente")
public class Paciente {

  /**
   * Identificador único del paciente, utilizado como número de cédula.
   */
  @Id
  @Column(name = "id_numero_cedula")
  private long idNumeroCedula;

  /**
   * Nombre del paciente.
   */
  @Column
  private String nombre;

  /**
   * Apellido del paciente.
   */
  @Column
  private String apellido;

  /**
   * Número de teléfono de contacto del paciente.
   */
  @Column
  private String telefono;

  /**
   * Fecha de nacimiento del paciente.
   */
  @Column(name = "fecha_nacimiento")
  private LocalDateTime fechaNacimiento;

  /**
   * Conjunto de citas asociadas al paciente.
   * La anotación @JsonIgnore evita la serialización infinita al representar las citas.
   */
  @JsonIgnore
  @OneToMany(mappedBy = "paciente")
  private Set<Cita> citas = new HashSet<>();
}
