package br.com.pagarme.entities;

import br.com.pagarme.enums.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("payables")
public class PayablesEntity {

    private String id;
    private StatusEnum status;
    private Date paymentDate;
    private BigDecimal availablePaid;
    private BigDecimal waitingFunds;
    private BigDecimal value;
    private String bearerName;
}
