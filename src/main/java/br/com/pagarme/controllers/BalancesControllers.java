package br.com.pagarme.controllers;

import br.com.pagarme.dtos.responses.BalanceResponseDTO;
import br.com.pagarme.facades.BalanceFacade;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/balances")
public class BalancesControllers {

    @Autowired
    private BalanceFacade balanceFacade;

    @Operation(summary = "listing balances from bearer by name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "listing balances from bearer by name successfully"),
    })
    @GetMapping
    public ResponseEntity<BalanceResponseDTO> getBalanceFromBearerByName(@RequestParam(required = true, value = "name") String bearerName) {
        return new ResponseEntity<>(balanceFacade.getBalances(bearerName), HttpStatus.OK);
    }
}
