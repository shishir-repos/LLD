package org.LLD.BookMyShow.Strategy;

import org.LLD.BookMyShow.Model.Seat;

import java.util.List;

public interface PricingStrategy {
    double calculate(List<Seat> seats);
}
