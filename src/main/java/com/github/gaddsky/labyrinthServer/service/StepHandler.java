package com.github.gaddsky.labyrinthServer.service;


import com.github.gaddsky.labyrinthServer.db.LabyrinthDB;
import com.github.gaddsky.labyrinthServer.domain.Labyrinth;
import com.github.gaddsky.labyrinthServer.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.HashMap;
import java.util.Map;

public class StepHandler {
    @Autowired
    private User user;
//    private LabyrinthDB labDB = new LabyrinthDB();
    @Autowired
    private LabyrinthDB labDB;

    private Map<String, int[]> movement = new HashMap<>();

    public StepHandler(ApplicationContext context) {
//        Labyrinth lab = (Labyrinth) context.getBean("fakeLabyrinth");
//        this.user = (User) context.getBean("fakeUser");
//        this.labDB.create(lab);
//        this.user = user;

        movement.put("north", new int[]{0, 1});
        movement.put("east", new int[]{1, 0});
        movement.put("south", new int[]{0, -1});
        movement.put("west", new int[]{-1, 0});
    }

    public Environment getNextStep(String direction) {
        Environment currentCell = new Environment(labDB.getCell(user.getX(), user.getY()).getCellState());
        int[] delta = movement.get(direction);
        if (delta != null) {
            int deltaX = delta[0];
            int deltaY = delta[1];
            if (!currentCell.isWall(direction)) {
                user.setX(user.getX() + deltaX);
                user.setY(user.getY() + deltaY);
                return new Environment(labDB.getCell(user.getX(), user.getY()).getCellState());
            } else return null;
        } else return null;
    }
}
