/**
 * The {@code DoctorRepository} interface extends the Spring Data {@code CrudRepository}
 * and provides methods for accessing and managing {@code Doctor} entities in the database.
 */
package com.citas.apicitas.repositories;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import com.citas.apicitas.entities.Doctor;

public interface DoctorRepository extends CrudRepository<Doctor, Long> {

  /**
   * Retrieves all doctors from the database.
   *
   * @return a {@code Set} containing all doctors in the database.
   */
  Set<Doctor> findAll();

  /**
   * Retrieves all doctors from the database with a specific specialization.
   *
   * @param especialidad The {@code Especialidad} (specialization) of the doctors to be retrieved.
   * @return a {@code Set} containing all doctors with the specified specialization.
   */
  Set<Doctor> findAllByEspecialidad(Doctor.Especialidad especialidad);

}
