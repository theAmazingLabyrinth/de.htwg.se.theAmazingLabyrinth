package de.htwg.se.theAmazingLabyrinth.model;

public class token {
	String name = "";
	int[] ways = new int[4]; /* {North, East, South, West} */
	int end;

	public token() {
		name = "standard token";
		ways = {1,1,1,1};
		end = 0;
	}
	public token(String name, int[4] ways, int end) {
		this.name = name;
		this.ways = ways;
		this.end = end;
	}
}
