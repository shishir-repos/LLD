package org.LLD.LibraryManagement.Strategy;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PerDayFineStrategy implements FineStrategy {

    private final static long THRESHOLD_DAYS = 7;

    @Override
    public BigDecimal calculateFine(LocalDate startDate, LocalDate returnDate) {
        long overDueDays = Math.abs(THRESHOLD_DAYS - ChronoUnit.DAYS.between(startDate, returnDate));

        if (overDueDays > 0) {
            return BigDecimal.valueOf(overDueDays * 1.5);
        } else {
            return BigDecimal.ZERO;
        }
    }
}
