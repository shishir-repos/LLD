package org.LLD.RefundEngine.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@ToString
public class RefundRequest {
    private String refundId;
    private List<RefundTransaction> refunds;
    private RefundStatus refundStatus;
}