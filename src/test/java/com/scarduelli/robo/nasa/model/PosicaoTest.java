package com.scarduelli.robo.nasa.model;

import com.scarduelli.robo.nasa.util.Orientacao;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lucas-linux
 */
public class PosicaoTest {
    
    public PosicaoTest() {
    }
    
    @Test
    public void testarPosicaoCorreta() {
        final Posicao posicao = new Posicao(0, 0, Orientacao.N);
        assertTrue("Validar posicao correta.", posicao.validar());
    }
    
    @Test
    public void testarPosicaoXErradaMenorQueZero() {
        final Posicao posicao = new Posicao(-1, 0, Orientacao.N);
        assertFalse("Validar posicao errada X.", posicao.validar());
    }
    
    @Test
    public void testarPosicaoXErradaMaiorQueCinco() {
        final Posicao posicao = new Posicao(6, 0, Orientacao.N);
        assertFalse("Validar posicao errada X.", posicao.validar());
    }
    
    @Test
    public void testarPosicaoYErradaMenorQueZero() {
        final Posicao posicao = new Posicao(0, -1, Orientacao.N);
        assertFalse("Validar posicao errada Y.", posicao.validar());
    }
    
    @Test
    public void testarPosicaoYErradaMaiorQueCinco() {
        final Posicao posicao = new Posicao(0, 6, Orientacao.N);
        assertFalse("Validar posicao errada Y.", posicao.validar());
    }
    
}
