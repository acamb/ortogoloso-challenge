package ac.challenge.ortogoloso.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class DettaglioDto {
    private Long id;
    private String descrizione;
    private int quantita;
    private BigDecimal aliquotaIva;
}
