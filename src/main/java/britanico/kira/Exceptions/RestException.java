package britanico.kira.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestException extends ResponseEntityExceptionHandler {
    /*@ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> HandleParamNotFound(RuntimeException ex, WebRequest request) {
        Error error = new Error(new Error.ErrorDetalle("400", "Not Found", "Resource Not Found"));
        return handleExceptionInternal(ex, error, new HttpHeaders(), HttpStatus.valueOf(error.getError().getCode()),
                request);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    protected ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException ex, WebRequest request) {
        Error error = new Error(
                new Error.ErrorDetalle("402", "No se cumplen los parametros", "Argumentos invalidos o vacioes"));
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

    }*/
}
