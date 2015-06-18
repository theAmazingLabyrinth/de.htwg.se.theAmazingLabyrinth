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
        int[] marks = {1,2,3,4,5};
        player1 = new player(marks);
        player2 = new player("Player 2", marks);
        player3 = new player("Player 3", marks);
        //player1.setToken(1);
        //player2.setToken(2);
    }

    @Test
    public void testGetName() {
        assertEquals("Standard", player1.getName());
        assertNotEquals(player2.getName(),player3.getName());
    }

    @Test
    public void testGetMark(){
        int[] a = {1,2,3,4,5};
        assertEquals(a, player1.getMarks());
        assertEquals(a, player2.getMarks());
    }

    @Test
    public void testSetMark(){
        int[] old = {1,2,3,4,5};
        int[] newer = {1,2,0,4,5};
        player1.deleteMark(3);
        assertEquals(newer, player1.getMarks());
        assertEquals(newer, player3.getMarks());
        assertNotEquals(old, player1.getMarks());
    }
/*
    @Test
    public void testGetToken() {
        assertEquals(1, player1.getToken().getEnd());
        assertEquals(2, player1.getToken().getEnd());

    }
*/
}
