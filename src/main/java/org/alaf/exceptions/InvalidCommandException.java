package org.alaf.exceptions;

public class InvalidCommandException extends Exception {
    public InvalidCommandException(char command) {
        super(command+ " is not a valid command. Valid command are : \'L\', \'R\' or \'M\'.");
    }
}
