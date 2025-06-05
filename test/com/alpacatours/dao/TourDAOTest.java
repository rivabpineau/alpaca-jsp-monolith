package com.alpacatours.dao;

import com.alpacatours.dao.TourDAO;
import com.alpacatours.dao.Database;
import com.alpacatours.model.Tour;
import org.junit.Test;
import static org.junit.Assert.*;

public class TourDAOTest {
    @Test
    public void testSaveAndFind() {
        Database.reset();
        TourDAO dao = new TourDAO();
        Tour tour = new Tour();
        tour.setTitle("City Tour");
        tour.setGuideId(1);
        dao.save(tour);
        assertEquals(1, dao.findAll().size());
        Tour found = dao.findById(tour.getId());
        assertNotNull(found);
        assertEquals("City Tour", found.getTitle());
        assertEquals(1, found.getGuideId());
    }
}
