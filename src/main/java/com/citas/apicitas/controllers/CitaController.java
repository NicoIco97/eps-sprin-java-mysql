package com.citas.apicitas.controllers;

import java.time.LocalDateTime;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.citas.apicitas.entities.Cita;
import com.citas.apicitas.entities.CitaId;
import com.citas.apicitas.entities.Doctor;
import com.citas.apicitas.entities.Paciente;
import com.citas.apicitas.services.CitaService;
import com.citas.apicitas.services.DoctorService;
import com.citas.apicitas.services.PacienteService;

/**
 * Controlador para gestionar las operaciones relacionadas con las citas médicas.
 */
@RestController
@RequestMapping("/api/citas")
public class CitaController {

  @Autowired
  private CitaService citaService;

  @Autowired
  private DoctorService doctorService;

  @Autowired
  private PacienteService pacienteService;

  /**
   * Obtiene todas las citas médicas.
   *
   * @return ResponseEntity con el conjunto de citas médicas y estado HTTP 200 (OK).
   */
  @GetMapping("")
  public ResponseEntity<Set<Cita>> getCitas() {
    Set<Cita> citas = citaService.findAll();

    return new ResponseEntity<>(citas, HttpStatus.OK);
  }

  /**
   * Obtiene una cita médica específica mediante parámetros de consulta.
   *
   * @param idPaciente ID del paciente.
   * @param idDoctor   ID del doctor.
   * @param fecha_hora Fecha y hora de la cita.
   * @return ResponseEntity con la cita médica solicitada y estado HTTP 200 (OK).
   */
  @GetMapping("/one-cita")
  public ResponseEntity<Cita> getCita(@RequestParam Long idPaciente,
                                      @RequestParam Long idDoctor, @RequestParam LocalDateTime fecha_hora) {

    CitaId citaId = new CitaId(idDoctor, idPaciente, fecha_hora);

    Cita cita = citaService.findById(citaId);

    return new ResponseEntity<>(cita, HttpStatus.OK);
  }

  /**
   * Agrega una nueva cita médica.
   *
   * @param citaId Identificador de la cita médica.
   * @return ResponseEntity con el ID de la cita médica agregada y estado HTTP 201 (CREATED).
   */
  @PostMapping("")
  public ResponseEntity<CitaId> addCita(@RequestBody CitaId citaId) {
    Doctor doctor = doctorService.findById(citaId.getIdProfesional());
    Paciente paciente = pacienteService.findById(citaId.getIdNumeroCedula());

    Cita newCita = new Cita();

    newCita.setId(citaId);
    newCita.setDoctor(doctor);
    newCita.setPaciente(paciente);

    Cita addedCita = citaService.addCita(citaId, newCita);

    return new ResponseEntity<>(addedCita.getId(), HttpStatus.CREATED);
  }

  /**
   * Modifica una cita médica existente.
   *
   * @param citaId    Identificador de la nueva cita médica.
   * @param idPaciente ID del paciente de la cita médica existente.
   * @param idDoctor   ID del doctor de la cita médica existente.
   * @param fecha_hora Fecha y hora de la cita médica existente.
   * @return ResponseEntity con la cita médica modificada y estado HTTP 200 (OK).
   */
  @PutMapping("")
  public ResponseEntity<Cita> modifyCita(@RequestBody CitaId citaId, @RequestParam Long idPaciente,
                                         @RequestParam Long idDoctor, @RequestParam LocalDateTime fecha_hora) {

    CitaId oldCita = new CitaId(idDoctor, idPaciente, fecha_hora);

    Cita modifyCita = citaService.modifyCita(oldCita, citaId);

    return new ResponseEntity<>(modifyCita, HttpStatus.OK);
  }

  /**
   * Elimina una cita médica.
   *
   * @param id Identificador de la cita médica a eliminar.
   * @return ResponseEntity con estado HTTP 204 (NO CONTENT) indicando que la cita se eliminó con éxito.
   */
  @DeleteMapping("")
  public ResponseEntity<Void> deleteCita(@RequestBody CitaId id) {
    citaService.deleteCita(id);

    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
