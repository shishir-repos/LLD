package org.LLD.LibraryManagement.Manager;

import org.LLD.LibraryManagement.Model.Book;
import org.LLD.LibraryManagement.Model.BookCopy;
import org.LLD.LibraryManagement.Repository.BookRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class InventoryManager {

    Logger logger = Logger.getLogger(InventoryManager.class.getName());

    private final BookRepository bookRepository;

    public InventoryManager(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBookAndCopies(int bookId, String bookName, String author, int physicalCopyCount) {
        List<BookCopy> bookCopies = new ArrayList<>();

        Book book = new Book(bookId, bookName, author, bookCopies);

        for (int i = 0; i<physicalCopyCount; i++) {
            BookCopy copy = new BookCopy(i + 1, book, true);
            bookCopies.add(copy);
        }

        bookRepository.addBook(book);

        logger.info("Book: " + bookName + " is Added with " + physicalCopyCount + " number of physical copies.");
    }
}
