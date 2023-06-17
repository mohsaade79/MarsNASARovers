package org.alaf;

import org.alaf.exceptions.IllegalStateException;
import org.alaf.exceptions.InvalidDirectionException;
import org.alaf.model.Plateau;
import org.alaf.model.Rover;

import java.io.*;
import java.util.Scanner;

public class Main {
   private Plateau plateau;
   public static Scanner scanner=null;
   private InputStream is;
    public Main(String file)  {

        is = getClass().getClassLoader().getResourceAsStream(file);
        scanner = new Scanner(is);

        if(scanner.hasNextLine()) {
        String dimention[]=scanner.nextLine().split(" ");
        plateau= new Plateau(Integer.parseInt(dimention[0]),Integer.parseInt(dimention[1]));
        System.out.println(plateau);
        }

    }


    public void parseRovers() throws InvalidDirectionException, IllegalStateException {

        while (scanner.hasNextLine()) {
            String []positionLine=scanner.nextLine().split(" ");
            String commands=scanner.nextLine();
            plateau.addRover(new Rover(Integer.parseInt(positionLine[0]),
                    Integer.parseInt(positionLine[1]),
                    positionLine[2].charAt(0),
                    commands));
        }
    }
    public static void main(String[] args) {
        try {

            Main main= new Main(args[0]);
            main.parseRovers();
            main.plateau.moveRovers();

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            exception.printStackTrace();
        }
        finally {
            scanner.close();
        }
    }
}