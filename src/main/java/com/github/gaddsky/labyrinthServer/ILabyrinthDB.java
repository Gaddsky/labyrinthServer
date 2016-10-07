package com.github.gaddsky.labyrinthServer;


/**
 * This interface describes the representation of labyrinth in database
 */
public interface ILabyrinthDB {
    Environment getCellEnvironment(int x, int y);
    void deleteLabyrinth(int id);
}
