package de.htwg.theAmazingLabyrinth.model;

public class token {
	private String name = ""; /* name of the token (L-Token, I-Token or T-Token */
	private int[] ways = new int[4]; /* {North, East, South, West} */
	private int end; /* specified if this token is a siegetoken and which it is */
	private boolean moveable; /*if token is moveable or not */

	public token() {this("standard token", new int[]{1, 1, 1, 1}, 0, false);}

	public token(String name, int[] ways, int end, boolean moveable) {
		this.name = name;
		this.ways = ways;
		this.end = end;
		this.moveable = moveable;
	}

    /*The Constructor for the randomToken. */
    public token(String name, int token, int end, boolean moveable){
        this.name = name;
        this.ways = createRandomToken(token);
        this.end = end;
		this.moveable = moveable;
    }

	/* returns 1 if way is an way or 0 if way is a wall */
	public int getWay(int side) {
		if (side < 4 && side >= 0)
			return ways[side];
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

    /* spin a token (from left to right) */
	public int[] spin(int[] ways) {
		ways[3] = ways[0];
		for (int i = 0; i <= 2; i++) {
			ways[i] = ways[i + 1];
		}
		return ways;
	}

    /*creates a random Token */
    private int[] createRandomToken(int token){
        randomWays rways = new randomWays(token);
		return rways.getWays();
    }

	public boolean getMoveable(){
		return moveable;
	}

}