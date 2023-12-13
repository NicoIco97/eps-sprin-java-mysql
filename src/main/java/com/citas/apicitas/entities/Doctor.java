/**
 * La clase {@code Doctor} representa a un profesional médico en el sistema.
 * Contiene información como el identificador único, nombre, apellido, correo,
 * especialidad y las citas asociadas a este doctor.
 *
 * @author Tu Nombre
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "doctor")
public class Doctor {

    /**
     * Identificador único del profesional médico.
     */
    @Id
    @Column(name = "id_profesional")
    private long idProfesional;

    /**
     * Nombre del doctor.
     */
    @Column
    private String nombre;

    /**
     * Apellido del doctor.
     */
    @Column
    private String apellido;

    /**
     * Correo electrónico del doctor.
     */
    @Column
    private String correo;

    /**
     * Especialidad del doctor, representada como un enum {@code Especialidad}.
     */
    @Enumerated(EnumType.STRING)
    @Column
    private Especialidad especialidad;

    /**
     * Conjunto de citas asociadas a este doctor.
     * Utiliza la anotación {@code JsonIgnore} para evitar la serialización
     * de las citas al convertir el objeto a formato JSON.
     */
    @JsonIgnore
    @OneToMany(mappedBy = "doctor")
    private Set<Cita> citas = new HashSet<>();

    /**
     * Enumeración que representa las posibles especialidades de un doctor.
     * Actualmente incluye las especialidades "medicina_interna" y "medicina_general".
     */
    public enum Especialidad {
        medicina_interna,
        medicina_general
    }

    // Constructor, getters y setters adicionales pueden ir aquí si es necesario.
}
