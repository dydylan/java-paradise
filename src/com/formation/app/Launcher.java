package com.formation.app;

//import com.formation.app.dao.DaoFactory;
import com.formation.app.dao.jdbc.JdbcPlaceDao;
import com.formation.app.dao.jdbc.JdbcTripDao;
import com.formation.app.model.Place;
import com.formation.app.model.Trip;
import com.formation.app.util.ConnectionManager;

import java.util.List;
import java.util.Scanner;

public class Launcher {

    public static void main(String[] args) {
        ConnectionManager.getConnection();

        JdbcPlaceDao placeQuery = new JdbcPlaceDao();
        JdbcTripDao tripQuery = new JdbcTripDao();

        List<Place> listPlaces = placeQuery.findAll();
        List<Trip> listTrips = tripQuery.findAll();

        Scanner scanner = new Scanner(System.in);

        boolean passageInTheLoop = true;

        String input;

        do {
            System.out.println("---------------------------");
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
                        System.out.println("We will create a new place");
                        System.out.println("Please enter name of this place : ");
                        input = scanner.nextLine();
                        Place place = new Place(input);
                        placeQuery.create(place);
                        System.out.println("The place " + place.getName() + " has been created");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case "2":
                    try {
                        System.out.println("What is the id of the place you are looking for?");
                        input = scanner.nextLine();
                        System.out.println("Place : " + listPlaces.get(Integer.parseInt(input)).getName());
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Incorrect if of place");
                    }
                    break;

                case "3":
                    try {
                        System.out.println("Please enter the id of the place you want to update : ");
                        String inputId = scanner.nextLine();
                        System.out.println("Please enter the new name of this place : ");
                        String inputName = scanner.nextLine();
                        listPlaces.get(Integer.parseInt(inputId)).setName(inputName);
                        System.out.println("The place " + listPlaces.get(Integer.parseInt(inputId)).getName() + " has been updated");
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case "4":
                    try {
                        System.out.println("Please enter the id of the place you want to remove : ");
                        input = scanner.nextLine();

                        Place place = placeQuery.findById(Long.parseLong(input));
                        System.out.println("Place : " + place.getName());

                        System.out.println("Are you sure you want to remove it ? (please reply with 'yes' or 'no')");
                        input = scanner.nextLine();

                        if (input.equals("yes")) {
                            placeQuery.remove(place.getId());
                            System.out.println("The place has been deleted");
                        }
                        else{
                            System.out.println("The deletion has been canceled");
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case "5":
                    try {
                        System.out.println("We will create a new trip");
                        System.out.println("Departure : please enter the id of the place : ");
                        Long inputDeparture = scanner.nextLong();
                        System.out.println("Destination : please enter the id of the place : ");
                        Long inputDestination = scanner.nextLong();
                        System.out.println("Please enter the price of this trip : ");
                        Float inputPrice = scanner.nextFloat();
                        Trip trip = new Trip(inputDeparture, inputDestination, inputPrice);
                        tripQuery.create(trip);
                        System.out.println("The trip from the place with the id " + trip.getDeparture() + " to the place with the id" + trip.getDestination() + " has been created");
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                    break;

                case "6":
                    try {
                        System.out.println("What is the id of the trip you are looking for?");
                        input = scanner.nextLine();
                        int id_departure = Math.toIntExact(listTrips.get(Integer.parseInt(input)).getDeparture()) - 1;
                        int id_destination = Math.toIntExact(listTrips.get(Integer.parseInt(input)).getDestination()) - 1;
                        System.out.println("Departure : " + listPlaces.get(id_departure).getName());
                        System.out.println("Destination : " + listPlaces.get(id_destination).getName());
                        System.out.println("Price : " + listTrips.get(Integer.parseInt(input)).getPrice());
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Incorrect id of trip");
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