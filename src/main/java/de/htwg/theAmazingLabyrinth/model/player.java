package de.htwg.theAmazingLabyrinth.model;

public class player {
	private String name = "";
    private int marks[] = new int[Integer.MAX_VALUE];
    private int position = 0;

    //private token siegeToken; //Test


	public player(int[] marks) {
		name = "Standard";
        this.marks = marks;
	}

	public player(String s, int position) {
        name = s;
        this.position = position;
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

    public int getPosition(){
        return position;
    }
    public void setPosition(int pos){position = pos;}
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
