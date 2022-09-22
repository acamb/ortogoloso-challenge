package ac.challenge.ortogoloso.controller.request;

import ac.challenge.ortogoloso.dto.DettaglioDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.Valid;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class DettaglioSaveBody {

    private Long fatturaId;
    @Valid
    private DettaglioDto dettaglioDto;
}
