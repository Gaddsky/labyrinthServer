package com.github.gaddsky.labyrinthServer;


public class FakeLabyrinth implements ILabirinth {
    private String name;
    private int width;
    private int height;
    private byte[][] labyrinth;

    public FakeLabyrinth(String name) {
        this.name = name;
        this.width = 4;
        this.height = 4;
        labyrinth = new byte[][]{
                {0b0111, 0b0011, 0b1010, 0b1110},
                {0b1001, 0b1000, 0b0010, 0b0110},
                {0b0011, 0b1010, 0b1100, 0b0101},
                {0b1001, 0b1110, 0b1011, 0b1100}
        };
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public byte[][] getLabyrinth() {
        return labyrinth;
    }


}
