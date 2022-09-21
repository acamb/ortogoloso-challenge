package ac.challenge.ortogoloso.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Fattura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "identificativo.required")
    //L'identificativo e' composto da un numero e dall'anno, es.: 152/2022
    @Pattern(regexp = "[0-9]+/[0-9]{4}",message = "indetificativo.format")
    private String identificativo;
    @NotNull(message = "dataEmissione.required")
    private Date dataEmissione;
    //Ai fini dell'esercizio, visto che il prestatore e' sempre ortogoloso, cabliamo i dati
    @NotBlank
    private String nomePrestatore = "Ortogoloso";
    @NotBlank
    private String partitaIvaPrestatore = "12345678911";
    //In un caso reale probabilmente sarebbe una relazione ad un' Entity "Parte" o "Cessionario"
    @NotBlank(message = "nomeCessionario.required")
    private String nomeCessionario;
    @NotBlank(message = "partitaIvaCessionario.required")
    @Length(min = 11,max=11,message = "partitaIvaCessionario.format")
    private String partitaIvaCessionario;
    @Enumerated(EnumType.STRING)
    @NotNull(message = "modalitaPagamento.required")
    private ModalitaPagamento modalitaPagamento;
    @Positive(message = "importo.lesser.than.zero") //l'importo deve essere sempre > 0 (per semplificare escludiamo note credito)
    private BigDecimal importo;
    @NotBlank(message = "iban.required")
    private String iban;
    @OneToMany(cascade = CascadeType.REMOVE)
    @JsonIgnore
    List<Dettaglio> dettagli;


    public enum ModalitaPagamento{
        BONIFICO,
        SDD
    }
}
