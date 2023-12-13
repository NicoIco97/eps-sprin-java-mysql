package com.citas.apicitas.services;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.citas.apicitas.entities.Doctor;
import com.citas.apicitas.exception.ResourceNotFoundException;
import com.citas.apicitas.repositories.DoctorRepository;

/**
 * Implementación de la interfaz {@link DoctorService}.
 * Proporciona servicios para gestionar entidades Doctor.
 */
@Service
public class DoctorServiceImpl implements DoctorService {

  @Autowired
  private DoctorRepository doctorRepository;

  /**
   * Recupera todos los doctores disponibles.
   *
   * @return Conjunto de objetos {@link Doctor}.
   */
  @Override
  public Set<Doctor> findAll() {
    return doctorRepository.findAll();
  }

  /**
   * Recupera un doctor por su identificador.
   *
   * @param id Identificador del doctor.
   * @return Objeto {@link Doctor} correspondiente al identificador proporcionado.
   * @throws ResourceNotFoundException Si no se encuentra un doctor con el identificador especificado.
   */
  @Override
  public Doctor findById(Long id) {
    Doctor doctor = doctorRepository.findById(id)
      .orElseThrow(() -> new ResourceNotFoundException("Doctor not found with id: " + id));

    return doctor;
  }

  /**
   * Agrega un nuevo doctor.
   *
   * @param doctor Objeto {@link Doctor} a agregar.
   * @return Objeto {@link Doctor} agregado.
   * @throws DataIntegrityViolationException Si ya existe un doctor con la misma clave primaria.
   */
  @Override
  public Doctor addDoctor(Doctor doctor) {
    Optional<Doctor> doctorExist = doctorRepository.findById(doctor.getIdProfesional());

    if (doctorExist.isPresent()) {
      throw new DataIntegrityViolationException("Primary key already exists");
    } else {
      return doctorRepository.save(doctor);
    }
  }

  /**
   * Modifica un doctor existente.
   *
   * @param id        Identificador del doctor a modificar.
   * @param newDoctor Objeto {@link Doctor} con las nuevas propiedades.
   * @return Objeto {@link Doctor} modificado.
   * @throws ResourceNotFoundException Si no se encuentra un doctor con el identificador especificado.
   */
  @Override
  public Doctor modifyDoctor(Long id, Doctor newDoctor) {
    Doctor doctor = doctorRepository.findById(id)
      .orElseThrow(() -> new ResourceNotFoundException("Doctor not found with id: " + id));

    newDoctor.setIdProfesional(doctor.getIdProfesional());

    return doctorRepository.save(newDoctor);
  }

  /**
   * Elimina un doctor por su identificador.
   *
   * @param id Identificador del doctor a eliminar.
   * @throws ResourceNotFoundException Si no se encuentra un doctor con el identificador especificado.
   */
  @Override
  public void deleteDoctor(Long id) {
    doctorRepository.findById(id)
      .orElseThrow(() -> new ResourceNotFoundException("Doctor not found with id: " + id));

    doctorRepository.deleteById(id);
  }

  /**
   * Recupera todos los doctores por su especialidad.
   *
   * @param especialidad Especialidad de los doctores a recuperar.
   * @return Conjunto de objetos {@link Doctor} con la especialidad especificada.
   */
  @Override
  public Set<Doctor> findAllByEspecialidad(Doctor.Especialidad especialidad) {
    return doctorRepository.findAllByEspecialidad(especialidad);
  }
}
