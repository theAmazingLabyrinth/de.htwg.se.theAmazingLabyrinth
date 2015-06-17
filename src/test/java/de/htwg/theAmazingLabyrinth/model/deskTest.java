package de.htwg.theAmazingLabyrinth.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class deskTest {


	desk Desk;

	@Before
	public void setUp() throws Exception {
		Desk = new desk(7);
	}
	


	@Test
	public void newMapTest() {
		assertEquals(true, Desk.newMap());
	}

}
