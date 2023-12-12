package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclassifier.librarya.Book;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class MedianAdapterTestSuite {

    @Test
    void publicationYearMedianTest() {

        //Given
        Set<Book> bookSet = new HashSet<>();
        bookSet.add(new Book("John Smith", "ABC", 1999, "123QWE"));
        bookSet.add(new Book("John Green", "ABCD", 2000, "223QWE"));
        bookSet.add(new Book("John White", "ABCDE", 2001, "323QWE"));
        bookSet.add(new Book("John Black", "ABCDEF", 2002, "423QWE"));
        MedianAdapter medianAdapter = new MedianAdapter();

        //When
        int medianResult = medianAdapter.publicationYearMedian(bookSet);

        //Then
        assertEquals(2001, medianResult);
    }

}