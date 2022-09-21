package ac.challenge.ortogoloso.service;

import ac.challenge.ortogoloso.dto.DettaglioDto;
import ac.challenge.ortogoloso.dto.FatturaDto;
import ac.challenge.ortogoloso.mapper.MapperLogic;
import ac.challenge.ortogoloso.model.Dettaglio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

/**
 * Service per comporre fattura e dettagli in modo da gestire la dipendenza dell'importo della fattura dalla somma dei dettagli
 */
@Service
public class FatturaDettaglioCompositeService {

    @Autowired
    FatturaService fatturaService;

    @Autowired
    DettaglioService dettaglioService;

    @Transactional
    public DettaglioDto saveDettaglio(DettaglioDto dettaglioDto, Long fatturaId){
        DettaglioDto result = dettaglioService.save(dettaglioDto,fatturaId);
        aggiornaFattura(fatturaId);
        return result;
    }

    @Transactional
    public void saveDettagli(List<DettaglioDto> dettagli,Long fatturaId){
        for(DettaglioDto dettaglio : dettagli){
            dettaglioService.save(dettaglio,fatturaId);
        }
        aggiornaFattura(fatturaId);
    }

    @Transactional
    public DettaglioDto updateDettaglio(DettaglioDto dettaglioDto){
        Dettaglio result = dettaglioService.update(dettaglioDto);
        aggiornaFattura(result.getFattura().getId());
        return MapperLogic.dettaglioToDto(result);
    }

    @Transactional
    public void deleteDettaglio(Long dettaglioId){
        Long fatturaId = dettaglioService.get(dettaglioId).getFattura().getId();
        dettaglioService.delete(dettaglioId);
        aggiornaFattura(fatturaId);
    }

    private void aggiornaFattura(Long fatturaId){
        List<DettaglioDto> dettagliFattura = dettaglioService.list(fatturaId);
        FatturaDto fatturaDto = fatturaService.read(fatturaId);
        fatturaDto.setImporto(dettagliFattura.stream().map(DettaglioDto::getTotaleDettaglio).reduce(BigDecimal.ZERO,BigDecimal::add));
        fatturaService.update(fatturaDto);
    }
}
