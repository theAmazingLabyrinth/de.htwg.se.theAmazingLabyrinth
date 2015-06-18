package de.htwg.theAmazingLabyrinth.model;

public class desk {

    private token[] standardDesk;
    private int deskLength;
    private int deskSide;
    private int mark[] = new int[24]; /* the array to count the special tokens, 1-4 = start places*/
    private int markNr = 0; /*reader of the mark-array*/
    private int MAXITOKEN;       //max. I - Tokens
    private int MAXLTOKEN;       //max. L - Tokens
    private int MAXTTOKEN;        //max. T - Token

    /*Initialising*/
    public desk(int deskLength){
        deskSide = deskLength;
        this.deskLength = deskLength * deskLength;
        standardDesk = new token[this.deskLength];
        createFixTokens();
        createMoveableTokens();
        for(int i = 1; i <= 24; i++){
            mark[i] = i;
        }
        MAXITOKEN = 12;
        MAXLTOKEN = 14;
        MAXTTOKEN = 6;
    }

    /*create all moveable Tokens on the Table by Initialising*/
    private boolean createMoveableTokens(){
        int randomInt;                  //random numbers to create random tokens
        String names[]= new String[32]; //Array for the 32 moveable Tokens
        boolean b_all = false;          //counter if all tokens are created
        int itoken = 0;                 //token counter
        int ltoken = 0;
        int ttoken = 0;

        for(int i = 0; !b_all;i++){
            randomInt = (int) (Math.random() * 2);
            if (randomInt == 0 && randomInt <= MAXITOKEN){names[i] = "I-Token";itoken++;}
            if (randomInt == 1 && randomInt <= MAXLTOKEN){names[i] = "L-Token";ltoken++;}
            if (randomInt == 2 && randomInt <= MAXTTOKEN){names[i] = "T-Token";ttoken++;}
            if(itoken == MAXITOKEN && ltoken == MAXLTOKEN && ttoken == MAXTTOKEN){b_all = true;}
        }

        return createMTokens(names);
    }

    /* second class to create moveable tokens */
    private boolean createMTokens(String[] names) {

        int nameCounter = 0;
        int i = 0;
        int roundCounter = 1;
        boolean round = true;
        while (i <= deskLength) {
            if(i == 0){
                if((roundCounter % 2 == 0) && (roundCounter % deskSide == 0)) {
                    i++;
                }
            }
            if (roundCounter % deskSide == 0) {
                if (round) {round = false;}
                else {round = true;}
            }
            standardDesk[i] = new token(names[nameCounter], getInt(names[nameCounter]), getMarkNr(names[nameCounter]), true);
            nameCounter++;
            roundCounter++;
            if (round){i += 2;}
            else {i++;}
        }

        return true;
    }

    /* get as Int if the token is a "I-", "L-" or a "T- Token"*/
    private int getInt(String s){
        if(s.equals("I-Token")){return 0;}
        else if(s.endsWith("L-Token")){return 1;}
        else {return 2;}
    }

    /* get the mark of the token */
    private int getMarkNr(String s) {
        if (s.equals("T-Token")){
            int nr = mark[markNr];
            markNr++;
            return nr;
        }
        else{return 0;}
    }


    /* creates all fix Tokens on the Table by Initialising */
    private boolean createFixTokens(){
        standardDesk[0] = new token("L-Token",new int[]{0,1,1,0},1, false);
        standardDesk[2] = new token("T-Token",new int[]{0,1,1,1},5, false);
        standardDesk[4] = new token("T-Token",new int[]{0,1,1,1},6, false);
        standardDesk[6] = new token("L-Token",new int[]{0,0,1,1},2, false);
        standardDesk[14] = new token("T-Token",new int[]{1,1,1,0},7, false);
        standardDesk[16] = new token("T-Token",new int[]{0,1,1,1},8, false);
        standardDesk[18] = new token("T-Token",new int[]{1,0,1,1},9, false);
        standardDesk[20] = new token("T-Token",new int[]{1,0,1,1},10, false);
        standardDesk[28] = new token("T-Token",new int[]{1,1,1,0},11, false);
        standardDesk[30] = new token("T-Token",new int[]{1,1,1,0},12, false);
        standardDesk[32] = new token("T-Token",new int[]{1,1,0,1},13, false);
        standardDesk[34] = new token("T-Token",new int[]{1,0,1,1},14, false);
        standardDesk[42] = new token("L-Token",new int[]{1,1,0,0},3, false);
        standardDesk[44] = new token("T-Token",new int[]{1,1,0,1},15, false);
        standardDesk[46] = new token("T-Token",new int[]{1,1,0,1},16,false);
        standardDesk[48] = new token("L-Token",new int[]{1,0,0,1},4, false);
        return true;
    }

    /*return the desk*/
    public token[] getStandardDesk(){
        return standardDesk;
    }

    public boolean newMap(){
        return true;
    }
}