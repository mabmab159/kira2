package britanico.kira.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestException extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> HandleParamNotFound(ResourceNotFoundException ex, WebRequest request) {
        Error error = new Error(new Error.ErrorDetalle("400", "Not Found", "Resource Not Found"));
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException ex, WebRequest request) {
        Error error = new Error(
                new Error.ErrorDetalle("402", ex.getMessage(), "Argumentos invalidos o vacios"));
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleExceptionClass(Exception ex, WebRequest request){
        Error error = new Error(
                new Error.ErrorDetalle("500", "asd", "Error general"));
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @Builder
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Error {
        public ErrorDetalle error;
        public final int success = 0;

        @Builder
        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        public static class ErrorDetalle {
            public String code;
            public String message;
            public String detail;
        }

    }
}
