package com.edsongonzalo.util.encripto;

public class encripto implements encriptor {

    @Override
    public String encriptarBasico(String input) {
        StringBuilder sb = new StringBuilder(input);
        return sb.reverse().toString();
    }



}
