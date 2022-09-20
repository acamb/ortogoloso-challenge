package ac.challenge.ortogoloso.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Fattura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String identificativo;
    @NotNull
    private Date dataEmissione;
    //Ai fini dell'esercizio, visto che il prestatore e' sempre ortogoloso, cabliamo i dati
    @NotBlank
    private String nomePrestatore = "Ortogoloso";
    @NotBlank
    private String partitaIvaPrestatore = "12345678911";
    //In un caso reale probabilmente sarebbe una relazione ad un' Entity "Parte" o "Cessionario"
    @NotBlank
    private String nomeCessionario;
    @NotBlank
    @Length(min = 11,max=11)
    private String partitaIvaCessionario;
    @Enumerated(EnumType.STRING)
    private ModalitaPagamento modalitaPagamento;
    @Positive //l'importo deve essere sempre > 0 (per semplificare escludiamo note credito)
    private BigDecimal importo;
    @NotBlank
    private String iban;


    public enum ModalitaPagamento{
        BONIFICO,
        SDD
    }
}
