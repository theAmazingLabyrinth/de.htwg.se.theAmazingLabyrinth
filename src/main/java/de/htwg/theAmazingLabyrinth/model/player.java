package de.htwg.theAmazingLabyrinth.model;

public class player {
	private String name = "";
    private int marks[] = new int[Integer.MAX_VALUE];

    //private token siegeToken; //Test


	public player(int[] marks) {
		name = "Standard";
        this.marks = marks;
	}

	public player(String s, int[] marks) {
        name = s;
        this.marks = marks;
	}

    /* return Name */
	public String getName() {
        return name;
	}

    /* return marks[] */
    public int[] getMarks(){
        return marks;
    }

    /* set a deleted Mark to zero */
    public void deleteMark(int mark) {
        for (int i = 0; i < marks.length; i++) {
            if (marks[i] == mark) {
                marks[i] = 0;
            }
        }
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
