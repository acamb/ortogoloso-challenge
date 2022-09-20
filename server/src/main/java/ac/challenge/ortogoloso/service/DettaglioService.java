package ac.challenge.ortogoloso.service;

import ac.challenge.ortogoloso.dto.DettaglioDto;
import ac.challenge.ortogoloso.mapper.MapperLogic;
import ac.challenge.ortogoloso.model.Dettaglio;
import ac.challenge.ortogoloso.model.Fattura;
import ac.challenge.ortogoloso.repository.DettaglioRepository;
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
public class DettaglioService {

    @Autowired
    DettaglioRepository repository;

    @Autowired
    FatturaRepository fatturaRepository;

    @Transactional
    public DettaglioDto save(DettaglioDto dettaglioDto,Long fatturaId){
        Dettaglio dettaglio = new Dettaglio();
        MapperLogic.dtoToDettaglio(dettaglioDto,dettaglio);
        Fattura fattura = fatturaRepository.findById(fatturaId).orElseThrow(()-> new RuntimeException("fattura.not.found"));
        dettaglio.setFattura(fattura);
        return MapperLogic.dettaglioToDto(repository.save(dettaglio));
    }

    @Transactional
    public DettaglioDto update(DettaglioDto dettaglioDto){
        Dettaglio dettaglio = repository.findById(dettaglioDto.getId()).orElseThrow(()->new RuntimeException("dettaglio.not.found"));
        MapperLogic.dtoToDettaglio(dettaglioDto,dettaglio);
        return MapperLogic.dettaglioToDto(repository.save(dettaglio));
    }

    public List<DettaglioDto> list(Long fatturaId){
        return StreamSupport.stream(repository.findAllByFatturaId(fatturaId).spliterator(),false)
                .map(MapperLogic::dettaglioToDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id){
        repository.deleteById(id);
    }

}
