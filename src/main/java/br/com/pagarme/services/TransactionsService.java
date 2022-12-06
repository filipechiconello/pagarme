package br.com.pagarme.services;

import br.com.pagarme.entities.TransactionsEntity;

import java.util.List;

public interface TransactionsService {

    TransactionsEntity save(TransactionsEntity transactionsEntity);
    List<TransactionsEntity> findAll();
}
