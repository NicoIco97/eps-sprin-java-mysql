package com.citas.apicitas.services;

import java.util.Set;

import com.citas.apicitas.entities.Paciente;

/**
 * Interface que define los servicios relacionados con la gestión de pacientes.
 */
public interface PacienteService {

    /**
     * Recupera todos los pacientes almacenados.
     *
     * @return Conjunto de pacientes.
     */
    Set<Paciente> findAll();

    /**
     * Busca un paciente por su identificador único.
     *
     * @param id Identificador único del paciente.
     * @return Paciente encontrado, o null si no se encuentra.
     */
    Paciente findById(Long id);

    /**
     * Agrega un nuevo paciente al sistema.
     *
     * @param paciente Paciente a agregar.
     * @return Paciente recién creado.
     */
    Paciente addPaciente(Paciente paciente);

    /**
     * Modifica la información de un paciente existente.
     *
     * @param id       Identificador único del paciente a modificar.
     * @param paciente Nuevos datos del paciente.
     * @return Paciente modificado.
     */
    Paciente modifyPaciente(Long id, Paciente paciente);

    /**
     * Elimina un paciente del sistema por su identificador único.
     *
     * @param id Identificador único del paciente a eliminar.
     */
    void deletePaciente(Long id);
}
