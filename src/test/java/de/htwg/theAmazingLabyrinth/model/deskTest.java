package de.htwg.theAmazingLabyrinth.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class deskTest {

    desk deskOne;

    @Before
    public void setUp() throws Exception {
        deskOne = new desk();
    }

    @Test
    public void testCreateFixTokens() {
            assertEquals(true, deskOne.createFixTokens());
    }

}
