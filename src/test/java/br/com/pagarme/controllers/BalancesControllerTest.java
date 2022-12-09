package br.com.pagarme.controllers;

import br.com.pagarme.dtos.responses.BalanceResponseDTO;
import br.com.pagarme.facades.BalanceFacade;
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
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = BalancesControllers.class)
@AutoConfigureMockMvc
public class BalancesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BalanceFacade balanceFacade;

    private final String ROUTE = "/api/v1/balances";

    @Before
    public void setupMock() {
        MockitoAnnotations.openMocks(this);
        when(balanceFacade.getBalances("filipe")).thenReturn(mustReturnBalanceResponseDTO());
    }

    @Test
    public void getBalancesFromUserMustReturnOk() throws Exception {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        mockMvc.perform(get(ROUTE).param("name", "filipe"))
                .andExpect(status().isOk())
                .andExpect(content().json(ow.writeValueAsString(mustReturnBalanceResponseDTO())));

    }

    private BalanceResponseDTO mustReturnBalanceResponseDTO() {
        return new BalanceResponseDTO("filipe",
                new BigDecimal(2000),
                new BigDecimal(3000),
                new BigDecimal(400));
    }
}
