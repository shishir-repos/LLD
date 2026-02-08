package org.LLD.LibraryManagement.Model;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Loan {
    String loadId;
    BookCopy copy;
    Member member;
    LocalDate startDate;
    BigDecimal fine;
    boolean isActive;
}
