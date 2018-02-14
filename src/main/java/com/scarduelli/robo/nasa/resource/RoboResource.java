package com.scarduelli.robo.nasa.resource;

import com.scarduelli.robo.nasa.model.Posicao;
import com.scarduelli.robo.nasa.model.Robo;
import com.scarduelli.robo.nasa.service.RoboService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lucas-linux
 */
@RestController
@RequestMapping(value = "/rest/mars")
public class RoboResource {

    public RoboResource() {
    }
    
    @RequestMapping(value = "/{movimentos}", method = RequestMethod.POST)
    public ResponseEntity<String> 
        movientar(@PathVariable("movimentos") String movimentos) {
        
        try {
            Robo robo = Robo.Builder.create().posicaoInicial().build();
            robo = RoboService.movimentar(robo, movimentos);
            String retorno = robo.getPosicao().toString();
            return new ResponseEntity<>(retorno, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
}
