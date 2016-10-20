package com.github.gaddsky.labyrinthServer.db;


import com.github.gaddsky.labyrinthServer.domain.Labyrinth;
import com.github.gaddsky.labyrinthServer.domain.LabyrinthCell;
import com.github.gaddsky.labyrinthServer.domain.LabyrinthRecord;

import java.util.HashMap;
import java.util.Map;


public class LabyrinthDB implements ILabyrinthDB {
    private Map<Integer, Labyrinth> fakeDB = new HashMap<>();
    private LabyrinthRecordDB labRecDB = new LabyrinthRecordDB();
    private LabyrinthCellDB labCellDB = new LabyrinthCellDB();

    @Override
    public int create(Labyrinth labyrinth) {
        LabyrinthRecord labRec = new LabyrinthRecord();
        labRec.setName(labyrinth.getName());
        labRec.setWidth(labyrinth.getWidth());
        labRec.setHeight(labyrinth.getHeight());
        labyrinth.setId(labRecDB.create(labRec));
        fakeDB.put(labyrinth.getId(), labyrinth);
        byte[][] map = labyrinth.getMap();
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[y].length; x++) {
                LabyrinthCell cell = new LabyrinthCell(x, y, map[y][x]);
                labCellDB.create(cell);
            }
        }
        return labyrinth.getId();
    }

    @Override
    public Labyrinth get(int id) {
        return fakeDB.get(id);
    }

    @Override
    public void update(Labyrinth labyrinth) {
        int labId = labRecDB.get(labyrinth.getName()).getId();
        fakeDB.replace(labId, labyrinth);
    }

    @Override
    public void delete(int id) {
        fakeDB.remove(id);
    }

    @Override
    public LabyrinthCell getCell(int x, int y) {
        return labCellDB.get(x, y);
    }
}
