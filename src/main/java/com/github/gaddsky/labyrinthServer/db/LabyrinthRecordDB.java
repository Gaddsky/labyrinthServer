package com.github.gaddsky.labyrinthServer.db;

import com.github.gaddsky.labyrinthServer.domain.LabyrinthRecord;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class LabyrinthRecordDB implements ILabyrinthRecordDB {

    private Map<Integer, LabyrinthRecord> fakeDB = new HashMap<Integer, LabyrinthRecord>();

    @Override
    public int create(LabyrinthRecord labRec) {
        Random rand = new Random();
        labRec.setId(rand.nextInt());
        fakeDB.put(labRec.getId(), labRec);
        return labRec.getId();
    }

    @Override
    public LabyrinthRecord get(int id) {
        return fakeDB.get(id);
    }

    @Override
    public LabyrinthRecord get(String name) throws IllegalArgumentException {
        for (LabyrinthRecord labRec : fakeDB.values()) {
            if (labRec.getName().equals(name)) {
                return labRec;
            }
        }
        throw new IllegalArgumentException("Wrong labyrinth's name");
    }

    @Override
    public void delete(int id) {
        fakeDB.remove(id);

    }
}
