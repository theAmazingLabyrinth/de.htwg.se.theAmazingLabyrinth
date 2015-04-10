package de.htwg.se.theAmazingLabyrinth.model;

public class player {
	String name = "";

	public player() {
		name = "Standard"
	}

	public player(String s) {
		name = s;
	}

	public String getName() {
		return name;
	}

}
