package com.github.gaddsky.labyrinthServer;

/**
 * This interface describes the representation of maze, which will be generated and after that stored in database
 */
public interface ILabirinth {
    String getName();

    int getWidth();

    int getHeight();

    byte[][] getLabyrinth();

}
