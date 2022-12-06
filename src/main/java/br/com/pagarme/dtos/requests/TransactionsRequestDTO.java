package br.com.pagarme.dtos.requests;

import br.com.pagarme.enums.PaymentMethodEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionsRequestDTO {

    private BigDecimal value;
    private String description;
    private PaymentMethodEnum paymentMethod;
    private String cardNumber;
    private String bearerName;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date validateDateCard;

    private String validateCodeCard;
}
