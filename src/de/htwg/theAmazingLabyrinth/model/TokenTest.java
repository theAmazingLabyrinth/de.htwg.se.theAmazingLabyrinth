package de.htwg.theAmazingLabyrinth.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TokenTest {

	token Token;

	@Before
	public void setUp() throws Exception {
		Token = new token("TestToken", new int[]{1,0,1,0}, 0);
	}

	@Test
	public void testGetWay() {
	assertEquals(0,Token.getWay(0));
	assertEquals(0,Token.getWay(1));
	} 


}
