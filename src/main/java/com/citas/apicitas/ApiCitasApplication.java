/**
 * La clase principal de la aplicación que inicia la ejecución de la API de Citas.
 * Utiliza la anotación {@link org.springframework.boot.autoconfigure.SpringBootApplication}
 * para indicar que es una clase de aplicación de Spring Boot.
 */
@SpringBootApplication
public class ApiCitasApplication {

    /**
     * Método principal que inicia la aplicación Spring Boot.
     *
     * @param args Argumentos de línea de comandos que se pueden proporcionar al iniciar la aplicación.
     */
    public static void main(String[] args) {
        SpringApplication.run(ApiCitasApplication.class, args);
    }

}
