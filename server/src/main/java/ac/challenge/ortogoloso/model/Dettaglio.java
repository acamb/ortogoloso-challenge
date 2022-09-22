package ac.challenge.ortogoloso.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@Entity
@ToString
public class Dettaglio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "descrizione.required")
    private String descrizione;
    @Min(value = 1,message = "quantita.lesser.than.one")
    private int quantita;
    @Min(value = 1,message = "aliquota.lesser.than.one")
    private BigDecimal aliquotaIva;
    @Positive(message = "importo.lesser.than.zero")
    //Questo e' l'importo unitario, non l'importo totale del dettaglio
    private BigDecimal importo;
    @NotNull
    @ManyToOne
    private Fattura fattura;


}
