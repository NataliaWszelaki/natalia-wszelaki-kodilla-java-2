package com.kodilla.patterns.prototype.library;

import com.kodilla.patterns.prototype.TasksList;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public final class Library extends LibraryPrototype<Library> {

    String name;
    Set<Book> books = new HashSet<>();

    public Library(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Library shallowCopy() throws CloneNotSupportedException {
        return super.clone();
    }

    public  Library deepCopy() throws CloneNotSupportedException {
        Library clonedLibrary = super.clone();
        clonedLibrary.books = new HashSet<>();
        for (Book theBook : books) {
            clonedLibrary.getBooks().add(theBook);
        }
        return clonedLibrary;
    }

    public Set<Book> getBooks() {
        return books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Library library)) return false;
        return Objects.equals(name, library.name) && Objects.equals(books, library.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, books);
    }

    @Override
    public String toString() {
        String stringBooks =  "[ " + name + " ]" + "\n";
        for (Book theBook: books) {
            stringBooks = stringBooks + theBook.toString() + "\n";
        }
        return stringBooks;
    }
}
