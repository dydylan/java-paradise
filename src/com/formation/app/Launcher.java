package com.formation.app;

//import com.formation.app.dao.DaoFactory;
import com.formation.app.dao.jdbc.JdbcPlaceDao;
import com.formation.app.dao.jdbc.JdbcTripDao;
import com.formation.app.util.ConnectionManager;

import java.util.List;
import java.util.Scanner;

public class Launcher {

    public static void main(String[] args) {
        ConnectionManager.getConnection();

        JdbcPlaceDao placeQuery = new JdbcPlaceDao();
        JdbcTripDao tripQuery = new JdbcTripDao();

        List<Place> listPlaces = placeQuery.findAll();
        List<Place> listTrips = placeQuery.findAll();

        Scanner scanner = new Scanner(System.in);

        boolean passageInTheLoop = true;

        String input;

        do {
            System.out.println("What do you want to do ?");
            System.out.println("1 - Add a place");
            System.out.println("2 - Find a place");
            System.out.println("3 - Edit a place");
            System.out.println("4 - Remove a place");
            System.out.println("5 - Add a trip");
            System.out.println("6 - Find a trip");
            System.out.println("7 - Remove a trip");
            System.out.println("8 - Quit");
            System.out.println();

            input = scanner.nextLine();

            switch (input) {
                case "1":
                    try {
                        System.out.print("Name : ");
                        input = scanner.nextLine();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    break;

                case "2":
                    try {
                        System.out.print("Id : ");
                        input = scanner.nextLine();
                        System.out.println(listPlaces.get(Integer.parseInt(input)).getName());
                    } catch (Exception e) {
                        System.err.println("Place not found");
                        System.out.println();
                    }
                    break;

                case "3":
                    try {
                        System.out.print("Id : ");
                        input = scanner.nextLine();
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case "4":
                    try {
                        System.out.print("Id : ");
                        input = scanner.nextLine();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case "5":
                    try {

                        System.out.print("Departure : please enter the id of the place : ");
                        input = scanner.nextLine();

                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }

                    break;

                case "6":
                    try {
                        System.out.print("Id : ");
                        input = scanner.nextLine();
                        System.out.println(listTrips.get(Integer.parseInt(input)).getName());
                    }
                    catch (Exception e){
                        System.err.println("Trip not found");
                    }
                    break;

                case "7":
                    try {
                        System.out.print("Id : ");
                        input = scanner.nextLine();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case "8":
                    System.out.println("Do you really want to quit ? (type 'yes' or 'y' to confirm)");
                    input = scanner.nextLine();
                    if(input.equals("yes") || input.equals("y"))
                    {
                        passageInTheLoop = false;
                    }
                    break;

                default:
                    System.out.println("The input is wrong : please retry");
            }
            System.out.println();

        } while (passageInTheLoop);
        System.out.println("Bye bye");


        ConnectionManager.closeConnection();
    }    //psvm

}