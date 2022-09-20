package ac.challenge.ortogoloso.controller;

import ac.challenge.ortogoloso.controller.request.DettaglioSaveBody;
import ac.challenge.ortogoloso.dto.DettaglioDto;
import ac.challenge.ortogoloso.service.DettaglioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dettaglio")
public class DettaglioController {

    @Autowired
    DettaglioService dettaglioService;

    Logger logger = LoggerFactory.getLogger(DettaglioController.class);

    @GetMapping("/{id}}")
    public ResponseEntity<List<DettaglioDto>> list(@PathVariable Long id){
        try{
            List<DettaglioDto> dettagli = dettaglioService.list(id);
            return new ResponseEntity<>(dettagli, HttpStatus.OK);
        }
        catch(Exception ex){
            logger.error("Errore in list()",ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/")
    public ResponseEntity<DettaglioDto> save(@RequestBody DettaglioSaveBody body){
        try{
            return new ResponseEntity<>(dettaglioService.save(body.getDettaglioDto(), body.getFatturaId()),HttpStatus.CREATED);
        }
        catch(Exception ex){
            logger.error("Errore in save()",ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/")
    public ResponseEntity<DettaglioDto> update(@RequestBody DettaglioDto body){
        try{
            return new ResponseEntity<>(dettaglioService.update(body),HttpStatus.OK);
        }
        catch(Exception ex){
            logger.error("Errore in update()",ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        try{
            dettaglioService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch(Exception ex){
            logger.error("Errore in delete()",ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
