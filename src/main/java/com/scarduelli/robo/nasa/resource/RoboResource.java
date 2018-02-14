package com.scarduelli.robo.nasa.resource;

import com.scarduelli.robo.nasa.model.Posicao;
import com.scarduelli.robo.nasa.model.Robo;
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
    
    @RequestMapping(value = "/{movimento}", method = RequestMethod.POST)
    public ResponseEntity<String> 
        movientar(@PathVariable("movimento") String movimento) {
        
        try {
            final Robo robo = new Robo();
            final Posicao posicao = robo.movimentar(movimento);

            return new ResponseEntity<>(posicao.toString(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
}
