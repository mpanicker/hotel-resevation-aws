package com.techpro.api.hotelreservation.exception;

import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

public class ReservationException extends RuntimeException {
    public static final String MSG_KEY = "message";
    public static final String STATUS_KEY = "status";


    private String errorMessage;
    private Integer errorCode;
    private HttpStatus httpStatus;

    public ReservationException(final String message, final Integer code, final HttpStatus httpStatus) {
        setErrorMessage(message);
        setErrorCode(code);
        setHttpStatus(httpStatus);
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    /**
     * Wraps the {@code error code} and {@code error message} as {@code JSON}
     *
     * @return {@link Map}< {@link String}, {@link Object} > contains {@code status} as error code and {@code message}
     */
    public Map<String, Object> getJsonMessage() {
        return new HashMap<String, Object>() {
            private static final long serialVersionUID = 3329895369181758505L;

            {
                put(MSG_KEY, errorMessage);
                put(STATUS_KEY, errorCode);
            }
        };
    }
}
