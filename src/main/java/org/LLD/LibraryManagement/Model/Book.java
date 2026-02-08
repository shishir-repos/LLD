package org.LLD.LibraryManagement.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Book {
    int id;
    String name;
    String author;
    List<BookCopy> bookCopies;
}
