package br.com.pagarme.exceptions;

public class PagarMeApiException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public PagarMeApiException(String message) {
        super(message);
    }
}