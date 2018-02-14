package com.scarduelli.robo.nasa.model;

import com.scarduelli.robo.nasa.service.RoboService;
import com.scarduelli.robo.nasa.util.Orientacao;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author lucas-linux
 */
public class RoboTest {

    public RoboTest() {
    }

    @Test
    public void criarRobo() {
        final Robo robo = Robo.Builder.create().posicaoInicial().build();

        assertEquals((long) 0, (long) robo.getPosicao().getX());
        assertEquals((long) 0, (long) robo.getPosicao().getY());
        assertEquals(Orientacao.N, robo.getPosicao().getOrientacao());
    }

    @Test
    public void movimentarOkRotacoesDireita() throws Exception {
        final String movimentos = "MMRMMRMM";
        final Robo robo = Robo.Builder.create().posicaoInicial().build();

        RoboService.movimentar(robo, movimentos);
        assertEquals((long) 2, (long) robo.getPosicao().getX());
        assertEquals((long) 0, (long) robo.getPosicao().getY());
        assertEquals(Orientacao.S, robo.getPosicao().getOrientacao());
    }

    @Test
    public void movimentarOkMovimentoDireita() throws Exception {
        final String movimentos = "MML";
        final Robo robo = Robo.Builder.create().posicaoInicial().build();

        RoboService.movimentar(robo, movimentos);
        assertEquals((long) 0, (long) robo.getPosicao().getX());
        assertEquals((long) 2, (long) robo.getPosicao().getY());
        assertEquals(Orientacao.W, robo.getPosicao().getOrientacao());
    }

    @Test
    public void movimentarErroComandoInvalido() {
        final String movimentos = "AAA";
        final Robo robo = Robo.Builder.create().posicaoInicial().build();

        try {
            RoboService.movimentar(robo, movimentos);
            Assert.assertFalse("Erro ao validar comando.", true);
        } catch (Exception e) {
            assertEquals("Comando invalido!", e.getMessage());
        }
    }

    @Test
    public void movimentarErroPosicaoInvalida() {
        final String movimentos = "MMMMMMMMMMMMMMMMMMMMMMMM";
        final Robo robo = Robo.Builder.create().posicaoInicial().build();

        try {
            RoboService.movimentar(robo, movimentos);
            Assert.assertFalse("Erro ao validar posicao.", true);
        } catch (Exception e) {
            assertEquals("Posicao invalida!", e.getMessage());
        }
    }
}
