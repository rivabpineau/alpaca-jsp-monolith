package com.alpacatours.dao;

import com.alpacatours.model.User;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private static final List<User> users = new ArrayList<>();
    private static int idCounter = 1;

    public void save(User user) {
        user.setId(idCounter++);
        users.add(user);
    }

    public User findByUsername(String username) {
        for (User u : users) {
            if (u.getUsername().equals(username)) {
                return u;
            }
        }
        return null;
    }
}
