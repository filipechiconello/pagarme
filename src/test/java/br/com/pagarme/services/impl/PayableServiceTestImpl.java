package br.com.pagarme.services.impl;

import br.com.pagarme.entities.PayablesEntity;
import br.com.pagarme.enums.StatusEnum;
import br.com.pagarme.repositories.PayablesRepository;
import br.com.pagarme.repositories.TransactionsRepository;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.Silent.class)
@SpringBootTest
public class PayableServiceTestImpl {

    @InjectMocks
    private PayableServiceImpl payableService;

    @Mock
    private PayablesRepository payablesRepository;

    private final String ID = "ID936782Y7DEU";
    private final String NAME = "filipe";

    @Before
    public void setupMock() {
        when(payablesRepository.findByBearerName(NAME)).thenReturn(mustReturnListPayablesEntity());
        when(payablesRepository.save(mustReturnPayablesEntity())).thenReturn(mustReturnPayablesEntity());
    }


    @Test
    public void savePayableMustReturnOk() throws Exception {
        assertEquals(mustReturnPayablesEntity(), payableService.save(mustReturnPayablesEntity()));
    }

    @Test
    public void getPayableByBearerNameMustReturnOk() throws Exception {
        assertEquals(mustReturnListPayablesEntity(), payableService.findByBearerName(NAME));
    }

    //Auxiliary Methods:
    private PayablesEntity mustReturnPayablesEntity() {

        Date date = new Date();
        date.setTime(1L);
        return new PayablesEntity(ID,
                StatusEnum.PAID,
                date,
                BigDecimal.ONE,
                BigDecimal.ONE,
                BigDecimal.TEN,
                NAME);
    }

    private List<PayablesEntity> mustReturnListPayablesEntity() {
        List<PayablesEntity> list = new ArrayList<>();
        list.add(mustReturnPayablesEntity());

        return list;
    }
}
