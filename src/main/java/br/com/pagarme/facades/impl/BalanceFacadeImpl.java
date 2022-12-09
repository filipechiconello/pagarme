package br.com.pagarme.facades.impl;

import br.com.pagarme.dtos.responses.BalanceResponseDTO;
import br.com.pagarme.entities.PayablesEntity;
import br.com.pagarme.exceptions.PayablesException;
import br.com.pagarme.exceptions.enums.PayablesEnum;
import br.com.pagarme.facades.BalanceFacade;
import br.com.pagarme.services.PayableService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Locale;

@Component
@Slf4j
public class BalanceFacadeImpl implements BalanceFacade {

    @Autowired
    private PayableService payableService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public BalanceResponseDTO getBalances(String bearerName) {
        if (bearerName.isEmpty() || bearerName.isBlank()) {
            throw new PayablesException(PayablesEnum.PAYABLES_NOT_FOUND);
        }
        return validateBalances(bearerName);
    }

    private BalanceResponseDTO validateBalances(String bearerName) {
        BalanceResponseDTO balanceResponseDTO = new BalanceResponseDTO();
        BigDecimal balancesPaid = BigDecimal.ZERO;
        BigDecimal balancesWaiting = BigDecimal.ZERO;
        BigDecimal totalBalance = BigDecimal.ZERO;

        for (PayablesEntity payablesEntity : payableService.findByBearerName(bearerName)) {
            balanceResponseDTO.setName(payablesEntity.getBearerName());
            BigDecimal availablesPaid = payablesEntity.getAvailablePaid();
            balancesPaid = availablesPaid.add(balancesPaid);
            balanceResponseDTO.setBalanceAvailable(balancesPaid);

            BigDecimal waitingFunds = payablesEntity.getWaitingFunds();
            balancesWaiting = waitingFunds.add(balancesWaiting);
            balanceResponseDTO.setBalanceWaitingFunds(balancesWaiting);

            BigDecimal totalFunds = payablesEntity.getValue();
            totalBalance = totalFunds.add(totalBalance);
            balanceResponseDTO.setTotalBalance(totalBalance);
        }

        return balanceResponseDTO;
    }
}
