package com.finalgastos.gastosApi.exception;

public class ErrorDeValidacionExcepcion extends RuntimeException {
    public ErrorDeValidacionExcepcion(String mensaje) {
        super(mensaje);
    }
}