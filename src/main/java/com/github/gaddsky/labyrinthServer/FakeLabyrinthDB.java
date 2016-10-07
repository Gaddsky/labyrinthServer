package com.github.gaddsky.labyrinthServer;


import java.util.HashMap;
import java.util.Map;

public class FakeLabyrinthDB implements ILabyrinthDB {
    private ILabirinth labyrinth;
    private Map<Integer, HashMap<Integer, Byte>> db;

    FakeLabyrinthDB(ILabirinth labyrinth) {
        this.labyrinth = labyrinth;
        int labWidth = labyrinth.getWidth();
        int labHeight = labyrinth.getHeight();
        db = new HashMap<>();
        byte[][] labData = labyrinth.getLabyrinth();
        for (int y = 0; y < labWidth; y++) {
            HashMap<Integer, Byte> lineX = new HashMap<>();
            for (int x = 0; x < labHeight; x++) {
                lineX.put(x, labData[y][x]);
            }
            db.put(y, lineX);
        }
    }

    @Override
    public Environment getCellEnvironment(int x, int y) {
        return new Environment(db.get(y).get(x));
    }

    @Override
    public void deleteLabyrinth(int id) {
        db.clear();
    }
}
