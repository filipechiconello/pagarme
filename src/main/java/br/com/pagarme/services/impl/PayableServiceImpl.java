package br.com.pagarme.services.impl;

import br.com.pagarme.entities.PayablesEntity;
import br.com.pagarme.repositories.PayablesRepository;
import br.com.pagarme.services.PayableService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class PayableServiceImpl implements PayableService {

    @Autowired
    private PayablesRepository payablesRepository;

    @Override
    public PayablesEntity save(PayablesEntity payablesEntity) {
        return payablesRepository.save(payablesEntity);
    }

    @Override
    public List<PayablesEntity> findByBearerName(String bearerName) {
        List<PayablesEntity> payablesEntityList = new ArrayList<>();
        payablesRepository.findByBearerName(bearerName).forEach(payablesEntityList::add);

        return payablesEntityList;
    }
}
