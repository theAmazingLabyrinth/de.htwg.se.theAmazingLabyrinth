package de.htwg.theAmazingLabyrinth.model;

import java.util.LinkedList;
import java.util.List;

public class desk {

    private token[] standardDesk;
    private int deskLength;
    private int deskSide;
    private int markNr = 0;         /*reader of the mark-array*/
    private int MAXITOKEN;          //max. I - Tokens
    private int MAXTTOKEN;          //max. T - Token

    /*Initialising*/
    public desk(int deskLength){
        deskSide = deskLength;
        this.deskLength = deskLength * deskLength;
        standardDesk = new token[this.deskLength];
        MAXITOKEN = 12;
        MAXTTOKEN = 6;
        createFixTokens();
        createMoveableTokens();
    }

    /*create all moveable Tokens on the Table by Initialising*/
    private boolean createMoveableTokens(){
        List<String> names =  new LinkedList<String>(); //Array for the 33 moveable Tokens
        int itoken = 0;                 //token counter
        int ttoken = 0;

        for(int i = 0; i<33; i++){names.add("a");}

        names = createDifferentTokens(ttoken, MAXTTOKEN, names, "T - Token");
        names = createDifferentTokens(itoken, MAXITOKEN, names, "I - Token");
        for(int i = 0; i < names.size(); i++){
            if(names.get(i) == "a") {
                names.remove(i);
                names.add(i, "L - Token");
            }
        }
        return createMTokens(names);
    }

    /*create the different tokens */
    private List<String> createDifferentTokens(int token, int max, List<String> list, String s){
        while(token < max){
            int randomInt = (int)(Math.random() * 32);
            if(list.get(randomInt) == "a") {
                list.remove(randomInt);
                list.add(randomInt, s);
                token++;
            }
        }
        return list;
    }

    /* second class to create moveable tokens */
    private boolean createMTokens(List<String> names) {
        int mark[] = new int[10];           // the array to count the special tokens
        for(int i = 0; i < 10; i++){
            mark[i] = i+17;
        }
        int nameCounter = 0;
        int i = 0;
        boolean round = true;


        while (i < deskLength) {
            if(i == 0){
                i++;
            }
            if (i % deskSide == 0) {
                if (round) {round = false;}
                else {round = true;}
                if(i %2 == 0){
                    i++;
                }
            }
            standardDesk[i] = new token(names.get(nameCounter), getInt(names.get(nameCounter)), getMarkNr(names.get(nameCounter), mark));
            nameCounter++;
            if (round){i += 2;}
            else {i++;}
        }

        return true;
    }

    /* get as Int if the token is a "I-", "L-" or a "T- Token"*/
    private int getInt(String s){
        if(s.equals("I - Token")){return 0;}
        else if(s.equals("L - Token")){return 1;}
        else {return 2;}
    }

    /* get the mark of the token */
    private int getMarkNr(String s, int[] mark) {
        if (s.equals("T - Token")){
            int nr = mark[markNr];
            markNr++;
            return nr;
        }
        else{return 0;}
    }


    /* creates all fix Tokens on the Table by Initialising */
    private boolean createFixTokens(){
        standardDesk[0] = new token("L-Token",new int[]{0,1,1,0},1);
        standardDesk[2] = new token("T-Token",new int[]{0,1,1,1},5);
        standardDesk[4] = new token("T-Token",new int[]{0,1,1,1},6);
        standardDesk[6] = new token("L-Token",new int[]{0,0,1,1},2);
        standardDesk[14] = new token("T-Token",new int[]{1,1,1,0},7);
        standardDesk[16] = new token("T-Token",new int[]{0,1,1,1},8);
        standardDesk[18] =  new token("T-Token",new int[]{1,0,1,1},9);
        standardDesk[20] =  new token("T-Token",new int[]{1,0,1,1},10);
        standardDesk[28] =  new token("T-Token",new int[]{1,1,1,0},11);
        standardDesk[30] = new token("T-Token",new int[]{1,1,1,0},12);
        standardDesk[32] = new token("T-Token",new int[]{1,1,0,1},13);
        standardDesk[34] = new token("T-Token",new int[]{1,0,1,1},14);
        standardDesk[42] = new token("L-Token",new int[]{1,1,0,0},3);
        standardDesk[44] = new token("T-Token",new int[]{1,1,0,1},15);
        standardDesk[46] = new token("T-Token",new int[]{1,1,0,1},16);
        standardDesk[48] = new token("L-Token",new int[]{1,0,0,1},4);
        return true;
    }

    /*return the desk*/
    public token getStandardDesk(int t){
        return standardDesk[t];
    }

    public boolean newMap(){return true;}
}