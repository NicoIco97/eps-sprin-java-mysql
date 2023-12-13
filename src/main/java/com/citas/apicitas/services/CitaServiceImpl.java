package com.citas.apicitas.services;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.citas.apicitas.entities.Cita;
import com.citas.apicitas.entities.CitaId;
import com.citas.apicitas.entities.Doctor;
import com.citas.apicitas.entities.Paciente;
import com.citas.apicitas.exception.ResourceNotFoundException;
import com.citas.apicitas.repositories.CitaRepository;

/**
 * Implementación de la interfaz {@link CitaService} que proporciona operaciones CRUD para la entidad {@link Cita}.
 */
@Service
public class CitaServiceImpl implements CitaService {

  @Autowired
  private CitaRepository citaRepository;

  @Autowired
  private DoctorService doctorService;

  @Autowired
  private PacienteService pacienteService;

  /**
   * Obtiene todas las citas disponibles.
   *
   * @return Conjunto de citas.
   */
  @Override
  public Set<Cita> findAll() {
    return citaRepository.findAll();
  }

  /**
   * Busca una cita por su identificador único.
   *
   * @param id Identificador único de la cita.
   * @return La cita correspondiente al identificador proporcionado.
   * @throws ResourceNotFoundException Si no se encuentra la cita con el identificador dado.
   */
  @Override
  public Cita findById(CitaId id) {
    Cita cita = citaRepository.findById(id)
      .orElseThrow(() -> new ResourceNotFoundException("Cita not found with id: " + id));

    return cita;
  }

  /**
   * Agrega una nueva cita al repositorio.
   *
   * @param id   Identificador único de la cita.
   * @param cita La cita a agregar.
   * @return La cita agregada.
   * @throws DataIntegrityViolationException Si ya existe una cita con el mismo identificador único.
   */
  @Override
  public Cita addCita(CitaId id, Cita cita) {
    Optional<Cita> citaExist = citaRepository.findById(id);

    if (citaExist.isPresent()) {
      throw new DataIntegrityViolationException("Primary key already exists");
    } else {
      return citaRepository.save(cita);
    }
  }

  /**
   * Modifica una cita existente.
   *
   * @param id     Identificador único de la cita a modificar.
   * @param newCita Nueva información de la cita.
   * @return La cita modificada.
   * @throws ResourceNotFoundException      Si no se encuentra la cita con el identificador dado.
   * @throws DataIntegrityViolationException Si ya existe una cita con el nuevo identificador único.
   */
  @Override
  public Cita modifyCita(CitaId id, CitaId newCita) {
    Cita cita = citaRepository.findById(id)
      .orElseThrow(() -> new ResourceNotFoundException("Cita not found with id: " + id));

    Doctor doctor = doctorService.findById(newCita.getIdProfesional());
    Paciente paciente = pacienteService.findById(newCita.getIdNumeroCedula());
    Cita nuevaCita = new Cita();

    nuevaCita.setId(newCita);
    nuevaCita.setDoctor(doctor);
    nuevaCita.setPaciente(paciente);

    citaRepository.delete(cita);

    return citaRepository.save(nuevaCita);
  }

  /**
   * Elimina una cita por su identificador único.
   *
   * @param id Identificador único de la cita a eliminar.
   * @throws ResourceNotFoundException Si no se encuentra la cita con el identificador dado.
   */
  @Override
  public void deleteCita(CitaId id) {
    citaRepository.findById(id)
      .orElseThrow(() -> new ResourceNotFoundException("Cita not found with id: " + id));

    citaRepository.deleteById(id);
  }
}
