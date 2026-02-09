package org.LLD.RefundEngine.Repository;

import lombok.Getter;
import org.LLD.RefundEngine.Model.RefundRequest;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Getter
public class RefundRepository {
    private static RefundRepository instance;
    private final ConcurrentHashMap<String, RefundRequest> refunds = new ConcurrentHashMap<>();

    private RefundRepository() {

    }

    public synchronized static RefundRepository getInstance() {
        if (instance == null) {
            instance = new RefundRepository();
        }
        return instance;
    }
}
