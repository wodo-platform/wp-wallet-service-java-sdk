package io.wodo.walletsdk.model.request;

import io.wodo.walletsdk.enumtype.EnumStatus;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
public class WalletUpdateRequest {

    @NotNull
    private EnumStatus status;

    @NotNull
    @Min(0)
    private BigDecimal amount;
}