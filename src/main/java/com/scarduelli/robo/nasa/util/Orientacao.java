package com.scarduelli.robo.nasa.util;

/**
 * @author lucas-linux
 */
public enum Orientacao {

    N("N", "E", "W"), E("E","S","N"), S("S","W","E"), W("W","N","S");

    private final String letra;
    private final String direita;
    private final String esquerda;

    private Orientacao(final String letra, final String direita, final String esquerda) {
        this.letra = letra;
        this.direita = direita;
        this.esquerda = esquerda;
    }

    private Orientacao fromValue(final String value) {

        for(Orientacao orientacao : values()) {
            if (orientacao.letra.equals(value)) return orientacao;
        }
        return null;        
    }
    
    public Orientacao getDireita() {
        return fromValue(this.direita);
    }
    
    public Orientacao getEsquerda() {
        return fromValue(this.esquerda);
    }
    
    public String getLetra() {
        return this.letra;
    }
}
