package ac.challenge.ortogoloso.dto;

import ac.challenge.ortogoloso.model.Fattura;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class FatturaDto {

    private Long id;
    @NotBlank(message = "identificativo.required")
    //L'identificativo e' composto da un numero e dall'anno, es.: 152/2022
    @Pattern(regexp = "[0-9]+/[0-9]{4}",message = "indetificativo.format")
    private String identificativo;
    @NotNull(message = "dataEmissione.required")
    private Date dataEmissione;
    private String nomePrestatore;
    private String partitaIvaPrestatore;
    @NotBlank(message = "nomeCessionario.required")
    private String nomeCessionario;
    @NotBlank(message = "partitaIvaCessionario.required")
    @Length(min = 11,max=11,message = "partitaIvaCessionario.format")
    private String partitaIvaCessionario;
    @NotNull(message = "modalitaPagamento.required")
    private Fattura.ModalitaPagamento modalitaPagamento;
    @Positive(message = "importo.lesser.than.zero") //l'importo deve essere sempre > 0 (per semplificare escludiamo note credito)
    private BigDecimal importo;
    @NotBlank(message = "iban.required")
    private String iban;
    @Min(value = 1,message = "numeroRate.lesser.than.1")
    private int numeroRate;

}
