package org.LLD.RefundEngine.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@ToString
public class PaymentTransaction {
    private String paymentId;
    private PaymentMethod paymentMethod;
    private BigDecimal amount;
}
