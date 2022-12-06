package br.com.pagarme.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PayablesResponseDTO {

    private BigDecimal availableFunds;
    private BigDecimal waitingFunds;
}
