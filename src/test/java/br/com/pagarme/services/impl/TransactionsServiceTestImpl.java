package br.com.pagarme.services.impl;

import br.com.pagarme.entities.TransactionsEntity;
import br.com.pagarme.enums.PaymentMethodEnum;
import br.com.pagarme.repositories.TransactionsRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.Silent.class)
@SpringBootTest
public class TransactionsServiceTestImpl {

    @InjectMocks
    private TransactionsServiceImpl transactionsService;

    @Mock
    private TransactionsRepository transactionsRepository;

    private final String ID = "ID936782Y7DEU";

    @Before
    public void setupMock() {
        when(transactionsRepository.findAll()).thenReturn(mustReturnListTransactionsEntity());
        when(transactionsRepository.save(mustReturnTransactionsEntity())).thenReturn(mustReturnTransactionsEntity());
    }

    @Test
    public void saveTransactionsMustReturnOk() throws Exception {
        assertEquals(mustReturnTransactionsEntity(), transactionsService.save(mustReturnTransactionsEntity()));
    }

    @Test
    public void listAllTransactionsMustReturnOk() throws Exception {
        assertEquals(mustReturnListTransactionsEntity(), transactionsService.findAll());
    }

    private List<TransactionsEntity> mustReturnListTransactionsEntity() {
        List<TransactionsEntity> list = new ArrayList<>();
        list.add(mustReturnTransactionsEntity());

        return list;
    }

    //Auxiliary Methods:
    private TransactionsEntity mustReturnTransactionsEntity() {
        return new TransactionsEntity(
                ID,
                BigDecimal.ONE,
                "descriptions",
                PaymentMethodEnum.DEBIT_CARD,
                "123",
                "filipe",
                "321",
                "456");
    }
}
