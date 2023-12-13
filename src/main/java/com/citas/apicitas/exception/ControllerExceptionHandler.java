/**
 * Clase que maneja las excepciones globales lanzadas por los controladores.
 * Proporciona métodos de manejo de excepciones para diferentes tipos de errores.
 */
@RestControllerAdvice
public class ControllerExceptionHandler {

  /**
   * Maneja la excepción de recurso no encontrado (ResourceNotFoundException).
   *
   * @param ex      La excepción de recurso no encontrado.
   * @param request La solicitud web asociada.
   * @return Un objeto ErrorMessage con detalles sobre el error.
   */
  @ExceptionHandler(ResourceNotFoundException.class)
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  public ErrorMessage resourceNotFoundException(ResourceNotFoundException ex, WebRequest request){
    ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND.value(), new Date(), ex.getMessage(), request.getDescription(false));
    return message;
  }

  /**
   * Maneja excepciones generales (Exception) que no están específicamente manejadas por otros métodos.
   *
   * @param ex      La excepción general.
   * @param request La solicitud web asociada.
   * @return Un objeto ErrorMessage con detalles sobre el error.
   */
  @ExceptionHandler(Exception.class)
  @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
  public ErrorMessage globalExceptionHandler(Exception ex, WebRequest request){
    ErrorMessage message = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), new Date(), ex.getMessage(), request.getDescription(false));
    return message;
  }

  /**
   * Maneja la excepción de violación de integridad de datos (DataIntegrityViolationException).
   *
   * @param ex      La excepción de violación de integridad de datos.
   * @param request La solicitud web asociada.
   * @return Un objeto ErrorMessage con detalles sobre el error.
   */
  @ExceptionHandler(DataIntegrityViolationException.class)
  @ResponseStatus(value = HttpStatus.CONFLICT)
  public ErrorMessage constraintViolationException(DataIntegrityViolationException ex, WebRequest request){
    ErrorMessage message = new ErrorMessage(HttpStatus.CONFLICT.value(), new Date(), ex.getMessage(), request.getDescription(false));
    return message;
  }
}
