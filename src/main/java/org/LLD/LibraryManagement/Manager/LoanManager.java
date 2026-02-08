package org.LLD.LibraryManagement.Manager;

import org.LLD.LibraryManagement.Model.Book;
import org.LLD.LibraryManagement.Model.BookCopy;
import org.LLD.LibraryManagement.Model.Loan;
import org.LLD.LibraryManagement.Model.Member;
import org.LLD.LibraryManagement.Repository.BookRepository;
import org.LLD.LibraryManagement.Repository.LoanRepository;
import org.LLD.LibraryManagement.Strategy.FineStrategy;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;

public class LoanManager {

    private final Logger logger = Logger.getLogger(LoanManager.class.getName());
    private final BookRepository bookRepository;
    private final LoanRepository loanRepository;
    private final FineStrategy fineStrategy;

    public LoanManager(BookRepository bookRepository, LoanRepository loanRepository, FineStrategy fineStrategy) {
        this.bookRepository = bookRepository;
        this.loanRepository = loanRepository;
        this.fineStrategy = fineStrategy;
    }

    public Loan makeLoanRequest(String bookName, String authorName, LocalDate startDate, LocalDate returnDate, Member member) {

        List<Book> books = bookRepository.getBooks();

        Book requestedBook = books.stream().filter(book -> bookName.equals(book.getName()) && authorName.equals(book.getAuthor())).findAny().orElse(null);

        assert requestedBook != null;
        List<BookCopy> bookCopies = requestedBook.getBookCopies();

        BookCopy bookCopy = bookCopies.stream().filter(BookCopy::isAvailable).findFirst().orElse(null);

        if (bookCopy != null) {
            Loan loan = new Loan(System.currentTimeMillis() + member.getMemberName(), bookCopy, member, LocalDate.now(), BigDecimal.valueOf(0), true);

            bookCopy.setAvailable(false);
            loanRepository.addLoans(List.of(loan));
            member.getActiveLoans().add(loan);

            logger.info("Book: " + bookName + " issued to: " + member.getMemberName());
            logger.info("Book: " + bookName + " Available Quantity: " + bookCopies.stream().filter(BookCopy::isAvailable).count());
            logger.info("Loan Ticket Generated: " + loan);

            return loan;
        } else {
            throw new RuntimeException("No Copies Available for book: " + bookName);
        }
    }

    public void returnBook(Loan loan, LocalDate returnDate) {
        BookCopy bookCopy = loan.getCopy();

        BigDecimal fine = fineStrategy.calculateFine(loan.getStartDate(), returnDate);

        logger.info("Return Requested by: " + loan.getMember().getMemberName() + " for book " + loan.getCopy().getBook().getName());
        logger.info("Member: " + loan.getMember().getMemberName() + " is fined with " + fine);

        bookCopy.setAvailable(true);
        loan.setActive(false);
    }

}
