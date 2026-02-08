package org.LLD.LibraryManagement.Repository;

import org.LLD.LibraryManagement.Model.Loan;

import java.util.ArrayList;
import java.util.List;

public class LoanRepository {

    List<Loan> loans = new ArrayList<>();

    public void addLoans(List<Loan> loans) {
        this.loans.addAll(loans);
    }
}
