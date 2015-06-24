package de.htwg.theAmazingLabyrinth.model;

import de.htwg.theAmazingLabyrinth.controller.controller;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ControllerTest {

    controller Controller;
    int[] a = {1,0,1,0};
    token Token = new token("test", a, 0);
    player Player = new player("Player 1", 0);


    @Before
    public void setUp() throws Exception {
        Controller = new controller(4, 7, Token);
    }

    @Test
    public void testMoveTokens(){
        assertEquals(true, Controller.moveToken(1));
    }

    @Test
    public void testMovePlayer(){assertEquals(true, Controller.movePlayer(Player, "W"));}

}
