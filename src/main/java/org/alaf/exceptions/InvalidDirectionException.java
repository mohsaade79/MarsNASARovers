package org.alaf.exceptions;

public class InvalidDirectionException extends Exception{
    public InvalidDirectionException(char message) {
        super(message+" is not a valid cardinal compass points");
    }
}
