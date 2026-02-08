package org.LLD.BookingCancellation.Service;

import org.LLD.BookingCancellation.Model.CancellationPolicyRule;
import org.LLD.BookingCancellation.Repository.CancellationPolicyRepo;

import java.util.List;

public class CancellationPolicyUpdateService {

    private static CancellationPolicyUpdateService instance;
    private final CancellationPolicyRepo cancellationPolicyRepo;

    private CancellationPolicyUpdateService(CancellationPolicyRepo cancellationPolicyRepo) {
        this.cancellationPolicyRepo = cancellationPolicyRepo;
    }

    public static CancellationPolicyUpdateService getInstance(CancellationPolicyRepo cancellationPolicyRepo) {
        if (instance == null) {
            instance = new CancellationPolicyUpdateService(cancellationPolicyRepo);
        }
        return instance;
    }

    public void updateCancellationPolicies(CancellationPolicyRepo repo) {
        CancellationPolicyRule rule1 = new CancellationPolicyRule(new int[] {0,24},0.0);
        CancellationPolicyRule rule2 = new CancellationPolicyRule(new int[] {24 + 1, 24 * 7},0.3);
        CancellationPolicyRule rule3 = new CancellationPolicyRule(new int[] {24 * 7 + 1, Integer.MAX_VALUE}, 0.9);
        repo.getCancellationPolicyRules().addAll(List.of(rule1, rule2, rule3));
    }

}
