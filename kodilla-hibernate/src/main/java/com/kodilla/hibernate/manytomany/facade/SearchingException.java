package com.kodilla.hibernate.manytomany.facade;

public class SearchingException extends Exception {

    public static String ERR_NOT_FOUND = "No search results";

    public SearchingException(String message) {
        super(message);
    }

}
