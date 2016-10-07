package com.github.gaddsky.labyrinthServer;


public class Environment {
    private boolean northWall;
    private boolean eastWall;
    private boolean southWall;
    private boolean westWall;

    public Environment(boolean northWall, boolean eastWall, boolean southWall, boolean westWall) {
        this.northWall = northWall;
        this.eastWall = eastWall;
        this.southWall = southWall;
        this.westWall = westWall;
    }

    public Environment(byte cellState) {
        if (cellState > 0b1111) {
            throw new IllegalArgumentException("Illegal cell state! Only four bits allowed");
        }
        this.northWall = (cellState & 0b1000) > 0;
        this.eastWall = (cellState & 0b0100) > 0;
        this.southWall = (cellState & 0b0010) > 0;
        this.westWall = (cellState & 0b0001) > 0;
    }

    public boolean isNorthWall() {
        return northWall;
    }

    public boolean isEastWall() {
        return eastWall;
    }

    public boolean isSouthWall() {
        return southWall;
    }

    public boolean isWestWall() {
        return westWall;
    }
}
