package org.LLD.RefundEngine.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class RefundTransaction {
    PaymentMethod paymentMethod;
    BigDecimal amount;
}
