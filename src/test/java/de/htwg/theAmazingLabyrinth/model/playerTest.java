package de.htwg.theAmazingLabyrinth.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class playerTest {

    player player1;
    player player2;
    player player3;

    @Before
    public void setUp() throws Exception {
        player1 = new player();
        player2 = new player("Player 2");
        player3 = new player("Player 3");
    }

    @Test
    public void testGetName() {
        assertEquals("Standard", player1.getName());
        assertNotEquals(player2.getName(),player3.getName());
    }

}
