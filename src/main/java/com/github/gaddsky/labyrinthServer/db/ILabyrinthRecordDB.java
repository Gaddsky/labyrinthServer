package com.github.gaddsky.labyrinthServer.db;


import com.github.gaddsky.labyrinthServer.domain.LabyrinthRecord;

public interface ILabyrinthRecordDB {
    int create(LabyrinthRecord labRec);

    LabyrinthRecord get(int id);

    LabyrinthRecord get(String name);

    void delete(int id);
}
// update method not needed
