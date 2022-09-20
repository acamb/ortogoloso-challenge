package ac.challenge.ortogoloso.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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
    private String identificativo;
    private Date dataEmissione;
    //Ai fini dell'esercizio, visto che il prestatore e' sempre ortogoloso, cabliamo i dati
    private String nomePrestatore = "Ortogoloso";
    private String partitaIvaPrestatore = "12345678911";
    //In un caso reale probabilmente sarebbe una relazione ad un' Entity "Parte" o "Cessionario"
    private String nomeCessionario;
    private String partitaIvaCessionario;
    @Enumerated(EnumType.STRING)
    private ModalitaPagamento modalitaPagamento;
    private BigDecimal importo;
    private String iban;


    public enum ModalitaPagamento{
        BONIFICO,
        SDD
    }
}
