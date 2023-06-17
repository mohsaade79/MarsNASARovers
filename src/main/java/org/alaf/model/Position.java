package org.alaf.model;

import org.alaf.exceptions.IllegalStateException;

public class Position {
    private int x;
    private int y;
    Direction dir;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direction getDir() {
        return dir;
    }

    public Position() throws IllegalStateException {
        this(0,0,Direction.N);

    }

    public Position(int x, int y, Direction dir) throws IllegalStateException {
        setX(x);
        setY(y);
        this.dir = dir;
    }
    public void turnRight(){
        this.dir=dir.toRight();
    }
    public void turnLeft(){
        this.dir=dir.toLeft();
    }
    public void move(){
        switch (dir.getName()){
            case "North"->y++;
            case "Est" ->x++;
            case "South"->y--;
            case "West"->x--;
        }
    }

    @Override
    public String toString() {
        String output=  x + " " + y + " ";
        switch (dir.getName()){
            case "North"->output+="N";
            case "Est" ->output+="E";
            case "South"->output+="S";
            case "West"->output+="W";
        }
        return  output;
    }

    public void setX(int x) throws IllegalStateException {
        if (x<0)
            throw new IllegalStateException(x+"");
        this.x = x;
    }

    public void setY(int y) throws IllegalStateException {
        if (y<0)
            throw new IllegalStateException(y+"");
        this.y = y;
    }

    public void setDir(Direction dir) {
        this.dir = dir;
    }
}
