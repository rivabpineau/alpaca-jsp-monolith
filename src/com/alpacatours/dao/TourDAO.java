package com.alpacatours.dao;

import com.alpacatours.model.Tour;
import java.util.ArrayList;
import java.util.List;

public class TourDAO {
    private static final List<Tour> tours = new ArrayList<>();
    private static int idCounter = 1;

    public void save(Tour tour) {
        tour.setId(idCounter++);
        tours.add(tour);
    }

    public List<Tour> findAll() {
        return tours;
    }

    public Tour findById(int id) {
        for (Tour t : tours) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }
}
