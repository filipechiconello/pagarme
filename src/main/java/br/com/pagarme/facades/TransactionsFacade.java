package br.com.pagarme.facades;

import br.com.pagarme.dtos.requests.TransactionsRequestDTO;
import br.com.pagarme.dtos.responses.TransactionsResponsesDTO;

import java.util.List;

public interface TransactionsFacade {

    TransactionsResponsesDTO save(TransactionsRequestDTO transactionsRequestDTO);
    List<TransactionsResponsesDTO> findAll();
}
