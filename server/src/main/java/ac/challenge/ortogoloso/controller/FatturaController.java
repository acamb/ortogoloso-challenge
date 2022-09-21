package ac.challenge.ortogoloso.controller;

import ac.challenge.ortogoloso.dto.FatturaDto;
import ac.challenge.ortogoloso.service.FatturaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/fattura")
@Validated
public class FatturaController {

    @Autowired
    FatturaService fatturaService;

    Logger logger = LoggerFactory.getLogger(FatturaController.class);

    @GetMapping("/all")
    public ResponseEntity<List<FatturaDto>> list(){
        //TODO filtri vari
        try{
            List<FatturaDto> fatture = fatturaService.list();
            return new ResponseEntity<>(fatture, HttpStatus.OK);
        }
        catch(Exception ex){
            logger.error("Error in list()",ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<FatturaDto> get(@PathVariable Long id){
        try{
            return new ResponseEntity<>(fatturaService.read(id),HttpStatus.OK);
        }
        catch(Exception ex){
            logger.error("Error in get()",ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/")
    public ResponseEntity<FatturaDto> save(@RequestBody @Valid FatturaDto body){
        try{
            return new ResponseEntity<>(fatturaService.save(body),HttpStatus.CREATED);
        }
        catch(Exception ex){
            logger.error("Error in save()",ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/")
    public ResponseEntity<FatturaDto> update(@RequestBody @Valid FatturaDto body){
        try{
            return new ResponseEntity<>(fatturaService.update(body),HttpStatus.OK);
        }
        catch(Exception ex){
            logger.error("Error in update()",ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        try{
            fatturaService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch(Exception ex){
            logger.error("Error in delete()",ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
