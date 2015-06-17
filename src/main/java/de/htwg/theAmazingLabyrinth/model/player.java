package de.htwg.theAmazingLabyrinth.model;

public class player {
	private String name = "";
    private int marks[] = new int[200];

    //private token siegeToken; //Test


	public player(int[] marks) {
		name = "Standard";
        this.marks = marks;
	}

	public player(String s, int[] marks) {
        name = s;
        this.marks = marks;
	}

	public String getName() {
        return name;
	}

    public int[] getMarks(){
        return marks;
    }

    public void setMarks(int[] marks){
        this.marks = marks;
    }

    /*
    public token setToken(int siegeMark) {
        return new token("Siegetoken", new int[]{0,0,0,0}, siegeMark);
    }

    public token getToken() {
        return siegeToken;
    }
    */



}
