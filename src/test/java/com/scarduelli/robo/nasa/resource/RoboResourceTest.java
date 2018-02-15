package com.scarduelli.robo.nasa.resource;

import com.scarduelli.robo.nasa.model.Robo;
import com.scarduelli.robo.nasa.service.RoboService;
import com.scarduelli.robo.nasa.util.Orientacao;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.http.ResponseEntity;

/**
 * @author lucas-linux
 */
public class RoboResourceTest {
    
    public RoboResourceTest() {
    }

    @Test
    public void testMovimentarOkRotacoesDireita() throws Exception {
        final String movimentos = "MMRMMRMM";
        final RoboResource resource = new RoboResource();
        
        final ResponseEntity<String> response = resource.movientar(movimentos);
        assertEquals("(2, 0, S)", response.getBody());
    }
    
    @Test
    public void testMovimentarErroComandoInvalido() {
        final String movimentos = "AAA";
        final RoboResource resource = new RoboResource();
        
        final ResponseEntity<String> response = resource.movientar(movimentos);
        assertEquals(400, response.getStatusCodeValue());
    }

    @Test
    public void testMovimentarErroPosicaoInvalida() {
        final String movimentos = "MMMMMMMMMMMMMMMMMMMMMMMM";
        final RoboResource resource = new RoboResource();
        
        final ResponseEntity<String> response = resource.movientar(movimentos);
        assertEquals(400, response.getStatusCodeValue());
    }
    
    
}
