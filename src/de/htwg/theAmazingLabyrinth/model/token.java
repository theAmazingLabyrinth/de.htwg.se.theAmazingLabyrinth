package de.htwg.se.theAmazingLabyrinth.model;

public class token {
	String name = "";
	int[] ways = new int[4]; /* {North, East, South, West} */
	int end;

	public token() {
		token("standard token", {1,1,1,1}, 0);
	}
	public token(String name, int[4] ways, int end) {
		this.name = name;
		this.ways = ways;
		this.end = end;
	}

	public int getWay(int way) {
		if(way < 4 && way >= 0) 
			return ways[way];
		else
			return -1;
	}
}
