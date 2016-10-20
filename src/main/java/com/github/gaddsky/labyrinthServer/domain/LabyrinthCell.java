package com.github.gaddsky.labyrinthServer.domain;


/**
 * This domain represents cell in maze
 * x, y - coordinates of cell in maze
 * cellState - state of maze's cell. It os four bits, which show directions with wall. Most significant bit is north,
 * next - east, next - south, least significant bit is west.
 */
public class LabyrinthCell {
    private int x;
    private int y;
    private byte cellState;

    public LabyrinthCell(int x, int y, byte cellState) {
        this.x = x;
        this.y = y;
        this.cellState = cellState;
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

    public byte getCellState() {
        return cellState;
    }

    public void setCellState(byte cellState) {
        this.cellState = cellState;
    }
}
