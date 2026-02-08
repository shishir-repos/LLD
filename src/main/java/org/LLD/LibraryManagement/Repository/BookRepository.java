package org.LLD.LibraryManagement.Repository;

import lombok.Getter;
import org.LLD.LibraryManagement.Model.Book;

import java.util.ArrayList;
import java.util.List;

@Getter
public class BookRepository {

    List<Book> books = new ArrayList<>();

    public void addBooks(List<Book> books) {
        this.books.addAll(books);
    }

    public void addBook(Book book) {
        this.books.add(book);
    }
}
