package org.alaf;

import org.alaf.exceptions.IllegalStateException;
import org.alaf.exceptions.InvalidDirectionException;
import org.alaf.model.Plateau;
import org.alaf.model.Rover;

import java.io.*;
import java.util.Scanner;

public class NASARoverApplication {
   private Plateau plateau;
   public static Scanner scanner;
   private InputStream inputStream;
    public NASARoverApplication(String file)  {

        inputStream = getClass().getClassLoader().getResourceAsStream(file);
        scanner = new Scanner(inputStream);

        if(scanner.hasNextLine()) {
        String dimension[]=scanner.nextLine().split(" ");
        plateau= new Plateau(Integer.parseInt(dimension[0]),Integer.parseInt(dimension[1]));
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

            NASARoverApplication application= new NASARoverApplication(args[0]);
            application.parseRovers();
            application.plateau.moveRovers();

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            exception.printStackTrace();
        }
        finally {
            scanner.close();
        }
    }
}