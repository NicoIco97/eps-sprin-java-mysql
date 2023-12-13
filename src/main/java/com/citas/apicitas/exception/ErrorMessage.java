package com.citas.apicitas.exception;

import java.util.Date;

import lombok.Data;

/**
 * Clase que representa un mensaje de error personalizado para manejar excepciones.
 */
@Data
public class ErrorMessage {

    /**
     * Código de estado HTTP asociado al error.
     */
    private int statusCode;

    /**
     * Marca de tiempo que indica cuándo ocurrió el error.
     */
    private Date timeStamp;

    /**
     * Mensaje descriptivo del error.
     */
    private String message;

    /**
     * Descripción detallada del error.
     */
    private String description;

    /**
     * Constructor que inicializa los atributos de ErrorMessage.
     *
     * @param statusCode Código de estado HTTP asociado al error.
     * @param timeStamp  Marca de tiempo que indica cuándo ocurrió el error.
     * @param message    Mensaje descriptivo del error.
     * @param description Descripción detallada del error.
     */
    public ErrorMessage(int statusCode, Date timeStamp, String message, String description) {
        this.statusCode = statusCode;
        this.timeStamp = timeStamp;
        this.message = message;
        this.description = description;
    }
}
