package ac.challenge.ortogoloso.controller.response;

import ac.challenge.ortogoloso.dto.DettaglioDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class DettagliListResponse {
    private List<DettaglioDto> dettagli;
    private BigDecimal totale;
}
