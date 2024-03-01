package com.api.inventario.application.exception.util;

import com.api.inventario.application.constant.ErrorCode;
import com.api.inventario.application.error.ApplicationError;
import com.api.inventario.application.exception.ApplicationException;
import org.springframework.http.HttpStatus;

import java.util.List;

import static com.api.inventario.application.error.util.ErrorManager.createDetail;
import static com.api.inventario.application.error.util.ErrorManager.sendDetails;

public class ExceptionUtils {
    public static void throwException(String message , HttpStatus httpStatus , ErrorCode errorCode) {
        throw new ApplicationException(message,
                ApplicationError.builder()
                        .status(httpStatus)
                        .details(List.of(sendDetails(createDetail(errorCode.getMessage(),errorCode)))).build());
    }
}
