package com.scarduelli.robo.nasa.model;

import com.scarduelli.robo.nasa.util.Comandos;
import com.scarduelli.robo.nasa.util.Orientacao;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author lucas-linux
 */
public class Robo {

    // Criar o builder para o robo.
    private Integer id;
    private Posicao posicao;

    public Robo() {
        this.posicao = new Posicao(0, 0, Orientacao.N);
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public void setPosicao(final Posicao posicao) {
        this.posicao = posicao;
    }

    public Integer getId() {
        return this.id;
    }

    public Posicao getPosicao() {
        return this.posicao;
    }

    public Posicao movimentar(final String movimentos) throws Exception {

        if (!Comandos.validar(movimentos)) {
            throw new Exception("Comando invalido!");
        }

        for (int i = 0; i < movimentos.length(); i++) {
            char movimento = movimentos.charAt(i);

            if (movimento == 'M') {

                if (this.getPosicao().getOrientacao() == Orientacao.N) {
                    this.getPosicao().setY(this.getPosicao().getY() + 1);
                } else if (this.getPosicao().getOrientacao() == Orientacao.S) {
                    this.getPosicao().setY(this.getPosicao().getY() - 1);
                } else if (this.getPosicao().getOrientacao() == Orientacao.E) {
                    this.getPosicao().setX(this.getPosicao().getX() + 1);
                } else if (this.getPosicao().getOrientacao() == Orientacao.W) {
                    this.getPosicao().setX(this.getPosicao().getX() - 1);
                }

            } else if (movimento == 'L') {
                this.getPosicao().setOrientacao(this.getPosicao().getOrientacao().getEsquerda());

            } else if (movimento == 'R') {
                this.getPosicao().setOrientacao(this.getPosicao().getOrientacao().getDireita());
            }

            if (!this.getPosicao().validar()) {
                throw new Exception("Posicao invalida!");
            }

        }

        return this.getPosicao();
    }
}
