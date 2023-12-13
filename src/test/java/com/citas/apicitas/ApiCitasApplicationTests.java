/**
 * Clase de pruebas para verificar la carga del contexto de la aplicación.
 * Se utiliza la anotación {@code SpringBootTest} para indicar que esta clase es una prueba de Spring Boot
 * y que se debe cargar el contexto de la aplicación antes de ejecutar las pruebas.
 * La prueba en sí se realiza en el método {@code contextLoads()}, que está vacío en este caso.
 * 
 * @author TuNombre
 * @version 1.0
 * @since 2023-12-13
 */
package com.citas.apicitas;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApiCitasApplicationTests {

    /**
     * Método de prueba que verifica la carga del contexto de la aplicación.
     * Este método está vacío ya que la prueba se centra en asegurar que el contexto de la aplicación se cargue correctamente.
     */
    @Test
    void contextLoads() {
    }

}
