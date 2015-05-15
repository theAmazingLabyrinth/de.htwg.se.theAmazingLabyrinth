package de.htwg.theAmazingLabyrinth.model;

public class token {
	String name = ""; /* name of the token (L-Token, I-Token, T-Token or X-Token(4way))*/
	int[] ways = new int[4]; /* {North, East, South, West} */
	int end; /* specified if this token is a siegetoken and which it is */

	public token() {
		this("standard token", new int[]{1,1,1,1}, 0);
	}

	public token(String name, int[] ways, int end) {
		this.name = name;
		this.ways = ways;
		this.end = end;
	}

	/* returns 1 if way is an way or 0 if way is a wall */

	public int getWay(int way) {
		if(way < 4 && way >= 0) 
			return ways[way];
		else
			return -1;
	}

	/* returns the name of the token */

	public String getName() {
		return name;
	}
	
	public int getEnd() {
		return end;
	}
}
