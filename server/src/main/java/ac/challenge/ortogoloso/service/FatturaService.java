package ac.challenge.ortogoloso.service;

import ac.challenge.ortogoloso.dto.FatturaDto;
import ac.challenge.ortogoloso.mapper.MapperLogic;
import ac.challenge.ortogoloso.model.Fattura;
import ac.challenge.ortogoloso.repository.FatturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Validated //per la validazione utilizziamo i validatori di spring che implementano la JSR-380
public class FatturaService {

    @Autowired
    FatturaRepository repository;

    @Transactional
    public FatturaDto save(FatturaDto fatturaDto){
        Fattura fattura = new Fattura();
        MapperLogic.dtoToFattura(fatturaDto,fattura);
        return MapperLogic.fatturaToDto(repository.save(fattura));
    }

    @Transactional
    public FatturaDto update(FatturaDto fatturaDto){
        Fattura fattura = repository.findById(fatturaDto.getId()).orElseThrow(()->new RuntimeException("fattura.not.found"));
        MapperLogic.dtoToFattura(fatturaDto,fattura);
        return MapperLogic.fatturaToDto(repository.save(fattura));
    }

    public List<FatturaDto> list(){
        return StreamSupport.stream(repository.findAll().spliterator(),false)
                .map(MapperLogic::fatturaToDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id){
        Fattura fattura = repository.findById(id).orElseThrow(() -> new RuntimeException("fattura.not.found"));
        repository.delete(fattura);
    }

    public FatturaDto read(Long id){
        return MapperLogic.fatturaToDto(repository.findById(id).orElseThrow(() -> new RuntimeException("fattura.not.found")));
    }
}
