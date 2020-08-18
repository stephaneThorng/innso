package com.innso.web.exception;

import java.time.OffsetDateTime;
import javassist.NotFoundException;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestControllerAdvice
public class ExceptionHandlerControllerAdvice extends ResponseEntityExceptionHandler {

  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<Object> notFoundExceptionHandler(NotFoundException exception) {
    final ApiErrorDto apiErrorDto = buildApiError("RESSOURCE_INCONNUE", exception.getMessage());
    return buildResponseEntity(HttpStatus.NOT_FOUND, apiErrorDto);
  }


  @ExceptionHandler(IllegalArgumentException.class)
  public ResponseEntity<Object> illegalArgumentExceptionHandler(
      IllegalArgumentException exception) {
    final ApiErrorDto apiErrorDto = buildApiError("DONNEE_INTERDITE", exception.getMessage());
    return buildResponseEntity(HttpStatus.BAD_REQUEST, apiErrorDto);
  }


  @ExceptionHandler(Exception.class)
  public ResponseEntity<Object> otherExceptionHandler(Exception exception) {
    final ApiErrorDto apiErrorDto = buildApiError("ERREUR_SERVEUR",
        "Une erreur technique est survenue");
    log.error("Erreur technique : {} ", exception.getMessage(), exception);
    return buildResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR, apiErrorDto);
  }

  private ResponseEntity<Object> buildResponseEntity(HttpStatus status, ApiErrorDto apiErrorDto) {
    return new ResponseEntity<>(apiErrorDto, status);
  }

  public static ApiErrorDto buildApiError(String code, String message) {
    final ApiErrorDto apiErrorDto = new ApiErrorDto();
    apiErrorDto.setCode(code);
    apiErrorDto.setMessage(message);
    apiErrorDto.setTimestamp(OffsetDateTime.now());
    return apiErrorDto;
  }

  @Getter
  @Setter
  private static class ApiErrorDto {

    private String code;
    private String message;
    private OffsetDateTime timestamp;

  }
}
