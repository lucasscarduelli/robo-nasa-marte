package com.scarduelli.robo.nasa.util;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * @author lucas-linux
 */
public class OrientacaoTest {
    
    public OrientacaoTest() {
    }
    
    @Test
    public void testarNorteParaDireita() {
        assertEquals(Orientacao.N.getDireita(), Orientacao.E);
    }
    
    @Test
    public void testarNorteParaEsquerda() {
        assertEquals(Orientacao.N.getEsquerda(), Orientacao.W);
    }
    
    @Test
    public void testarNorteParaEsquerdaQuatroVezes() {
        assertEquals(Orientacao.N.getEsquerda().getEsquerda()
                .getEsquerda().getEsquerda(), Orientacao.N);
    }
    
}
