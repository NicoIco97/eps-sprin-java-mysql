/**
 * The {@code DoctorService} interface defines the contract for managing Doctor entities.
 * It provides methods for retrieving, adding, modifying, and deleting Doctor instances.
 */
package com.citas.apicitas.services;

import java.util.Set;

import com.citas.apicitas.entities.Doctor;

public interface DoctorService {

  /**
   * Retrieves all Doctor instances.
   *
   * @return a set of Doctor instances
   */
  Set<Doctor> findAll();

  /**
   * Retrieves a Doctor instance by its unique identifier.
   *
   * @param id the unique identifier of the Doctor
   * @return the Doctor instance with the specified ID, or {@code null} if not found
   */
  Doctor findById(Long id);

  /**
   * Retrieves all Doctor instances with the specified specialty.
   *
   * @param especialidad the specialty to filter by
   * @return a set of Doctor instances with the specified specialty
   */
  Set<Doctor> findAllByEspecialidad(Doctor.Especialidad especialidad);

  /**
   * Adds a new Doctor instance.
   *
   * @param doctor the Doctor instance to be added
   * @return the added Doctor instance
   */
  Doctor addDoctor(Doctor doctor);

  /**
   * Modifies an existing Doctor instance.
   *
   * @param id     the unique identifier of the Doctor to be modified
   * @param doctor the modified Doctor instance
   * @return the modified Doctor instance
   */
  Doctor modifyDoctor(Long id, Doctor doctor);

  /**
   * Deletes a Doctor instance by its unique identifier.
   *
   * @param id the unique identifier of the Doctor to be deleted
   */
  void deleteDoctor(Long id);
}
