package com.husqvarna.todo.exceptions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorResponse implements Serializable {
    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = -7635128853462319333L;


    private String errorCode;

    private String errorMessage;

    private int httpResponseCode;

    private String errorMoreInfo;

    @JsonIgnore
    private Throwable cause;
}