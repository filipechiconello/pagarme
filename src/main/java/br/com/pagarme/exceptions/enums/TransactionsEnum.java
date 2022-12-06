package br.com.pagarme.exceptions.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum TransactionsEnum {

    TRANSACTIONS_NOT_FOUND("001", "Transactions not found", 404);

    private String code;
    private String message;
    private Integer statusCode;
}
