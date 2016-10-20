package com.github.gaddsky.labyrinthServer.db;


import com.github.gaddsky.labyrinthServer.domain.User;

public interface IUserDB {
    int create(User user);

    User get(int id);

    void update(User user);

    void delete(int id);
}
