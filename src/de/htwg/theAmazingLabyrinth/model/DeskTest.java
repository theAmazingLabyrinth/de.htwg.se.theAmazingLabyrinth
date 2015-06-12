package de.htwg.theAmazingLabyrinth.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DeskTest {


	desk Desk;

	@Before
	public void setUp() throws Exception {
		Desk = new desk();
	}
	
	/*
	@Test
	public void newMapTest() {
		assertEquals(true, Desk.newMap());
	}*/

	@Test
	public void getMapTest(){
		assertEquals(token[7][7], Desk.getMap());
	}

}
