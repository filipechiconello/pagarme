package br.com.pagarme.exceptions;


import br.com.pagarme.exceptions.enums.PayablesEnum;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class PayablesException extends PagarMeApiException {

    private static final long serialVersionUID = -4589179341768493322L;

    public PayablesException(PayablesEnum error) {
        super(error.getMessage());
        this.error = error;
    }

    private final PayablesEnum error;
}
