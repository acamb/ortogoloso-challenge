package ac.challenge.ortogoloso.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@Entity
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
    @NotNull
    @ManyToOne
    private Fattura fattura;

}
