package com.matteof_mattos.exe003.controller.handler;

import com.matteof_mattos.exe003.DTO.CustomErrorDTO;
import com.matteof_mattos.exe003.DTO.FIeldMessege;
import com.matteof_mattos.exe003.DTO.ValidationError;
import com.matteof_mattos.exe003.exceptions.DatabaseException;
import com.matteof_mattos.exe003.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;
import java.util.List;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CustomErrorDTO> resourceNotFoundException
            (ResourceNotFoundException exc, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        CustomErrorDTO error = new CustomErrorDTO(Instant.now(),status.value(),exc.getMessage(),request.getRequestURI());
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<CustomErrorDTO> dataIntegrityViolation
            (DatabaseException exc, HttpServletRequest request){
        HttpStatus status = HttpStatus.CONFLICT;
        CustomErrorDTO error = new CustomErrorDTO(Instant.now(),status.value(),exc.getMessage(),request.getRequestURI());
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomErrorDTO> MethodArgumentNotValid
            (MethodArgumentNotValidException exc, HttpServletRequest request){
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        ValidationError error = new ValidationError(Instant.now(),status.value(),"Dados inválidos ",request.getRequestURI());

        List<FieldError> fieldErrors = exc.getBindingResult().getFieldErrors();
        for (FieldError fieldError: fieldErrors){
            error.addFieldMessege(new FIeldMessege(fieldError.getField(),fieldError.getDefaultMessage()));
        }

        return ResponseEntity.status(status).body(error);
    }
}
