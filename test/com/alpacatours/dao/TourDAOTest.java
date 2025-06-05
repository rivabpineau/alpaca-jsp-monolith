package com.alpacatours.dao;

import com.alpacatours.dao.TourDAO;
import com.alpacatours.dao.Database;
import com.alpacatours.dao.UserDAO;
import com.alpacatours.model.Tour;
import com.alpacatours.model.User;
import org.junit.Test;
import static org.junit.Assert.*;

public class TourDAOTest {
    @Test
    public void testSaveAndFind() {
        Database.reset();
        TourDAO dao = new TourDAO();
        UserDAO udao = new UserDAO();
        User guide = new User();
        guide.setUsername("bob");
        guide.setPassword("pw");
        guide.setRole("GUIDE");
        udao.save(guide);

        Tour tour = new Tour();
        tour.setTitle("City Tour");
        tour.setGuideId(guide.getId());
        dao.save(tour);

        assertEquals(1, dao.findAll().size());
        Tour found = dao.findById(tour.getId());
        assertNotNull(found);
        assertEquals("City Tour", found.getTitle());
        assertEquals(guide.getId(), found.getGuideId());
        assertEquals("bob", found.getGuideName());
    }
}
