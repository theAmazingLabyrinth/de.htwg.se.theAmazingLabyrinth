package de.htwg.theAmazingLabyrinth.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TokenTest {

    token Token;
    token StandardToken;

    @Before
    public void setUp() throws Exception {
        Token = new token("TestToken", new int[]{1,0,1,0}, 0);
        StandardToken = new token();
    }

    @Test
    public void testGetWay() {
        for(int i = 0; i < 3; i ++) {
            assertEquals(1, Token.getWay(0));
            assertEquals(0, Token.getWay(1));
            assertEquals(-1, Token.getWay(-1));
            assertEquals(-1, Token.getWay(5));
        }
    }

    @Test
    public void testSpin(){
        int[] token = {1,0,1,0};
        int[] test = {0,1,0,1};
        assertEquals(test, Token.spin(token));
    }

    @Test
    public testRandomWays(){
        token Token2 = new token("TestToken2", 0);
        int test;
        for(int i = 0; i < 4; i++){
            test = Token2.getWay(i);
            assertTrue(test == 0 || test == 1);
        }
    }

    @Test
    public void testGetName() {
        assertEquals("standard token", StandardToken.getName());
    }

    @Test
    public void testGetEnd() {
        assertEquals(0, Token.getEnd());
    }


}