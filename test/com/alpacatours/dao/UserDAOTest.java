package com.alpacatours.dao;

import com.alpacatours.dao.UserDAO;
import com.alpacatours.dao.Database;
import com.alpacatours.model.User;
import org.junit.Test;
import static org.junit.Assert.*;

public class UserDAOTest {
    @Test
    public void testSaveAndFindByUsername() {
        Database.reset();
        UserDAO dao = new UserDAO();
        User user = new User();
        user.setUsername("alice");
        user.setPassword("secret");
        user.setRole("CUST");
        dao.save(user);
        User found = dao.findByUsername("alice");
        assertNotNull(found);
        assertEquals("alice", found.getUsername());
        assertEquals("secret", found.getPassword());
    }

    @Test
    public void testFindAll() {
        Database.reset();
        UserDAO dao = new UserDAO();
        User a = new User();
        a.setUsername("a");
        a.setRole("CUST");
        dao.save(a);
        User b = new User();
        b.setUsername("b");
        b.setRole("CUST");
        dao.save(b);
        assertEquals(2, dao.findAll().size());
    }
}
