package org.galla.compartidos;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}