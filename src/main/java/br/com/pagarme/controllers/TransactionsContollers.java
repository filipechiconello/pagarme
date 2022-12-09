package br.com.pagarme.controllers;

import br.com.pagarme.dtos.requests.TransactionsRequestDTO;
import br.com.pagarme.dtos.responses.TransactionsResponsesDTO;
import br.com.pagarme.facades.TransactionsFacade;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionsContollers {

    @Autowired
    private TransactionsFacade transactionsFacade;

    @Operation(summary = "creating new transaction")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "creating new transaction successfully"),
    })
    @PostMapping
    public ResponseEntity<TransactionsResponsesDTO> save(@Valid @RequestBody TransactionsRequestDTO transactionsRequestDTO) {
        return new ResponseEntity<>(transactionsFacade.save(transactionsRequestDTO), HttpStatus.CREATED);
    }

    @Operation(summary = "listing all transactions")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "listing all transactions successfully"),
    })
    @GetMapping
    public ResponseEntity<List<TransactionsResponsesDTO>> findAll() {
        return new ResponseEntity<>(transactionsFacade.findAll(), HttpStatus.OK);
    }
}
