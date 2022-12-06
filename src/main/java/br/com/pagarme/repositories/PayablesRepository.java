package br.com.pagarme.repositories;

import br.com.pagarme.entities.PayablesEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PayablesRepository extends MongoRepository<PayablesEntity, String> {

    List<PayablesEntity> findByBearerName(String bearerName);
}
