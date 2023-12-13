/**
 * PacienteServiceImpl es una implementación de la interfaz PacienteService que proporciona
 * métodos para realizar operaciones relacionadas con la entidad Paciente.
 * Esta clase utiliza la anotación @Service de Spring para ser detectada automáticamente como un componente
 * de servicio durante la exploración de componentes.
 */
@Service
public class PacienteServiceImpl implements PacienteService {

  /**
   * Repositorio de Paciente utilizado para realizar operaciones de persistencia relacionadas con la entidad Paciente.
   */
  @Autowired
  private PacienteRepository pacienteRepository;

  /**
   * Recupera todos los pacientes almacenados en la base de datos.
   *
   * @return Un conjunto (Set) de objetos Paciente.
   */
  @Override
  public Set<Paciente> findAll() {
    return pacienteRepository.findAll();
  }

  /**
   * Busca y recupera un paciente por su identificador único.
   *
   * @param id El identificador único del paciente.
   * @return El objeto Paciente correspondiente al identificador proporcionado.
   * @throws ResourceNotFoundException Si no se encuentra ningún paciente con el identificador proporcionado.
   */
  @Override
  public Paciente findById(Long id) {
    Paciente paciente = pacienteRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Paciente not found with id: " + id));

    return paciente;
  }

  /**
   * Agrega un nuevo paciente a la base de datos.
   *
   * @param paciente El objeto Paciente que se va a agregar.
   * @return El Paciente recién agregado.
   * @throws DataIntegrityViolationException Si ya existe un paciente con la misma clave primaria.
   */
  @Override
  public Paciente addPaciente(Paciente paciente) {
    Optional<Paciente> pacienteExist = pacienteRepository.findById(paciente.getIdNumeroCedula());

    if (pacienteExist.isPresent()) {
      throw new DataIntegrityViolationException("Primary key already exists");
    } else {
      return pacienteRepository.save(paciente);
    }
  }

  /**
   * Modifica la información de un paciente existente en la base de datos.
   *
   * @param id          El identificador único del paciente que se va a modificar.
   * @param newPaciente El objeto Paciente con la nueva información.
   * @return El Paciente modificado.
   * @throws ResourceNotFoundException Si no se encuentra ningún paciente con el identificador proporcionado.
   */
  @Override
  public Paciente modifyPaciente(Long id, Paciente newPaciente) {
    Paciente paciente = pacienteRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Paciente not found with id: " + id));

    newPaciente.setIdNumeroCedula(paciente.getIdNumeroCedula());

    return pacienteRepository.save(newPaciente);
  }

  /**
   * Elimina un paciente de la base de datos por su identificador único.
   *
   * @param id El identificador único del paciente que se va a eliminar.
   * @throws ResourceNotFoundException Si no se encuentra ningún paciente con el identificador proporcionado.
   */
  @Override
  public void deletePaciente(Long id) {
    pacienteRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Paciente not found with id: " + id));

    pacienteRepository.deleteById(id);
  }
}
