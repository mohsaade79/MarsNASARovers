package org.alaf.model;

import org.alaf.exceptions.IllegalStateException;
import org.alaf.exceptions.InvalidCommandException;

import java.util.ArrayList;
import java.util.Collection;

public class Plateau {
    private int maxX,maxY;
    Collection<Rover> rovers;

    public Plateau(int maxX, int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
        rovers= new ArrayList<>();
    }

    public void addRover(Rover rover){
        rovers.add(rover);
    }

    public void moveRovers()throws IllegalStateException, InvalidCommandException {
      if (rovers.size()>0)
          System.out.println("********************************");
      int i=0;
        for (Rover rover :rovers ) {

            System.out.println("Rover Number :"+ ++i +" \nstarts from :"+rover);
            rover.startMove(maxX,maxY);
            System.out.println("and arrives at :"+rover);
            System.out.println("********************************");
        }
    }

    @Override
    public String toString() {
        return "Plateau[(0,0)-->" +
                "(" + maxX +
                "," + maxY +
                ")]";
    }
}
