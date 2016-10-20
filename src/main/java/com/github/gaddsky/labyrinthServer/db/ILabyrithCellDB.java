package com.github.gaddsky.labyrinthServer.db;


import com.github.gaddsky.labyrinthServer.domain.LabyrinthCell;

public interface ILabyrithCellDB {
    boolean create(LabyrinthCell labCell);

    LabyrinthCell get(int x, int y);

    void update(LabyrinthCell labCell);

    void delete(int x, int y);
}
