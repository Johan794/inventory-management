package com.api.inventario.application.exception;

import com.api.inventario.application.error.ApplicationError;
import lombok.Getter;

@Getter
public class ApplicationException extends  RuntimeException{
    private final ApplicationError error;

    public ApplicationException(String message, ApplicationError error){
        super(message);
        this.error = error;
    }

}

