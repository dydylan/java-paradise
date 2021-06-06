package com.formation.app.dao.jdbc;

import com.formation.app.dao.PlaceDao;
import com.formation.app.Place;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcPlaceDao extends JdbcDao implements PlaceDao{
    @Override
    public Place create(Place place) {
        return null;
    }

    @Override
    public Place findById(Long id) {
        return null;
    }

    @Override
    public boolean update(Place place) {
        return false;
    }

    @Override
    public boolean remove(Long id) {
        return false;
    }

    @Override
    public List<Place> findAll() {
        List<Place> placeList = new ArrayList<>();

        String query = "SELECT * FROM place";
        try (Statement st = this.connection.createStatement()) {
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                placeList.add(mapToPlace(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return placeList;
    }

    private Place mapToPlace(ResultSet rs) throws SQLException {
        Long id = rs.getLong("id");
        String name = rs.getString("nom");
        return new Place(id, name);
    }

//    @Override
//    public Boolean create(Place p) {
//        List<...> ... = new ArrayList<>();
//
//        String query = "...";
//        try () {
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return "...";
//    }
//
//    @Override
//    public List<Place> findAll() {
//        List<...> ... = new ArrayList<>();
//
//        String query = "...";
//        try () {
//
//        }
//    } catch (SQLException e) {
//        e.printStackTrace();
//        }
//        return "...";
//    }
//
//
//
//
//    @Override
//    public Boolean update(Place p) {
//        List<...> ... = new ArrayList<>();
//
//        String query = "...";
//        try () {
//
//        } catch (SQLException e) {
//        e.printStackTrace();
//        }
//        return "...";
//    }
//
//    @Override
//    public Place findById(Long ID) {
//        List<...> ... = new ArrayList<>();
//
//        String query = "...";
//        try () {
//
//        } catch (SQLException e) {
//        e.printStackTrace();
//        }
//        return "...";
//
//    }
}
