package com.scarduelli.robo.nasa.model;

import com.scarduelli.robo.nasa.util.Orientacao;

/**
 * @author lucas-linux
 */
public class Robo {

    private Posicao posicao;

    private Robo() {
        
    }

    public Robo(final Builder builder) {
        this.posicao = new Posicao(builder.x, builder.y, builder.orientacao);
    }

    public Posicao getPosicao() {
        return this.posicao;
    }
    
    public static class Builder {

        private int x;
        private int y;
        private Orientacao orientacao;
        
        private Builder() { }
        
        public static Builder create() {
            return new Builder();
        } 
        
        public Builder x(final int x) {
            this.x = x;
            return this;
        }
        
        public Builder y(final int y) {
            this.y = y;
            return this;
        }
        
        public Builder orientacao(final Orientacao orientacao) {
            this.orientacao = orientacao;
            return this;
        }
        
        public Builder posicaoInicial() {
            this.x = 0;
            this.y = 0;
            this.orientacao = Orientacao.N;
            return this;
        }
        
        public Robo build() {
            return new Robo(this);
        }
        
    }
}
