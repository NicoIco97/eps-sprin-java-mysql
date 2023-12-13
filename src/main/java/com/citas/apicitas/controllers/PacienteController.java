package com.citas.apicitas.controllers;

import org.springframework.web.bind.annotation.*;
import com.citas.apicitas.entities.Paciente;
import com.citas.apicitas.services.PacienteService;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * Controlador REST que maneja las operaciones relacionadas con los pacientes.
 */
@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

  @Autowired
  private PacienteService pacienteService;

  /**
   * Obtiene todos los pacientes.
   *
   * @return ResponseEntity con el conjunto de pacientes y el estado HTTP OK.
   */
  @GetMapping("")
  public ResponseEntity<Set<Paciente>> getPacientes() {
    Set<Paciente> pacientes = pacienteService.findAll();
    return new ResponseEntity<>(pacientes, HttpStatus.OK);
  }

  /**
   * Obtiene un paciente por su identificador.
   *
   * @param id Identificador del paciente.
   * @return ResponseEntity con el paciente y el estado HTTP OK.
   */
  @GetMapping("/{id}")
  public ResponseEntity<Paciente> getPaciente(@PathVariable Long id) {
    Paciente paciente = pacienteService.findById(id);
    return new ResponseEntity<>(paciente, HttpStatus.OK);
  }

  /**
   * Agrega un nuevo paciente.
   *
   * @param paciente El paciente a agregar.
   * @return ResponseEntity con el nuevo paciente y el estado HTTP CREATED.
   */
  @PostMapping("")
  public ResponseEntity<Paciente> addPaciente(@RequestBody Paciente paciente) {
    Paciente newPaciente = pacienteService.addPaciente(paciente);
    return new ResponseEntity<>(newPaciente, HttpStatus.CREATED);
  }

  /**
   * Modifica un paciente existente por su identificador.
   *
   * @param id       Identificador del paciente a modificar.
   * @param paciente Datos actualizados del paciente.
   * @return ResponseEntity con el paciente modificado y el estado HTTP OK.
   */
  @PutMapping("/{id}")
  public ResponseEntity<Paciente> modifyPaciente(@PathVariable Long id, @RequestBody Paciente paciente) {
    Paciente modifyPaciente = pacienteService.modifyPaciente(id, paciente);
    return new ResponseEntity<>(modifyPaciente, HttpStatus.OK);
  }

  /**
   * Elimina un paciente por su identificador.
   *
   * @param id Identificador del paciente a eliminar.
   * @return ResponseEntity con el estado HTTP NO_CONTENT.
   */
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletePaciente(@PathVariable Long id) {
    pacienteService.deletePaciente(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
