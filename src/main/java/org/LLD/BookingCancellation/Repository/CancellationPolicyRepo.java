package org.LLD.BookingCancellation.Repository;

import lombok.Getter;
import org.LLD.BookingCancellation.Model.CancellationPolicyRule;
import org.LLD.BookingCancellation.Model.CancellationResult;

import java.util.ArrayList;
import java.util.List;

@Getter
public class CancellationPolicyRepo {

    private static CancellationPolicyRepo instance;
    private final List<CancellationPolicyRule> cancellationPolicyRules;

    private CancellationPolicyRepo() {
        this.cancellationPolicyRules = new ArrayList<>();
    }

    public synchronized static CancellationPolicyRepo getInstance() {
        if (instance == null) {
            instance = new CancellationPolicyRepo();
        }
        return instance;
    }
}
