package com.formation.app.dao.jdbc;

import com.formation.app.model.Place;
import com.formation.app.dao.TripDao;
import com.formation.app.model.Trip;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcTripDao extends JdbcDao implements TripDao<Place> {
    @Override
    public Trip create(Trip trip) {
        Trip createdTrip = null;
        String query = "INSERT INTO fruits (departure, destination, price) VALUES(?,?,?)";
        try (PreparedStatement pst = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            pst.setLong(1, trip.getDeparture());
            pst.setLong(2, trip.getDestination());
            pst.setFloat(3, trip.getPrice());
            pst.execute();

            ResultSet rs = pst.getGeneratedKeys();
            rs.next();
            Long id = rs.getLong(1);

            connection.commit();

            createdTrip = findById(id);

        } catch (SQLException e1) {
            e1.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
        return createdTrip;
    }

    @Override
    public Trip findById(Long id) {
        String query = "SELECT * FROM trip WHERE id = ?";
        Trip foundTrip = null;
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setLong(1, id);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                foundTrip = mapToTrip(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return foundTrip;
    }

    @Override
    public boolean update(Trip trip) {
        int updateRows = 0;
        String query = "UPDATE fruits SET name= ?, expirationDate= ? WHERE id=?";
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setLong(1, trip.getDeparture());
            pst.setLong(2, trip.getDestination());
            pst.setFloat(3, trip.getPrice());

            updateRows = pst.executeUpdate();

            connection.commit();

        } catch (SQLException e1) {
            e1.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
        return updateRows > 0;
    }

    @Override
    public boolean remove(Long id) {
        boolean isDeleted = false;
        String query = "DELETE FROM trip WHERE id = ?";
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setLong(1, id);
            isDeleted = pst.execute();
            connection.commit();
        } catch (SQLException e1) {
            e1.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
        return isDeleted;
    }

    @Override
    public List<Trip> findAll() {
        List<Trip> tripList = new ArrayList<>();

        String query = "SELECT * FROM trip";
        try (Statement pst = this.connection.createStatement()) {
            ResultSet rs = pst.executeQuery(query);
            while (rs.next()) {
                tripList.add(mapToTrip(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tripList;
    }

    private Trip mapToTrip(ResultSet rs) throws SQLException {
        Long id = rs.getLong("id");
        Long departure = rs.getLong("departure");
        Long destination = rs.getLong("destination");
        Float price = rs.getFloat("price");
        return new Trip(id, departure, destination, price);
    }

    @Override
    public List<Trip> findByDestination(Place Place) {
        return null;
    }
}
