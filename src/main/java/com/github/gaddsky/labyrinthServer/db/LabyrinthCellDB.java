package com.github.gaddsky.labyrinthServer.db;


import com.github.gaddsky.labyrinthServer.domain.LabyrinthCell;

import java.util.HashSet;

public class LabyrinthCellDB implements ILabyrithCellDB {

    private HashSet<LabyrinthCell> fakeDB = new HashSet<>();

    @Override
    public boolean create(LabyrinthCell labCell) {
        return fakeDB.add(labCell);
    }

    @Override
    public LabyrinthCell get(int x, int y) throws IllegalArgumentException {
        for (LabyrinthCell labCell : fakeDB) {
            if (labCell.getX() == x && labCell.getY() == y) {
                return labCell;
            }
        }
        throw new IllegalArgumentException("Wrong cell coordinates");
    }

    @Override
    public void update(LabyrinthCell labCell) throws IllegalArgumentException {
        for (LabyrinthCell cell : fakeDB) {
            if (cell.getX() == labCell.getX() && cell.getY() == labCell.getY()) {
                fakeDB.remove(cell);
                fakeDB.add(labCell);
                return;
            }
        }
        throw new IllegalArgumentException("Wrong cell coordinates");
    }

    @Override
    public void delete(int x, int y) {
        for (LabyrinthCell labCell : fakeDB) {
            if (labCell.getX() == x && labCell.getY() == y) {
                fakeDB.remove(labCell);
                return;
            }
        }
        throw new IllegalArgumentException("Wrong cell coordinates");
    }
}
