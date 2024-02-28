package com.api.inventario.application.error;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.List;
@Getter
@Builder
@AllArgsConstructor
public class ApplicationError {
    private HttpStatus status;
    private List<ErrorDetail> details;
}