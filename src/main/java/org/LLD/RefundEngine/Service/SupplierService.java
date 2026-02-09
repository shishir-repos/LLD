package org.LLD.RefundEngine.Service;

import org.LLD.RefundEngine.Model.RefundRequest;

import java.util.logging.Logger;

public class SupplierService {

    Logger logger = Logger.getLogger(SupplierService.class.getName());

    public boolean supplierValidityCheckAPI(RefundRequest refundRequest) {
        logger.info("Calling Supplier API to check if refund is Valid...");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return true;
    }

}
