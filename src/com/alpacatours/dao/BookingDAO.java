package com.alpacatours.dao;

import com.alpacatours.model.Booking;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookingDAO {
    public void save(Booking booking) {
        Connection conn = Database.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO bookings(userId, tourId, numPeople, bookingDate) VALUES (?,?,?,?)",
                Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, booking.getUserId());
            ps.setInt(2, booking.getTourId());
            ps.setInt(3, booking.getNumPeople());
            ps.setDate(4, booking.getBookingDate());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    booking.setId(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Booking> findAll() {
        List<Booking> list = new ArrayList<>();
        Connection conn = Database.getConnection();
        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT id,userId,tourId,numPeople,bookingDate FROM bookings")) {
            while (rs.next()) {
                Booking b = new Booking();
                b.setId(rs.getInt("id"));
                b.setUserId(rs.getInt("userId"));
                b.setTourId(rs.getInt("tourId"));
                b.setNumPeople(rs.getInt("numPeople"));
                b.setBookingDate(rs.getDate("bookingDate"));
                list.add(b);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
