package com.github.gaddsky.labyrinthServer.service;


import com.github.gaddsky.labyrinthServer.db.LabyrinthDB;
import com.github.gaddsky.labyrinthServer.domain.Labyrinth;
import com.github.gaddsky.labyrinthServer.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StepHandler {
    private User user;
    private LabyrinthDB labDB = new LabyrinthDB();

    public StepHandler() {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        Labyrinth lab = (Labyrinth) context.getBean("fakeLabyrinth");
        User user = (User) context.getBean("fakeUser");
        this.labDB.create(lab);
        this.user = user;
    }

    public Environment getNextStep(String direction) {

        Environment currentCell = new Environment(labDB.getCell(user.getX(), user.getY()).getCellState());
        switch (direction) {
            case "north":
                if (!currentCell.isNorthWall()) {
                    user.setY(user.getY() + 1);
                } else return null;
                break;
            case "east":
                if (!currentCell.isEastWall()) {
                    user.setX(user.getX() + 1);
                } else return null;
                break;
            case "south":
                if (!currentCell.isSouthWall()) {
                    user.setY(user.getY() - 1);
                } else return null;
                break;
            case "west":
                if (!currentCell.isWestWall()) {
                    user.setX(user.getX() - 1);
                } else return null;
                break;
            default:
                System.out.println("Unknown direction");
                return null;
        }
        return new Environment(labDB.getCell(user.getX(), user.getY()).getCellState());
    }

}
