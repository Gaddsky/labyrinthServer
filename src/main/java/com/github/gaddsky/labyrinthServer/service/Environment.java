package com.github.gaddsky.labyrinthServer.service;


import java.util.HashMap;
import java.util.Map;

public class Environment {
    private Map <String, Boolean> isWall = new HashMap<>();

    public Environment(boolean northWall, boolean eastWall, boolean southWall, boolean westWall) {
        isWall.put("north", northWall);
        isWall.put("east", eastWall);
        isWall.put("south", southWall);
        isWall.put("west", westWall);
    }

    public Environment(byte cellState) {
        if (cellState > 0b1111) {
            throw new IllegalArgumentException("Illegal cell state! Only four bits allowed");
        }
        isWall.put("north",(cellState & 0b1000) > 0);
        isWall.put("east", (cellState & 0b0100) > 0);
        isWall.put("south", (cellState & 0b0010) > 0);
        isWall.put("west", (cellState & 0b0001) > 0);
    }

    public boolean isNorthWall() {
        return isWall.get("north");
    }

    public boolean isEastWall() {
        return isWall.get("east");
    }

    public boolean isSouthWall() {
        return isWall.get("south");
    }

    public boolean isWestWall() {
        return isWall.get("west");
    }

    public boolean isWall(String direction) {
        return isWall.get(direction);
        }
    }
