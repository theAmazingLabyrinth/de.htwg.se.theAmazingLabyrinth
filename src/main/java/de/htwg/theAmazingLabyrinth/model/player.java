package de.htwg.theAmazingLabyrinth.model;

public class player {
	String name = "";
    token siegeToken;


	public player() {
        name = "Standard";
	}

	public player(String s) {
		name = s;
	}

	public String getName() {
		return name;
	}

    public token setToken(int siegeMark) {
        return new token("Siegetoken", new int[]{0,0,0,0}, siegeMark);
    }

    public token getToken() {
        return siegeToken;
    }




}
