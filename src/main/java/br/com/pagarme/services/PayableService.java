package br.com.pagarme.services;

import br.com.pagarme.entities.PayablesEntity;

import java.util.List;
import java.util.Optional;

public interface PayableService {

    PayablesEntity save(PayablesEntity payablesEntity);
    List<PayablesEntity> findByBearerName(String bearerName);
}
