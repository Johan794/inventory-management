package com.api.inventario.infrastructure.handler;

import com.api.inventario.application.constant.ErrorCode;
import com.api.inventario.application.error.ApplicationError;
import com.api.inventario.application.exception.ApplicationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

import static com.api.inventario.application.error.util.ErrorManager.*;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<ApplicationError> handleApplicationException(ApplicationException exception){
        return ResponseEntity.status(exception.getError().getStatus()).body(exception.getError());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApplicationError> handleMissArgumentException(MethodArgumentNotValidException exception){
        ApplicationError error = ApplicationError.builder().status(HttpStatus.BAD_REQUEST).details(List.of(sendDetails(createDetail(String.format(ErrorCode.ERROR_MISSING_ARGUMENT.getMessage(),getMissingFiled(exception)), ErrorCode.ERROR_MISSING_ARGUMENT)))).build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<ApplicationError> handleAuthException(AuthenticationException exception){
        ApplicationError error = ApplicationError.builder().status(HttpStatus.UNAUTHORIZED).details(List.of(sendDetails(createDetail(ErrorCode.ERROR_LOGIN.getMessage() , ErrorCode.ERROR_LOGIN)))).build();
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApplicationError> handleRuntimeException(RuntimeException exception){
        ApplicationError error = ApplicationError.builder().status(HttpStatus.BAD_REQUEST).details(List.of(sendDetails(createDetail( ErrorCode.RUNTIME_ERROR.getMessage()+"\n possible reason: \n"+exception.getMessage(), ErrorCode.RUNTIME_ERROR)))).build();
        return ResponseEntity.status(error.getStatus()).body(error);
    }
}
