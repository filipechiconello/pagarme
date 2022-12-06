package br.com.pagarme.services.impl;

import br.com.pagarme.entities.TransactionsEntity;
import br.com.pagarme.repositories.TransactionsRepository;
import br.com.pagarme.services.TransactionsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TransactionsServiceImpl implements TransactionsService {

    @Autowired
    private TransactionsRepository transactionsRepository;

    @Override
    public TransactionsEntity save(TransactionsEntity transactionsEntity) {
        log.info("creating new transaction");
        return transactionsRepository.save(transactionsEntity);
    }
}