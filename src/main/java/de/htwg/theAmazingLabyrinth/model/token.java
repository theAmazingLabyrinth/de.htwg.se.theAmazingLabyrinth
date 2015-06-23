package de.htwg.theAmazingLabyrinth.model;

public class token {
	private String name = ""; /* name of the token (L-Token, I-Token or T-Token */
	private int[] ways = new int[4]; /* {North, East, South, West} */
	private int end; /* specified if this token is a siegetoken and which it is */

	public token() {
		this("standard token", new int[]{1, 1, 1, 1}, 0);
	}

	public token(String name, int[] ways, int end) {
		this.name = name;
		this.ways = ways;
		this.end = end;
	}

    /*The Constructor for the randomToken. */
    public token(String name, int token, int end){
        this.name = name;
        this.ways = createRandomToken(token);
		this.end = end;
    }

	/* returns 1 if way is an way or 0 if way is a wall */
	public int getWay(int way) {
		if (way < 4 && way >= 0)
			return ways[way];
		else {
			return -1;
		}
	}

	/* returns the name of the token */
	public String getName() {
		return name;
	}

	public int getEnd() {
		return end;
	}

    /* spin a token (from left to right) */
	public int[] spin(int[] ways) {
		int tmp = ways[0];
		for (int i = 0; i <= 2; i++) {
			ways[i] = ways[i + 1];
		}
		ways[3] = tmp;
		this.ways = ways;
		return this.ways;
	}

    /*creates a random Token */
    private int[] createRandomToken(int token){
        randomWays rways = new randomWays(token);
		return rways.getWays();
    }

}