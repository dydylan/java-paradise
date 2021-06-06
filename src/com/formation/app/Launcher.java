package com.formation.app;

//import com.formation.app.dao.DaoFactory;
import com.formation.app.dao.jdbc.JdbcPlaceDao;
import com.formation.app.util.ConnectionManager;

import java.util.List;

public class Launcher {

    public static void main(String[] args) {
        ConnectionManager.getConnection();

        JdbcPlaceDao placeQuery = new JdbcPlaceDao();

        List<Place> p = placeQuery.findAll();
        for (int i = 0; i < p.size(); i++) {
            System.out.println(p.get(i).getName());
            System.out.println(p.get(i).getId());
        }
        ConnectionManager.closeConnection();
    }    //psvm



//    Scanner scanner = new Scanner(System.in);
//
//    String input;
//
//        do {
//        System.out.println("What do you want to do ?");
//        System.out.println("1 - Add a place");
//        System.out.println("2 - Find a place");
//        System.out.println("3 - Edit a place");
//        System.out.println("4 - Remove a place");
//        System.out.println("5 - Add a trip");
//        System.out.println("6 - Find a trip");
//        System.out.println("7 - Remove a trip");
//        System.out.println("8 - Quit");
//        System.out.println();
//
//        input = scanner.nextLine();
//
//        switch (input) {
//            case "1":
//                try {
//                    System.out.print("Name : ");
//                    input = scanner.nextLine();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//
//                break;
//
//            case "2":
//                try {
//                    System.out.print("Id : ");
//                    input = scanner.nextLine();
//                } catch (Exception e) {
//                    System.err.println("Place not found");
//                    System.out.println();
//                }
//                break;
//
//            case "3":
//                try {
//                    System.out.print("Id : ");
//                    input = scanner.nextLine();
//                }
//                catch (Exception e) {
//                    e.printStackTrace();
//                }
//                break;
//
//            case "4":
//                try {
//                    System.out.print("Id : ");
//                    input = scanner.nextLine();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                break;
//
//            case "5":
//                try {
//
//                    System.out.print("Departure : please enter the id of the place : ");
//                    input = scanner.nextLine();
//
//                }
//                catch (Exception e){
//                    e.printStackTrace();
//                }
//
//                break;
//
//            case "6":
//                try {
//                    System.out.print("Id : ");
//                    input = scanner.nextLine();
//                }
//                catch (Exception e){
//                    System.err.println("Trip not found");
//                }
//                break;
//
//            case "7":
//                try {
//                    System.out.print("Id : ");
//                    input = scanner.nextLine();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                break;
//
//            case "8":
//                System.out.println("Do you really want to quit ? (retype 8 to confirm)");
//                input = scanner.nextLine();
//                break;
//
//            default:
//                System.out.println("the input is wrong : please retry");
//        }
//        System.out.println();
//
//    } while (!input.equals("8"));
}