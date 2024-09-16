package com.sergiofcamejo.veterinaria.exception;

public class DuenioSinMascotaException extends RuntimeException{

    public DuenioSinMascotaException(String mensaje){
        super(mensaje);
    }
}
