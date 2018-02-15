package com.scarduelli.robo.nasa.service;

import com.scarduelli.robo.nasa.model.Posicao;
import com.scarduelli.robo.nasa.model.Robo;
import com.scarduelli.robo.nasa.util.Comandos;
import com.scarduelli.robo.nasa.util.Orientacao;

/**
 * @author lucas-linux
 */
public class RoboService {

    private static void movimentarParaFrente(final Robo robo) {
        switch (robo.getPosicao().getOrientacao()) {
            case N:
                robo.getPosicao().setY(robo.getPosicao().getY() + 1);
                break;
            case S:
                robo.getPosicao().setY(robo.getPosicao().getY() - 1);
                break;
            case E:
                robo.getPosicao().setX(robo.getPosicao().getX() + 1);
                break;
            case W:
                robo.getPosicao().setX(robo.getPosicao().getX() - 1);
                break;
            default:
                break;
        }
    }
    
    private static void movimentarParaEsquerda(final Robo robo) {
        robo.getPosicao().setOrientacao(
                robo.getPosicao().getOrientacao().getEsquerda());
    }
    
    private static void movimentarParaDireita(final Robo robo) {
        robo.getPosicao().setOrientacao(
                robo.getPosicao().getOrientacao().getDireita());
    }
    
    public static Robo movimentar(final Robo robo, final String movimentos) throws Exception {

        if (!Comandos.validar(movimentos)) {
            throw new Exception("Comando invalido!");
        }

        for (int i = 0; i < movimentos.length(); i++) {
            String movimento = String.valueOf(movimentos.charAt(i));
            
            switch (movimento) {
                case "M": movimentarParaFrente(robo); break;
                case "L": movimentarParaEsquerda(robo); break;
                case "R": movimentarParaDireita(robo); break;
                default: break;
            }

            if (!robo.getPosicao().validar()) {
                throw new Exception("Posicao invalida!");
            }

        }

        return robo;
    }

}
