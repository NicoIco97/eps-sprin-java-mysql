/**
 * La clase {@code Cita} representa la entidad de citas médicas en el sistema.
 * Cada cita está asociada a un médico (Doctor) y un paciente (Paciente),
 * identificada por la combinación de sus respectivas IDs (CitaId).
 *
 * @author TuNombre
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "cita")
public class Cita {
  
  /**
   * La clave primaria compuesta {@code id} representa la identificación única de la cita,
   * compuesta por la combinación de las IDs del médico y del paciente.
   */
  @EmbeddedId
  private CitaId id;

  /**
   * El médico asociado a esta cita.
   * La relación está mapeada mediante la propiedad "idProfesional" de la clave primaria compuesta.
   */
  @MapsId("idProfesional")
  @ManyToOne
  @JoinColumn(name = "id_profesional")
  private Doctor doctor;

  /**
   * El paciente asociado a esta cita.
   * La relación está mapeada mediante la propiedad "idNumeroCedula" de la clave primaria compuesta.
   */
  @MapsId("idNumeroCedula")
  @ManyToOne
  @JoinColumn(name = "id_numero_cedula")
  private Paciente paciente;
}
