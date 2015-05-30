package de.htwg.theAmazingLabyrinth.model;

public class token {
	String name = ""; /* name of the token (L-Token, I-Token or T-Token */
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

    //Prototyp!
    /* spin a token (from left to right) */
    public int[] spin(int[] ways){
        ways[3] = ways[0];
        for(int i = 0; i <= 2; i++){
            ways[i] = ways[i + 1];
        }
        return ways;
    }

    //Prototyp!
    /*return random ways for a token */
	public int[] randomWays(int token){
		// 	0 == "I-Token" ; 1 == "L-Token" ; 2 == "T-Token"
		int[] ways;
		switch(token){
			case 0:
				ways = createIToken();
                break;
			}
			case 1:{
				ways = createLToken();
                 break;
			}
			case 2: {
                ways = createTToken();
             break;
            }
		}
		return ways;
	}


	private int[] createIToken (){
        int[] ways;
		ways[0] = (int)(Math.random()*2);
		if(ways[0] == 0){
			ways[1] = 1;
			ways[2] = 0;
			ways[3] = 1;
		} else {
			ways[1] = 0;
			ways[2] = 1;
			ways[3] = 0;
		}
        return ways;
	}

	private int[] createLToken (){
        int[] ways;
		ways[0] = (int)(Math.random()*2);
		ways[1] = (int)(Math.random()*2);
		if(ways[0] == 0 && ways[1] == 0){
			ways[2] = 1;
			ways[3] = 1;
		} else if(ways[0] == 0 && ways[1] == 1){
			ways[2] = 1;
			ways[3] = 0;
		} else if(ways[0] == 1 && ways[1] == 0){
			ways[2] = 0;
			ways[3] = 1;
		} else {
			ways[2] = 0;
			ways[3] = 0;
		}
        return ways;
	}

	private int[] createTToken (){
        int[] ways;
        ways[0] = (int)(Math.random()*2);
        if(ways[0] == 0){
            ways[1] = 1;
            ways[2] = 1;
            ways[3] = 1;
        } else {
            ways[1] = (int)(Math.random()*2);
            if(ways[1] == 0){
                ways[2] = 1;
                ways[3] = 1;
            } else {
                ways[2] = (int)(Math.random() *2);
                if(ways[2] == 0){
                    ways[3] = 1;
                } else {
                    ways[3] = 0;
                }
            }
        }
        return ways;
	}

}