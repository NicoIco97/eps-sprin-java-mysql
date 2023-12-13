/**
 * La interfaz CitaService define los métodos para gestionar citas en una aplicación.
 */
package com.citas.apicitas.services;

import java.util.Set;

import com.citas.apicitas.entities.Cita;
import com.citas.apicitas.entities.CitaId;

public interface CitaService {

  /**
   * Recupera todas las citas disponibles en el sistema.
   *
   * @return Un conjunto de objetos Cita representando todas las citas disponibles.
   */
  Set<Cita> findAll();

  /**
   * Busca una cita por su identificador único.
   *
   * @param id El identificador único de la cita a buscar.
   * @return La cita correspondiente al identificador proporcionado, o null si no se encuentra.
   */
  Cita findById(CitaId id);

  /**
   * Agrega una nueva cita al sistema.
   *
   * @param id   El identificador único de la nueva cita.
   * @param cita La cita a agregar al sistema.
   * @return La cita recién agregada.
   */
  Cita addCita(CitaId id, Cita cita);

  /**
   * Modifica una cita existente en el sistema.
   *
   * @param id      El identificador único de la cita a modificar.
   * @param newCita El nuevo identificador único de la cita.
   * @return La cita modificada.
   */
  Cita modifyCita(CitaId id, CitaId newCita);

  /**
   * Elimina una cita del sistema.
   *
   * @param id El identificador único de la cita a eliminar.
   */
  void deleteCita(CitaId id);

}
