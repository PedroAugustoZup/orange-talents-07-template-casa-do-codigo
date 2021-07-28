package br.com.zupacademy.pedro.casadocodigo.config.exception;

public class EstadoInvalidoException extends RuntimeException {
    public EstadoInvalidoException() {
    }

    public EstadoInvalidoException(String message) {
        super(message);
    }

    public EstadoInvalidoException(String message, Throwable cause) {
        super(message, cause);
    }

    public EstadoInvalidoException(Throwable cause) {
        super(cause);
    }

    public EstadoInvalidoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
