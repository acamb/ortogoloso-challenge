package ac.challenge.ortogoloso.controller.request;

import ac.challenge.ortogoloso.dto.DettaglioDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.Valid;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class DettaglioSaveAllBody {

    private Long fatturaId;
    @Valid
    private List<DettaglioDto> dettagli;
}
