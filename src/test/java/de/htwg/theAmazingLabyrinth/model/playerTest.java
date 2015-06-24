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
        player2 = new player("Player 2", 0);
        player3 = new player("Player 3", 0);
    }

    @Test
    public void testGetName() {
        assertEquals("Standard", player1.getName());
        assertNotEquals(player2.getName(),player3.getName());
    }

    @Test
    public void testGetMark(){
        int[] a = {1,2,3,4,5};
        int[] b = player1.getMarks();
        for(int i = 0; i<=4; i++){
            assertEquals(a[i], b[i]);
        }
    }

    @Test
    public void testSetMark(){
        int[] newer = {1,2,0,4,5};
        int[] erg = player1.getMarks();
        player1.deleteMark(3);
        for (int i = 0; i<= 4; i++){
            assertEquals(erg[i], newer[i]);
        }
    }
/*
    @Test
    public void testGetToken() {
        assertEquals(1, player1.getToken().getEnd());
        assertEquals(2, player1.getToken().getEnd());

    }
*/
}
