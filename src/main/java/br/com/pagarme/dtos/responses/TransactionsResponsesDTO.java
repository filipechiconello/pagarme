package br.com.pagarme.dtos.responses;

import br.com.pagarme.enums.PaymentMethodEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionsResponsesDTO {

    private String id;
    private BigDecimal value;
    private String description;
    private PaymentMethodEnum paymentMethod;
    private String cardNumber;
    private String bearerName;
    private String validateDateCard;
    private String validateCodeCard;
    private PayableResponseDTO payables;
}
