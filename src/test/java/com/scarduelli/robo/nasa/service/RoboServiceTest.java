/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scarduelli.robo.nasa.service;

import com.scarduelli.robo.nasa.model.Robo;
import com.scarduelli.robo.nasa.util.Orientacao;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lucas-linux
 */
public class RoboServiceTest {
    
    public RoboServiceTest() {
    }

    @Test
    public void testarMovimentar() {
        final Robo robo = Robo.Builder.create().posicaoInicial().build();
        try {
            RoboService.movimentar(robo, "MMRMM");
            assertEquals((int) 2, (int) robo.getPosicao().getX());
            assertEquals((int) 2, (int) robo.getPosicao().getY());
            assertEquals(Orientacao.E, robo.getPosicao().getOrientacao());
        } catch (Exception ex) {
            assertFalse("Erro ao movimentar robo.", true);
        }
    }
}
