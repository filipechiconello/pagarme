package br.com.pagarme.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class BalanceResponseDTO {

    private String name;
    private BigDecimal balanceAvailable;
    private BigDecimal balanceWaitingFunds;
}
