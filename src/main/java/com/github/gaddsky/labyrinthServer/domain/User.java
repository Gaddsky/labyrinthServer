package com.github.gaddsky.labyrinthServer.domain;


public class User {
    private int id;
    private String name;
    private String passwordHash;
    private int labyrinthID;
    private int x;
    private int y;

    public User(String name, int labyrinthID, int x, int y) {
        this.name = name;
        this.labyrinthID = labyrinthID;
        this.x = x;
        this.y = y;
    }

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

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public int getLabyrinthID() {
        return labyrinthID;
    }

    public void setLabyrinthID(int labyrinthID) {
        this.labyrinthID = labyrinthID;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
