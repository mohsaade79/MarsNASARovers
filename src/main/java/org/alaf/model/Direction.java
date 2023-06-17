package org.alaf.model;

public class Direction {
    public final static Direction N= new Direction(0,"North");
    public final static Direction E= new Direction(1,"Est");
    public final static Direction S= new Direction(2,"South");
    public final static Direction W= new Direction(3,"West");

    private static Direction tab[]={N,E,S,W};

    private int index;
    private String name;

    private Direction(int index, String name) {
        this.index = index;
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public Direction toRight(){
        return tab[(this.index+1)%tab.length];
    }
    public Direction toLeft(){
        return tab[Math.abs(this.index+tab.length-1)%tab.length];
    }
}
