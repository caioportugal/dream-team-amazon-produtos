package br.com.dreamteam.produtos.exception.handler;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.Instant;

@Data
public class HandleError {

    private Instant timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;
    @JsonIgnore
    private HttpStatus httpStatus;

    public HandleError(RuntimeException e, HttpStatus httpStatus, String path) {
        this.timestamp = Instant.now();
        this.httpStatus = httpStatus;
        this.status = httpStatus.value();
        this.message = e.getMessage();
        this.path = path;
    }
}
