package br.com.pagarme.exceptions;


import br.com.pagarme.exceptions.enums.TransactionsEnum;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class TransactionsException extends PagarMeApiException {

    private static final long serialVersionUID = -4589179341768493322L;

    public TransactionsException(TransactionsEnum error) {
        super(error.getMessage());
        this.error = error;
    }

    private final TransactionsEnum error;
}
