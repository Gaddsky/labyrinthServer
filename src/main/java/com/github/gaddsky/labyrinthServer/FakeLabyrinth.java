package com.github.gaddsky.labyrinthServer;


public class FakeLabyrinth implements ILabirinth{
    private final int width = 4;
    private final int height = 4;
    private int[][] labyrinth = {
            {0b0111, 0b0011, 0b1010, 0b1110},
            {0b1001, 0b1000, 0b0010, 0b0110},
            {0b0011, 0b1010, 0b1100, 0b0101},
            {0b1001, 0b1110, 0b1011, 0b1100}
    };

    @Override
    public int getCellState(int x, int y) {
        if (x >= width || y >= height) {
            throw new IllegalArgumentException("Cell coordinates out of labyrinth's dimensions!");
        }
        return labyrinth[y][x];
    }

    @Override
    public boolean canMoveInDirection(int x, int y, String direction) {
        switch (direction) {
            case "north":
                return (getCellState(x, y) & 0b1000) == 0;
            case "east":
                return (getCellState(x, y) & 0b0100) == 0;
            case "south":
                return (getCellState(x, y) & 0b0010) == 0;
            case "west":
                return (getCellState(x, y) & 0b0001) == 0;
            default:
                throw new IllegalArgumentException("Unknown direction");
        }
    }


}
