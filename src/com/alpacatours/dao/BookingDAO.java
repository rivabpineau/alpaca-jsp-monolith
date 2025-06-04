package com.alpacatours.dao;

import com.alpacatours.model.Booking;
import java.util.ArrayList;
import java.util.List;

public class BookingDAO {
    private static final List<Booking> bookings = new ArrayList<>();
    private static int idCounter = 1;

    public void save(Booking booking) {
        booking.setId(idCounter++);
        bookings.add(booking);
    }

    public List<Booking> findAll() {
        return bookings;
    }
}
