package br.unisinos.desenvolvimento.tga.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {

    public BadRequestException(final String message, final Object... args) {
        super(String.format(message, args));
    }

}
