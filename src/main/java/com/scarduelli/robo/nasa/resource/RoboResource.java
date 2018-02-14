package com.scarduelli.robo.nasa.resource;

import com.scarduelli.robo.nasa.model.Robo;
import javax.websocket.server.PathParam;
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

    private final Robo robo;
    
    public RoboResource() {
        this.robo = new Robo();
    }
    
    @RequestMapping(value = "/{movimento}", method = RequestMethod.POST)
    public ResponseEntity<Robo> movientar(@PathVariable("movimento") String movimento) {
        // Validar os comandos, soh permitidos os comandos L, R e M em uma string simples
        
        if (movimento.length() > 3) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(this.robo, HttpStatus.OK);
        }
    }
    
}
