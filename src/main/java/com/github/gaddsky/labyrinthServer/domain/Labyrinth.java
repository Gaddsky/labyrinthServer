package com.github.gaddsky.labyrinthServer.domain;


public class Labyrinth {
    private int id;
    private String name;
    private int width;
    private int height;
    private byte[][] map;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public byte[][] getMap() {
        return map;
    }

    public void setMap(byte[][] map) {
        this.map = map;
    }

    public byte getCell(int x, int y) {
        return map[y][x];
    }
}
