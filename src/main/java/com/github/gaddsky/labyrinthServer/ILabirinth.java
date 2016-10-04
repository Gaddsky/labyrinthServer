package com.github.gaddsky.labyrinthServer;


public interface ILabirinth {
    int getCellState(int x, int y);
    boolean canMoveInDirection(int x, int y, String direction);

}
