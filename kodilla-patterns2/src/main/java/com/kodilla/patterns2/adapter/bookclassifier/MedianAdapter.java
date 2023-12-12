package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclassifier.librarya.Book;
import com.kodilla.patterns2.adapter.bookclassifier.librarya.Classifier;
import com.kodilla.patterns2.adapter.bookclassifier.libraryb.BookSignature;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MedianAdapter extends MedianAdaptee implements Classifier  {
    @Override
    public int publicationYearMedian(Set<Book> bookSet) {
        Map<BookSignature, com.kodilla.patterns2.adapter.bookclassifier.libraryb.Book> bookList = new HashMap<>();
        for (Book bookA : bookSet) {
            bookList.put(
                    new BookSignature(bookA.getSignature()),
                    new com.kodilla.patterns2.adapter.bookclassifier.libraryb.Book
                            (bookA.getAuthor(), bookA.getTitle(), bookA.getPublicationYear())
            );
        }
        return medianPublicationYear(bookList);
    }
}
