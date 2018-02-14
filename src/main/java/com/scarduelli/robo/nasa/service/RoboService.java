package com.scarduelli.robo.nasa.service;

import com.scarduelli.robo.nasa.model.Posicao;
import com.scarduelli.robo.nasa.model.Robo;
import com.scarduelli.robo.nasa.util.Comandos;
import com.scarduelli.robo.nasa.util.Orientacao;

/**
 * @author lucas-linux
 */
public class RoboService {

    public static Robo movimentar(final Robo robo, final String movimentos) throws Exception {

        if (!Comandos.validar(movimentos)) {
            throw new Exception("Comando invalido!");
        }

        for (int i = 0; i < movimentos.length(); i++) {
            char movimento = movimentos.charAt(i);

            if (movimento == 'M') {

                if (robo.getPosicao().getOrientacao() == Orientacao.N) {
                    robo.getPosicao().setY(robo.getPosicao().getY() + 1);
                } else if (robo.getPosicao().getOrientacao() == Orientacao.S) {
                    robo.getPosicao().setY(robo.getPosicao().getY() - 1);
                } else if (robo.getPosicao().getOrientacao() == Orientacao.E) {
                    robo.getPosicao().setX(robo.getPosicao().getX() + 1);
                } else if (robo.getPosicao().getOrientacao() == Orientacao.W) {
                    robo.getPosicao().setX(robo.getPosicao().getX() - 1);
                }

            } else if (movimento == 'L') {
                robo.getPosicao().setOrientacao(robo.getPosicao().getOrientacao().getEsquerda());

            } else if (movimento == 'R') {
                robo.getPosicao().setOrientacao(robo.getPosicao().getOrientacao().getDireita());
            }

            if (!robo.getPosicao().validar()) {
                throw new Exception("Posicao invalida!");
            }

        }

        return robo;
    }

}
