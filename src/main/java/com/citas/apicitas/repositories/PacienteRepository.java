/**
 * Interfaz que define las operaciones de acceso a datos para la entidad Paciente.
 * Extiende CrudRepository, proporcionando operaciones CRUD básicas.
 *
 * @param <Paciente> Tipo de la entidad gestionada por el repositorio.
 * @param <Long> Tipo del identificador único de la entidad.
 */
public interface PacienteRepository extends CrudRepository<Paciente, Long> {

    /**
     * Recupera un conjunto de todos los pacientes.
     *
     * @return Conjunto de pacientes.
     */
    Set<Paciente> findAll();
}
