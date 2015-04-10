package de.htwg.se.theAmazingLabyrinth.model;

public class token {
	String name = "";
	int[] ways = new int[4]; /* {North, East, South, West} */

	public token() {
		name = "standard token";
		ways = {1,1,1,1};
	}
	public token(String s, int[4] ways) {
		name = s;
		this.ways = ways;
	}
}
