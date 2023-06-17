package org.alaf.model;

import org.alaf.exceptions.IllegalStateException;
import org.alaf.exceptions.InvalidCommandException;
import org.alaf.exceptions.InvalidDirectionException;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

public class Rover {
    private Position currentPosition;
    String commands;

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public String getCommands() {
        return commands;
    }

    public void setCurrentPosition(Position currentPosition) {
        this.currentPosition = currentPosition;
    }

    public void setCommands(String commands) {
        this.commands = commands;
    }

    public Rover() throws IllegalStateException {
        currentPosition = new Position();
        commands = "";
    }

    public Rover(int x, int y, char direction, String commands) throws InvalidDirectionException, IllegalStateException {
        this.commands = commands;
        switch (direction) {
            case 'N' -> this.currentPosition = new Position(x, y, Direction.N);
            case 'S' -> this.currentPosition = new Position(x, y, Direction.S);
            case 'E' -> this.currentPosition = new Position(x, y, Direction.E);
            case 'W' -> this.currentPosition = new Position(x, y, Direction.W);
            default -> throw new InvalidDirectionException(direction);
        }
    }

    public void startMove(int maxX,int maxY) throws InvalidCommandException, IllegalStateException {
        CharacterIterator it = new StringCharacterIterator(commands);

        while (it.current() != CharacterIterator.DONE) {
          executeCommand(it.current(),maxX,maxY);
            it.next();
        }
    }

    public void executeCommand(char command,int maxX,int maxY) throws InvalidCommandException, IllegalStateException {
        switch (command) {
            case 'L' -> currentPosition.turnLeft();
            case 'R' -> currentPosition.turnRight();
            case 'M' ->
                         { currentPosition.move();
                         if (currentPosition.getX()<0 ||currentPosition.getX()>maxX ||
                         currentPosition.getY()<0||currentPosition.getY()>maxY)
                             throw new IllegalStateException("("+currentPosition.getX()+", "+currentPosition.getY()+" cannot be negatifs or greater than ("+maxX+","+maxY+")");
                         }

            default -> throw new InvalidCommandException(command);
        }
    }

    @Override
    public String toString() {
        return currentPosition+" ";
    }
}
