package ac.challenge.ortogoloso.controller;

import ac.challenge.ortogoloso.controller.request.DettaglioSaveAllBody;
import ac.challenge.ortogoloso.controller.request.DettaglioSaveBody;
import ac.challenge.ortogoloso.controller.response.DettagliListResponse;
import ac.challenge.ortogoloso.dto.DettaglioDto;
import ac.challenge.ortogoloso.service.DettaglioService;
import ac.challenge.ortogoloso.service.FatturaDettaglioCompositeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;

@RestController
@RequestMapping("/api/dettaglio")
@Validated
public class DettaglioController {

    @Autowired
    DettaglioService dettaglioService;

    @Autowired
    FatturaDettaglioCompositeService fatturaDettaglioCompositeService;

    Logger logger = LoggerFactory.getLogger(DettaglioController.class);

    @GetMapping("/{id}")
    public ResponseEntity<DettagliListResponse> list(@PathVariable Long id){
        try{
            DettagliListResponse body = new DettagliListResponse();
            body.setDettagli(dettaglioService.list(id));
            //sul dettaglio abbiamo il prezzo unitario, quindi va moltiplicato per le quantita' e sommato per avere il totale
            body.setTotale(body.getDettagli().stream().map(DettaglioDto::getTotaleDettaglio).reduce(BigDecimal.ZERO,BigDecimal::add));
            return new ResponseEntity<>(body, HttpStatus.OK);
        }
        catch(Exception ex){
            logger.error("Error in list()",ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/")
    public ResponseEntity<DettaglioDto> save(@RequestBody @Valid DettaglioSaveBody body){
        try{
            return new ResponseEntity<>(fatturaDettaglioCompositeService.saveDettaglio(body.getDettaglioDto(), body.getFatturaId()),HttpStatus.CREATED);
        }
        catch(Exception ex){
            logger.error("Error in save()",ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/all")
    public ResponseEntity<?> saveAll(@RequestBody @Valid DettaglioSaveAllBody body){
        try{
            fatturaDettaglioCompositeService.saveDettagli(body.getDettagli(), body.getFatturaId());
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        catch(Exception ex){
            logger.error("Error in saveAll()",ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/")
    public ResponseEntity<DettaglioDto> update(@RequestBody @Valid DettaglioDto body){
        try{
            return new ResponseEntity<>(fatturaDettaglioCompositeService.updateDettaglio(body),HttpStatus.OK);
        }
        catch(Exception ex){
            logger.error("Error in update()",ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        try{
            fatturaDettaglioCompositeService.deleteDettaglio(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch(Exception ex){
            logger.error("Error in delete()",ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
