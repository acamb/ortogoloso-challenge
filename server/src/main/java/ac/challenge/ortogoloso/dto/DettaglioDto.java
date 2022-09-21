package ac.challenge.ortogoloso.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class DettaglioDto {
    private Long id;
    @NotBlank(message = "descrizione.required")
    private String descrizione;
    @Min(value = 1,message = "quantita.lesser.than.one")
    private int quantita;
    @Positive(message = "importo.lesser.than.zero")
    private BigDecimal importo;
    @Min(value = 1,message = "aliquota.lesser.than.one")
    private BigDecimal aliquotaIva;


    public BigDecimal getTotaleDettaglio(){
        return importo.multiply(BigDecimal.valueOf(quantita));
    }
}
