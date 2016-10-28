package com.github.gaddsky.labyrinthServer;

import com.github.gaddsky.labyrinthServer.service.Environment;
import com.github.gaddsky.labyrinthServer.service.StepHandler;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LabyrinthController {
    private ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
    private StepHandler stepHandler = new StepHandler(context);

    @RequestMapping("/labyrinth/json")
    public Environment getCellEnviromentJSON(@RequestParam(value = "direction", defaultValue = "") String direction) {
        return stepHandler.getNextStep(direction);
    }
}
