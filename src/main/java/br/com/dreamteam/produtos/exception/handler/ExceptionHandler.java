package br.com.dreamteam.produtos.exception.handler;

import br.com.dreamteam.produtos.exception.BusinessException;
import br.com.dreamteam.produtos.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<HandleError> handleResourceNotFoundException(ResourceNotFoundException e, HttpServletRequest request) {
        HandleError handleError = new HandleError(e, HttpStatus.NOT_FOUND, request.getRequestURI());
        handleError.setError("Resource not found");

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(handleError);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler({BusinessException.class})
    public ResponseEntity<HandleError> handleBusinessException(BusinessException e, HttpServletRequest request) {
        HandleError handleError = new HandleError(e, HttpStatus.BAD_REQUEST, request.getRequestURI());
        handleError.setError("Business exception");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(handleError);
    }
}
