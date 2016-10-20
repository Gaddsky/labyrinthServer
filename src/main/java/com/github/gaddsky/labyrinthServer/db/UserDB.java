package com.github.gaddsky.labyrinthServer.db;


import com.github.gaddsky.labyrinthServer.domain.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class UserDB implements IUserDB {
    private Map<Integer, User> fakeDB = new HashMap<>();

    @Override
    public int create(User user) {
        Random rand = new Random();
        user.setId(rand.nextInt());
        fakeDB.put(user.getId(), user);
        return user.getId();
    }

    @Override
    public User get(int id) {
        return fakeDB.get(id);
    }

    @Override
    public void update(User user) {
        int userID = user.getId();
        fakeDB.replace(userID, user);
    }

    @Override
    public void delete(int id) {
        fakeDB.remove(id);
    }

}
