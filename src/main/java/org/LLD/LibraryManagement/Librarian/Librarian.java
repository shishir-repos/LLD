package org.LLD.LibraryManagement.Librarian;

import org.LLD.LibraryManagement.Manager.InventoryManager;
import org.LLD.LibraryManagement.Manager.LoanManager;
import org.LLD.LibraryManagement.Model.Loan;
import org.LLD.LibraryManagement.Model.Member;
import org.LLD.LibraryManagement.Repository.BookRepository;
import org.LLD.LibraryManagement.Repository.LoanRepository;
import org.LLD.LibraryManagement.Repository.MemberRepository;
import org.LLD.LibraryManagement.Strategy.PerDayFineStrategy;

import java.time.LocalDate;
import java.util.List;

public class Librarian {

    public static void main(String[] args) {

        BookRepository bookRepository = new BookRepository();
        LoanRepository loanRepository = new LoanRepository();
        MemberRepository memberRepository = new MemberRepository();

        InventoryManager inventoryManager = new InventoryManager(bookRepository);
        inventoryManager.addBookAndCopies(1, "Java Core", "Shishir", 3);

        Member member = new Member(123, "Shishir");
        memberRepository.addMembers(List.of(member));

        LoanManager loanManager = new LoanManager(bookRepository, loanRepository, new PerDayFineStrategy());

        Loan loan = loanManager.makeLoanRequest("Java Core", "Shishir", LocalDate.now(), LocalDate.now().plusDays(8), member);
        loan = loanManager.makeLoanRequest("Java Core", "Shishir", LocalDate.now(), LocalDate.now().plusDays(8), member);
        loan = loanManager.makeLoanRequest("Java Core", "Shishir", LocalDate.now(), LocalDate.now().plusDays(8), member);

        loanManager.returnBook(loan, LocalDate.now().plusDays(9));

        loan = loanManager.makeLoanRequest("Java Core", "Shishir", LocalDate.now(), LocalDate.now().plusDays(8), member);


    }
}
