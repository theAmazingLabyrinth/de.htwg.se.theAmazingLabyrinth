package de.htwg.theAmazingLabyrinth.model;

import de.htwg.theAmazingLabyrinth.controller.controller;
import org.junit.Before;
import org.junit.Test;

public class ControllerTest {

    controller Controller;

    @Before
    public void setUp() throws Exception {
        Controller = new controller(4, 7);
    }

}
