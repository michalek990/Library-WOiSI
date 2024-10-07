package com.wp.library.shared.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ErrorResponse implements Serializable {

    private int status;
    private String error;
    private String message;
    @JsonProperty("timestamp")
    private String timeStamp;

    public static ErrorResponse from(String msg, int status, String error, String time){
        return ErrorResponse.builder()
                .status(status)
                .error(error)
                .message(msg)
                .timeStamp(time)
                .build();
    }
}
