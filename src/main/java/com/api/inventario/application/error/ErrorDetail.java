package com.api.inventario.application.error;

import com.api.inventario.application.constant.ErrorCode;
import lombok.*;


@Builder
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class ErrorDetail {
    private ErrorCode errorCode;
    private String errorMessage;
}
