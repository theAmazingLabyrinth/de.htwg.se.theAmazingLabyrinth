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
			assertEquals(0, Token.getWay(0));
			assertEquals(0, Token.getWay(1));
			assertEquals(0, Token.getWay(-1));
			assertEquals(0, Token.getWay(5));
		}
	} 
	
	@Test
	public void testGetName() {
		assertEquals("standard token", StandardToken.getName());
		assertEquals("another token", StandardToken.getName());
	}


}
