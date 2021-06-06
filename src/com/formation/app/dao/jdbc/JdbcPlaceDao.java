package com.formation.app.dao.jdbc;

import com.formation.app.dao.PlaceDao;
import com.formation.app.model.Place;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcPlaceDao extends JdbcDao implements PlaceDao{
    @Override
    public Place create(Place place) {
        Place createdPlace = null;
        String query = "INSERT INTO places (name) VALUES(?)";
        try (PreparedStatement pst = this.connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            pst.setString(1, place.getName());

            ResultSet resultSet = pst.getGeneratedKeys();
            resultSet.next();
            Long id = resultSet.getLong(1);

            this.connection.commit();

            createdPlace = findById(id);

        } catch (SQLException e1) {
            e1.printStackTrace();
            try {
                this.connection.rollback();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }

        return createdPlace;
    }

    @Override
    public Place findById(Long id) {
        String query = "SELECT * FROM place WHERE id = ?";
        Place foundPlace = null;
        try (PreparedStatement pst = this.connection.prepareStatement(query)) {
            pst.setLong(1, id);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                foundPlace = mapToPlace(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return foundPlace;
    }

    @Override
    public boolean update(Place place) {
        int updateRows = 0;
        String query = "UPDATE place SET name= ? WHERE id=?";
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setString(1, place.getName());
            pst.setLong(2, place.getId());

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
        String name = rs.getString("name");
        return new Place(id, name);
    }

}
