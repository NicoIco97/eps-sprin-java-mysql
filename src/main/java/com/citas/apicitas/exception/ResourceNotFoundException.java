/**
 * Excepción personalizada para indicar que un recurso no fue encontrado.
 * Esta excepción se lanza cuando se intenta acceder a un recurso que no existe.
 */
package com.citas.apicitas.exception;

public class ResourceNotFoundException extends RuntimeException {

    /**
     * Constructor que recibe un mensaje para describir la excepción.
     *
     * @param msg Mensaje descriptivo de la excepción.
     */
    public ResourceNotFoundException(String msg) {
        super(msg);
    }
}
