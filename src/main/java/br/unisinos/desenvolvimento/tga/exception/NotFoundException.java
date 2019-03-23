package br.unisinos.desenvolvimento.tga.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

    public NotFoundException(final String message, final Object... args) {
        super(String.format(message, args));
    }

}
