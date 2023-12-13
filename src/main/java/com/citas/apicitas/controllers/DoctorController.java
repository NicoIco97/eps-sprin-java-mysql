package com.citas.apicitas.controllers;

import org.springframework.web.bind.annotation.*;
import com.citas.apicitas.entities.Doctor;
import com.citas.apicitas.services.DoctorService;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * Clase controladora para gestionar las operaciones relacionadas con los doctores.
 */
@RestController
@RequestMapping("/api/doctores")
public class DoctorController {

  @Autowired
  private DoctorService doctorService;

  /**
   * Obtiene la lista de todos los doctores.
   *
   * @return ResponseEntity con la lista de doctores y el estado HTTP 200 (OK).
   */
  @GetMapping("")
  public ResponseEntity<Set<Doctor>> getDoctors() {
    Set<Doctor> doctors = doctorService.findAll();
    return new ResponseEntity<>(doctors, HttpStatus.OK);
  }

  /**
   * Obtiene un doctor específico por su identificador.
   *
   * @param id Identificador único del doctor.
   * @return ResponseEntity con el doctor encontrado y el estado HTTP 200 (OK).
   */
  @GetMapping("/{id}")
  public ResponseEntity<Doctor> getDoctor(@PathVariable Long id) {
    Doctor doctor = doctorService.findById(id);
    return new ResponseEntity<>(doctor, HttpStatus.OK);
  }

  /**
   * Obtiene la lista de doctores por especialidad.
   *
   * @param especialidad Especialidad de los doctores a buscar.
   * @return ResponseEntity con la lista de doctores y el estado HTTP 200 (OK).
   */
  @GetMapping("/especialidad/{especialidad}")
  public ResponseEntity<Set<Doctor>> getDoctorsByEspecialidad(@PathVariable Doctor.Especialidad especialidad) {
    Set<Doctor> doctors = doctorService.findAllByEspecialidad(especialidad);
    return new ResponseEntity<>(doctors, HttpStatus.OK);
  }

  /**
   * Agrega un nuevo doctor.
   *
   * @param doctor Objeto Doctor que se va a agregar.
   * @return ResponseEntity con el nuevo doctor y el estado HTTP 201 (CREATED).
   */
  @PostMapping("")
  public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor) {
    Doctor newDoctor = doctorService.addDoctor(doctor);
    return new ResponseEntity<>(newDoctor, HttpStatus.CREATED);
  }

  /**
   * Modifica un doctor existente por su identificador.
   *
   * @param id Identificador único del doctor a modificar.
   * @param doctor Objeto Doctor con los datos actualizados.
   * @return ResponseEntity con el doctor modificado y el estado HTTP 200 (OK).
   */
  @PutMapping("/{id}")
  public ResponseEntity<Doctor> modifyDoctor(@PathVariable Long id, @RequestBody Doctor doctor) {
    Doctor modifiedDoctor = doctorService.modifyDoctor(id, doctor);
    return new ResponseEntity<>(modifiedDoctor, HttpStatus.OK);
  }

  /**
   * Elimina un doctor por su identificador.
   *
   * @param id Identificador único del doctor a eliminar.
   * @return ResponseEntity con el estado HTTP 204 (NO_CONTENT) indicando que la operación fue exitosa.
   */
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteDoctor(@PathVariable Long id) {
    doctorService.deleteDoctor(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
