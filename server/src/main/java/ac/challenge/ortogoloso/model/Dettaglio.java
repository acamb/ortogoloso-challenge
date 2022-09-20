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
    @NotBlank
    private String descrizione;
    @Min(1)
    private int quantita;
    @Min(1)
    private BigDecimal aliquotaIva;
    @NotNull
    @ManyToOne
    private Fattura fattura;

}
