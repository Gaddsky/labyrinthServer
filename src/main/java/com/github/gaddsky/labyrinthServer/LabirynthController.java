package com.github.gaddsky.labyrinthServer;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LabirynthController {
    private int currentX = 0;
    private int currentY = 0;
    private ILabirinth labyrinth = new FakeLabyrinth("Fake labyrinth");
    private ILabyrinthDB labDB = new FakeLabyrinthDB(labyrinth);


    @RequestMapping("/labyrinth/json")
    public Environment getCellEnviromentJSON(@RequestParam(value = "direction", defaultValue = "") String direction) {
        Environment currentCell = labDB.getCellEnvironment(currentX, currentY);
        switch (direction) {
            case "north":
                if (!currentCell.isNorthWall()) {
                    currentY += 1;
                } else return null;
                break;
            case "east":
                if (!currentCell.isEastWall()) {
                    currentX += 1;
                } else return null;
                break;
            case "south":
                if (!currentCell.isSouthWall()) {
                    currentY -= 1;
                } else return null;
                break;
            case "west":
                if (!currentCell.isWestWall()) {
                    currentX -= 1;
                } else return null;
                break;
            default:
                System.out.println("Unknown direction");
                return null;
        }
        return labDB.getCellEnvironment(currentX, currentY);


    }

}
