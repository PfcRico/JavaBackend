package com.backend.javabackend.customexception;

import org.springframework.stereotype.Component;

@Component
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private String errorCode;
    private String errorMessage;
    private String field;

    public BusinessException(){}

    public BusinessException(String errorCode, String errorMessage, String field) {
        super();
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.field = field;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}
