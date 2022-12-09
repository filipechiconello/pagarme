package br.com.pagarme.controllers;

import br.com.pagarme.dtos.requests.TransactionsRequestDTO;
import br.com.pagarme.dtos.responses.PayableResponseDTO;
import br.com.pagarme.dtos.responses.TransactionsResponsesDTO;
import br.com.pagarme.enums.PaymentMethodEnum;
import br.com.pagarme.enums.StatusEnum;
import br.com.pagarme.facades.TransactionsFacade;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = TransactionsContollers.class)
@AutoConfigureMockMvc
public class TransactionsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TransactionsFacade transactionsFacade;

    private final String ROUTE = "/api/v1/transactions";
    private final String ID = "98789YDUNE";
    private final String NAME = "filipe";

    @Before
    public void setupMock() {
        MockitoAnnotations.openMocks(this);
        Mockito.when(transactionsFacade.save(mustReturnTransactionsRequestDTO())).thenReturn(mustReturnTransactionsResponseDTO());
        when(transactionsFacade.findAll()).thenReturn(mustReturnListTransactionsResponseDTO());
    }

    @Test
    public void saveTransactionsMustReturnOk() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(post(ROUTE)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(mustReturnTransactionsResponseDTO())));
    }

    @Test
    public void listTransactionsMustReturnOk() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(get(ROUTE))
                .andExpect(status().isOk())
                .andExpect(content().json(ow.writeValueAsString(mustReturnListTransactionsResponseDTO())));

    }

    //Auxiliary Methods:
    private TransactionsResponsesDTO mustReturnTransactionsResponseDTO() {
        return new TransactionsResponsesDTO(
                ID,
                new BigDecimal("97.00"),
                "descriptions",
                PaymentMethodEnum.DEBIT_CARD,
                "321",
                NAME,
                new Date().toString(),
                "123",
                new PayableResponseDTO(
                        StatusEnum.PAID,
                        new Date()));
    }

    private TransactionsRequestDTO mustReturnTransactionsRequestDTO() {
        Date date = new Date();
        date.setTime(1L);
        return new TransactionsRequestDTO(
                new BigDecimal("100.00"),
                "descriptions",
                PaymentMethodEnum.DEBIT_CARD,
                "321",
                NAME,
                date,
                "123"
        );
    }

    private List<TransactionsResponsesDTO> mustReturnListTransactionsResponseDTO() {
        List<TransactionsResponsesDTO> list = new ArrayList<>();
        list.add(mustReturnTransactionsResponseDTO());

        return list;
    }
}
