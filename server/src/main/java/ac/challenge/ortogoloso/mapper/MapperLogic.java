package ac.challenge.ortogoloso.mapper;

import ac.challenge.ortogoloso.dto.DettaglioDto;
import ac.challenge.ortogoloso.dto.FatturaDto;
import ac.challenge.ortogoloso.model.Dettaglio;
import ac.challenge.ortogoloso.model.Fattura;

public class MapperLogic {

    public static FatturaDto fatturaToDto(Fattura fattura){
        FatturaDto dto = new FatturaDto();
        dto.setId(fattura.getId());
        dto.setIdentificativo(fattura.getIdentificativo());
        dto.setDataEmissione(fattura.getDataEmissione());
        dto.setNomePrestatore(fattura.getNomePrestatore());
        dto.setPartitaIvaPrestatore(fattura.getPartitaIvaPrestatore());
        dto.setNomeCessionario(fattura.getNomeCessionario());
        dto.setPartitaIvaCessionario(fattura.getPartitaIvaCessionario());
        dto.setModalitaPagamento(fattura.getModalitaPagamento());
        dto.setImporto(fattura.getImporto());
        dto.setIban(fattura.getIban());
        dto.setNumeroRate(fattura.getNumeroRate());
        return dto;
    }

    /**
     * Meotodo che mappa dal DTO all'Entity, ATTENZIONE: eventuali relazioni sono da mappare manualmente
     * @param fatturaDto
     * @param fattura
     */
    public static void dtoToFattura(FatturaDto fatturaDto,Fattura fattura){
        //fattura.setId(fatturaDto.getId());
        fattura.setIdentificativo(fatturaDto.getIdentificativo());
        fattura.setDataEmissione(fatturaDto.getDataEmissione());
        fattura.setNomePrestatore(fatturaDto.getNomePrestatore());
        fattura.setPartitaIvaPrestatore(fatturaDto.getPartitaIvaPrestatore());
        fattura.setNomeCessionario(fatturaDto.getNomeCessionario());
        fattura.setPartitaIvaCessionario(fatturaDto.getPartitaIvaCessionario());
        fattura.setModalitaPagamento(fatturaDto.getModalitaPagamento());
        fattura.setImporto(fatturaDto.getImporto());
        fattura.setIban(fatturaDto.getIban());
        fattura.setNumeroRate(fatturaDto.getNumeroRate());
    }

    public static DettaglioDto dettaglioToDto(Dettaglio dettaglio){
        DettaglioDto dto = new DettaglioDto();
        dto.setId(dettaglio.getId());
        dto.setDescrizione(dettaglio.getDescrizione());
        dto.setQuantita(dettaglio.getQuantita());
        dto.setAliquotaIva(dettaglio.getAliquotaIva());
        dto.setImporto(dettaglio.getImporto());
        return dto;
    }

    /**
     * Metodo che mappa dal dto all'entity, ATTENZIONE: le relazioni sono da mappare manualmente
     * @param dettaglioDto
     * @param dettaglio
     */
    public static void dtoToDettaglio(DettaglioDto dettaglioDto,Dettaglio dettaglio){
        dettaglio.setId(dettaglioDto.getId());
        dettaglio.setDescrizione(dettaglioDto.getDescrizione());
        dettaglio.setQuantita(dettaglioDto.getQuantita());
        dettaglio.setAliquotaIva(dettaglioDto.getAliquotaIva());
        dettaglio.setImporto(dettaglioDto.getImporto());
    }
}
