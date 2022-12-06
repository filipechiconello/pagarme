package br.com.pagarme.facades;

import br.com.pagarme.dtos.responses.BalanceResponseDTO;

public interface BalanceFacade {

    BalanceResponseDTO getBalances(String bearerName);
}
