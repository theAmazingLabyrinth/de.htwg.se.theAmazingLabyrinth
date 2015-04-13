package de.htwg.theAmazingLabyrinth.model;

public class desk {

	token map[][];
	
	/* makes a new standardmap and add the not moveable tokens */
	public desk() {
		map = new token[7][7];
		map[0][0] = new token("L-Token", new int[]{0,1,1,0}, 0);
		map[0][6] = new token("L-Token", new int[]{0,0,1,1}, 0);
		map[0][2] = new token("T-Token", new int[]{0,1,1,1}, 0);
		map[0][4] = new token("T-Token", new int[]{0,1,1,1}, 0);
		map[2][0] = new token("T-Token", new int[]{1,1,1,0}, 0);
		map[2][6] = new token("T-Token", new int[]{1,0,1,1}, 0);
		map[2][2] = new token("T-Token", new int[]{0,1,1,1}, 0);
		map[2][4] = new token("T-Token", new int[]{1,0,1,1}, 0);
		map[4][0] = new token("T-Token", new int[]{1,1,1,0}, 0);
		map[4][2] = new token("T-Token", new int[]{1,1,1,0}, 0);
		map[4][4] = new token("T-Token", new int[]{1,1,0,1}, 0);
		map[4][6] = new token("T-Token", new int[]{1,0,1,1}, 0);
		map[6][0] = new token("L-Token", new int[]{1,1,0,0}, 0);
		map[6][2] = new token("T-Token", new int[]{1,1,0,1}, 0);
		map[6][4] = new token("T-Token", new int[]{1,1,0,1}, 0);
		map[6][6] = new token("L-Token", new int[]{1,0,0,1}, 0);
		newMap();
	}
	
	/* newMap creates the moveable tokens on the map */
	public boolean newMap() {
		
		return false;
	}
	
}
