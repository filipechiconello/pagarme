package br.com.pagarme.repositories;

import br.com.pagarme.entities.TransactionsEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionsRepository extends MongoRepository<TransactionsEntity, String> {
}
