package com.github.gaddsky.labyrinthServer.db;


import com.github.gaddsky.labyrinthServer.domain.Labyrinth;
import com.github.gaddsky.labyrinthServer.domain.LabyrinthCell;

public interface ILabyrinthDB {
    int create(Labyrinth labyrinth);

    Labyrinth get(int id);

    void update(Labyrinth labyrinth);

    void delete(int id);

    LabyrinthCell getCell(int x, int y);
}
