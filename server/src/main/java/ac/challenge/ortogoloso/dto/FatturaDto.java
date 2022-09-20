package ac.challenge.ortogoloso.dto;

import ac.challenge.ortogoloso.model.Fattura;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class FatturaDto {

    private Long id;
    private String identificativo;
    private Date dataEmissione;
    private String nomePrestatore;
    private String partitaIvaPrestatore;
    private String nomeCessionario;
    private String partitaIvaCessionario;
    private Fattura.ModalitaPagamento modalitaPagamento;
    private BigDecimal importo;
    private String iban;

}
