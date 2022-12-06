package br.com.pagarme.entities;

import br.com.pagarme.enums.PaymentMethodEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("transactions")
public class TransactionsEntity {

    @Id
    private String id;
    private BigDecimal value;
    private String description;
    private PaymentMethodEnum paymentMethod;
    private String cardNumber;
    private String bearerName;
    private String validateDateCard;
    private String validateCodeCard;
}
