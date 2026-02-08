package org.LLD.LibraryManagement.Strategy;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface FineStrategy {
    BigDecimal calculateFine(LocalDate startDate, LocalDate returnDate);
}
