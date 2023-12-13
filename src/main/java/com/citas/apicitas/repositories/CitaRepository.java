/**
 * Interface que define un repositorio para operaciones CRUD (Create, Read, Update, Delete) de entidades Cita.
 * Extiende la interfaz CrudRepository de Spring Data.
 *
 * @param <Cita>   El tipo de entidad Cita que se gestionará en el repositorio.
 * @param <CitaId> El tipo de identificador de la entidad Cita.
 */
public interface CitaRepository extends CrudRepository<Cita, CitaId> {

    /**
     * Recupera todas las citas almacenadas en el repositorio.
     *
     * @return Un conjunto (Set) de todas las citas en el repositorio.
     */
    Set<Cita> findAll();

    /**
     * Recupera una cita específica por su identificador único.
     *
     * @param id El identificador único de la cita que se desea recuperar.
     * @return Un Optional que contiene la cita si se encuentra, o vacío si no se encuentra.
     */
    Optional<Cita> findById(CitaId id);
}
