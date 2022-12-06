package br.com.pagarme.services;

import br.com.pagarme.entities.TransactionsEntity;

public interface TransactionsService {

    TransactionsEntity save(TransactionsEntity transactionsEntity);
}
