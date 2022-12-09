package br.com.pagarme.dtos.requests;

import br.com.pagarme.enums.PaymentMethodEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionsRequestDTO {

    @NotNull(message = "{not.null}")
    @Min(value = 1, message = "{min.value}")
    private BigDecimal value;

    @NotEmpty(message = "{not.empty}")
    @NotBlank(message = "{not.blank}")
    private String description;

    @NotNull(message = "{not.null}")
    private PaymentMethodEnum paymentMethod;

    @NotEmpty(message = "{not.empty}")
    @NotBlank(message = "{not.blank}")
    private String cardNumber;

    @NotEmpty(message = "{not.empty}")
    @NotBlank(message = "{not.blank}")
    private String bearerName;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/yyyy")
    private Date validateDateCard;

    @NotEmpty(message = "{not.empty}")
    @NotBlank(message = "{not.blank}")
    private String validateCodeCard;
}
