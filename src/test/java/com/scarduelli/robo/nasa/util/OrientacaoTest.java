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
    
    @Test
    public void testarTodosParaDireita() {
        assertEquals(Orientacao.N.getDireita(), Orientacao.E);
        assertEquals(Orientacao.E.getDireita(), Orientacao.S);
        assertEquals(Orientacao.S.getDireita(), Orientacao.W);
        assertEquals(Orientacao.W.getDireita(), Orientacao.N);
    }
        
    @Test
    public void testarTodosParaEsquerda() {
        assertEquals(Orientacao.N.getEsquerda(), Orientacao.W);
        assertEquals(Orientacao.E.getEsquerda(), Orientacao.N);
        assertEquals(Orientacao.S.getEsquerda(), Orientacao.E);
        assertEquals(Orientacao.W.getEsquerda(), Orientacao.S);
    }
        
}
