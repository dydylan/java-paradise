package com.formation.app;

import java.sql.*;

public class Launcher {

    private static final String URL = "jdbc:mysql://localhost:8889/db_java_paradise";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {

        // Loading database driver
        Launcher l = new Launcher();
        l.loadDriver();

        //Creating Connection to Database
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Query SELECT
        String query = "SELECT * FROM place";
        try (Statement st = connection.createStatement()){
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                Long id = rs.getLong("id");
                String nom = rs.getString("nom");
//                Date date = rs.getDate("date");

                System.out.println(id);
                System.out.println(nom);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            connection.close();
        } catch (SQLException e) {
            System.err.println("Cannot closing connection");
        }



    }
    private void loadDriver(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
            System.err.println("erreur");

        }
    }
}
