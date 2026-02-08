package org.LLD.LibraryManagement.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BookCopy {
    int copyId;
    Book book;
    boolean isAvailable;
}
