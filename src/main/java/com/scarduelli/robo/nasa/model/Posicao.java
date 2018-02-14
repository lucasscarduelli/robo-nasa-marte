package com.scarduelli.robo.nasa.model;

import com.scarduelli.robo.nasa.util.Orientacao;

/**
 *
 * @author lucas-linux
 */
public class Posicao {

    private Integer x;
    private Integer y;
    private Orientacao orientacao;

    private Posicao() {
    }

    public Posicao(Integer x, Integer y, Orientacao orientacao) {
        this.x = x;
        this.y = y;
        this.orientacao = orientacao;
    }

    public void setX(final Integer x) {
        this.x = x;
    }

    public void setY(final Integer y) {
        this.y = y;
    }

    public void setOrientacao(final Orientacao orientacao) {
        this.orientacao = orientacao;
    }

    public Integer getX() {
        return this.x;
    }

    public Integer getY() {
        return this.y;
    }

    public Orientacao getOrientacao() {
        return this.orientacao;
    }

    @Override
    public String toString() {
        return "(" + this.getX() + ", " + this.getY() + ", " + 
                this.getOrientacao().getLetra() + ")";
    }

    public boolean validar() {
        
        if (this.getX() < 0 || this.getX() > 5) {
            return false;
        }
        
        if (this.getY() < 0 || this.getY() > 5) {
            return false;
        }
        
        return true;
    }
}
