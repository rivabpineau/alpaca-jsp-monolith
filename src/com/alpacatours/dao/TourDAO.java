package com.alpacatours.dao;

import com.alpacatours.model.Tour;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TourDAO {
    public void save(Tour tour) {
        Connection conn = Database.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO tours(title, location, price, description, capacity, guideId) VALUES (?,?,?,?,?,?)",
                Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, tour.getTitle());
            ps.setString(2, tour.getLocation());
            ps.setDouble(3, tour.getPrice());
            ps.setString(4, tour.getDescription());
            ps.setInt(5, tour.getCapacity());
            ps.setInt(6, tour.getGuideId());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    tour.setId(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Tour> findAll() {
        List<Tour> list = new ArrayList<>();
        Connection conn = Database.getConnection();
        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT id,title,location,price,description,capacity,guideId FROM tours")) {
            while (rs.next()) {
                Tour t = new Tour();
                t.setId(rs.getInt("id"));
                t.setTitle(rs.getString("title"));
                t.setLocation(rs.getString("location"));
                t.setPrice(rs.getDouble("price"));
                t.setDescription(rs.getString("description"));
                t.setCapacity(rs.getInt("capacity"));
                t.setGuideId(rs.getInt("guideId"));
                list.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Tour findById(int id) {
        Connection conn = Database.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(
                "SELECT id,title,location,price,description,capacity,guideId FROM tours WHERE id=?")) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Tour t = new Tour();
                    t.setId(rs.getInt("id"));
                    t.setTitle(rs.getString("title"));
                    t.setLocation(rs.getString("location"));
                    t.setPrice(rs.getDouble("price"));
                    t.setDescription(rs.getString("description"));
                    t.setCapacity(rs.getInt("capacity"));
                    t.setGuideId(rs.getInt("guideId"));
                    return t;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
