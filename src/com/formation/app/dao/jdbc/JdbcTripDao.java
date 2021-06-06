package com.formation.app.dao.jdbc;

import com.formation.app.Place;
import com.formation.app.dao.TripDao;
import com.formation.app.Trip;

import java.util.List;

public class JdbcTripDao extends JdbcDao implements TripDao<Place> {
    @Override
    public Trip create(Trip trip) {
        return null;
    }

    @Override
    public Trip findById(Long id) {
        return null;
    }

    @Override
    public boolean update(Trip trip) {
        return false;
    }

    @Override
    public boolean remove(Long id) {
        return false;
    }

    @Override
    public List<Trip> findAll() {
        return null;
    }

    @Override
    public List<Trip> findByDestination(Place Place) {
        return null;
    }

//    @Override
//    public Boolean create(Trip p) {
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
//    public List<Trip> findAll() {
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
//
//
//
//    @Override
//    public Boolean update(Trip t) {
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
//    public Trip findById(Long ID) {
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
}
