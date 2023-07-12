package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.w3c.dom.ls.LSOutput;

import java.time.LocalDate;

public class LibraryTestSuite {

    @Test
    void testGetBooks() {
        //Given
        Book book1 = new Book("King", "Jan Kowalski", LocalDate.of(2016,11,2));
        Book book2 = new Book("Queen", "John Smith", LocalDate.of(1986,12,12));
        Book book3 = new Book("Princes", "Ho Perk", LocalDate.of(2011,11,9));
        Book book4 = new Book("Prince", "Stavros Andio", LocalDate.of(2022,1,2));
        Book book5 = new Book("Travel", "Joanna Smith", LocalDate.of(2006,5,6));

        Library library = new Library("Library Paphos");
        library.getBooks().add(book1);
        library.getBooks().add(book2);
        library.getBooks().add(book3);
        library.getBooks().add(book4);
        library.getBooks().add(book5);


        //making a shallow copy of object board
        Library clonedLibrary = null;
        try {
            clonedLibrary = library.shallowCopy();
            clonedLibrary.setName("Library Lemessos");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //making a deep copy of object board
        Library deepClonedLibrary = null;
        try {
            deepClonedLibrary = library.deepCopy();
            deepClonedLibrary.setName("Library Larnaca");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //When
        Book book6 = new Book("Glass", "Jonathan Kowalski", LocalDate.of(2023, 6,20));
        library.getBooks().add(book6);

        //Then
        System.out.println(library);
        System.out.println(clonedLibrary);
        System.out.println(deepClonedLibrary);
        Assertions.assertEquals(6, library.getBooks().size());
        Assertions.assertEquals(6, clonedLibrary.getBooks().size());
        Assertions.assertEquals(5, deepClonedLibrary.getBooks().size());
        Assertions.assertTrue(library.getBooks().contains(book1));
        Assertions.assertEquals("Library Lemessos", clonedLibrary.getName());
        Assertions.assertNotEquals(library.getBooks().size(), deepClonedLibrary.getBooks().size());
        Assertions.assertEquals(library.getBooks().size(), clonedLibrary.getBooks().size());
        Assertions.assertFalse(deepClonedLibrary.getBooks().contains(book6));
    }
}
