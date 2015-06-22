package de.htwg.theAmazingLabyrinth.model;

public class player {
	private String name = "";
    private int marks[] = new int[5];

    //private token siegeToken; //Test

    /*Standard Player */
	public player(int[] marks) {
		name = "Standard";
        this.marks = marks;
	}

    /*Player with a name */
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

    /* set the given Mark to zero and "delete" it*/
    public void deleteMark(int mark) {
        System.out.println("deleteMark aufgerufen");
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
