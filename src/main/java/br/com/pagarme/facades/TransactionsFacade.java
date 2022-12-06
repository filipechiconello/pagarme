package br.com.pagarme.facades;

import br.com.pagarme.dtos.requests.TransactionsRequestDTO;
import br.com.pagarme.dtos.responses.TransactionsResponsesDTO;

public interface TransactionsFacade {

    TransactionsResponsesDTO save(TransactionsRequestDTO transactionsRequestDTO);
}
