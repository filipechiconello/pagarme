package br.com.pagarme.facades.impl;

import br.com.pagarme.dtos.requests.TransactionsRequestDTO;
import br.com.pagarme.dtos.responses.PayableResponseDTO;
import br.com.pagarme.dtos.responses.TransactionsResponsesDTO;
import br.com.pagarme.entities.PayablesEntity;
import br.com.pagarme.entities.TransactionsEntity;
import br.com.pagarme.enums.PaymentMethodEnum;
import br.com.pagarme.enums.StatusEnum;
import br.com.pagarme.facades.TransactionsFacade;
import br.com.pagarme.services.PayableService;
import br.com.pagarme.services.TransactionsService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Component
@Slf4j
public class TransactionsFacadeImpl implements TransactionsFacade {

    @Autowired
    private TransactionsService transactionsService;

    @Autowired
    private PayableService payableService;

    @Autowired
    private ModelMapper modelMapper;

    private final String CARD_NUMBER = "xxxx.xxxx.xxxx-";

    @Override
    public TransactionsResponsesDTO save(TransactionsRequestDTO transactionsRequestDTO) {
        return convertTransactionsEntityDTOtoTransactionsResponseDTO(
                transactionsService.save(convertTransactionsRequestDTOtoTransactionsEntity(
                transactionsRequestDTO)));
    }

    @Override
    public List<TransactionsResponsesDTO> findAll() {
        List<TransactionsResponsesDTO> transactionsResponsesDTOList = new ArrayList<>();
        transactionsService.findAll().forEach(transactionsEntity -> {
            transactionsResponsesDTOList.add(convertTransactionsEntityDTOtoTransactionsResponseDTO(transactionsEntity));
        });

        return transactionsResponsesDTOList;
    }

    private TransactionsEntity convertTransactionsRequestDTOtoTransactionsEntity(TransactionsRequestDTO transactionsRequestDTO) {
        TransactionsEntity transactionsEntity = modelMapper.map(transactionsRequestDTO, TransactionsEntity.class);
        transactionsEntity.setCardNumber(CARD_NUMBER.concat(transactionsRequestDTO.getCardNumber().substring(transactionsRequestDTO.getCardNumber().length() - 4)));

        if (transactionsRequestDTO.getPaymentMethod() == PaymentMethodEnum.DEBIT_CARD) {
            payableService.save(new PayablesEntity(
                    null,
                    StatusEnum.PAID,
                    new Date(),
                    validateDebit(transactionsEntity.getValue()),
                    BigDecimal.ZERO,
                    validateDebit(transactionsEntity.getValue()),
                    transactionsRequestDTO.getBearerName()));

        }

        if (transactionsRequestDTO.getPaymentMethod() == PaymentMethodEnum.CREDIT_CARD) {
            payableService.save(new PayablesEntity(
                    null,
                    StatusEnum.WAITING_FUNDS,
                    validateDate(new Date()),
                    BigDecimal.ZERO,
                    validateCredit(transactionsEntity.getValue()),
                    validateCredit(transactionsEntity.getValue()),
                    transactionsRequestDTO.getBearerName()));

        }

        return transactionsEntity;
    }

    private TransactionsResponsesDTO convertTransactionsEntityDTOtoTransactionsResponseDTO(TransactionsEntity transactionsEntity) {
        TransactionsResponsesDTO transactionsResponsesDTO = modelMapper.map(transactionsEntity, TransactionsResponsesDTO.class);
        transactionsResponsesDTO.setCardNumber(CARD_NUMBER.concat(transactionsEntity.getCardNumber().substring(transactionsEntity.getCardNumber().length() - 4)));

        if (transactionsEntity.getPaymentMethod() == PaymentMethodEnum.DEBIT_CARD) {
            transactionsResponsesDTO.setPayables(new PayableResponseDTO(StatusEnum.PAID, new Date()));
        } else {
            transactionsResponsesDTO.setPayables(new PayableResponseDTO(StatusEnum.WAITING_FUNDS, validateDate(new Date())));
        }

        return transactionsResponsesDTO;
    }

    private Date validateDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, 30);
        date = calendar.getTime();

        return date;
    }

    private BigDecimal validateDebit(BigDecimal bigDecimal) {
        BigDecimal value = bigDecimal.multiply(BigDecimal.valueOf(0.03));
        return bigDecimal.subtract(value);
    }

    private BigDecimal validateCredit(BigDecimal bigDecimal) {
        BigDecimal value = bigDecimal.multiply(BigDecimal.valueOf(0.05));
        return bigDecimal.subtract(value);
    }
}
