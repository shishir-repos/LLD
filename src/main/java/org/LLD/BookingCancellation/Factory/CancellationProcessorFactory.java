package org.LLD.BookingCancellation.Factory;

import org.LLD.BookingCancellation.Model.ProductType;
import org.LLD.BookingCancellation.Strategy.CancellationStrategy;
import org.LLD.BookingCancellation.Strategy.FlightCancellationProcessor;

public class CancellationProcessorFactory {

    public static CancellationStrategy getCancellationStrategy(ProductType productType) {
        if (productType == ProductType.FLIGHT) {
            return new FlightCancellationProcessor();
        } else {
            return new FlightCancellationProcessor();
        }
    }

}
