package com.api.inventario.application.error.util;

import com.api.inventario.application.constant.ErrorCode;
import com.api.inventario.application.error.ErrorDetail;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import  java.util.List;

public class ErrorManager {

    public static String fields = "";
    public static ErrorDetail createDetail(String message, ErrorCode errorCode){
        return ErrorDetail.builder().errorCode(errorCode).errorMessage(message).build();
    }

    public static ErrorDetail[] sendDetails(ErrorDetail ... details){
        return details;
    }

    public static String getMissingFiled(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        if (!bindingResult.hasErrors()) {
            return "";
        }
        List<FieldError> fieldErrorList = bindingResult.getFieldErrors();

        fieldErrorList.stream().map(FieldError::getField).forEach(fieldName -> fields+=fieldName+" ");
        return fields;
    }
}
