package com.github.gaddsky.labyrinthServer;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LabirynthController {
    private int currentX = 0;
    private int currentY = 0;
    private ILabirinth labyrinth = new FakeLabyrinth();


    @RequestMapping("/labyrinth/json")
    public Environment getCellEnviromentJSON(@RequestParam(value="direction", defaultValue="") String direction) {
        switch (direction) {
            case "north":
                if (labyrinth.canMoveInDirection(currentX, currentY, direction)) {
                    currentY += 1;
                    return new Environment(labyrinth.getCellState(currentX, currentY));
                }
                break;
            case "east":
                if (labyrinth.canMoveInDirection(currentX, currentY, direction)) {
                    currentX += 1;
                    return new Environment(labyrinth.getCellState(currentX, currentY));
                }
                break;
            case "south":
                if (labyrinth.canMoveInDirection(currentX, currentY, direction)) {
                    currentY -= 1;
                    return new Environment(labyrinth.getCellState(currentX, currentY));
                }
                break;
            case "west":
                if (labyrinth.canMoveInDirection(currentX, currentY, direction)) {
                    currentX -= 1;
                    return new Environment(labyrinth.getCellState(currentX, currentY));
                }
                break;
        }
        System.out.println("Unknown direction");

        return null;
    }

}
