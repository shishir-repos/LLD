package org.LLD.BookMyShow.Strategy;

import org.LLD.BookMyShow.Model.Seat;

import java.util.List;

public class StandardPricing implements PricingStrategy {
    @Override
    public double calculate(List<Seat> seats) {
        return seats.stream().mapToDouble(Seat::getPrice).sum();
    }
}
