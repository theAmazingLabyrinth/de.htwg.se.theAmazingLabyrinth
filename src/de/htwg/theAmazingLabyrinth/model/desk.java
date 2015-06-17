package de.htwg.theAmazingLabyrinth.model;

import java.lang.System;
import java.util.HashMap;

public class desk {

    private token[] standardDesk;
    private int desklength;
    private int mark[] = new mark[24]; /* the array to count the special tokens, 1-4 = startplaces*/
    private int marknr = 0; /*reader of the mark-array*/

    /*Initialising*/
    public desk(int deskLength){
        this.deskLength = deskLength * deskLength
        standardDesk = new token[this.deskLength];
        createFixTokens();
        createMoveableTokens();
        while(int i = 1; i <= 24; i++){
            mark[i] = i;
        }
    }

    /*create all moveable Tokens on the Table by Initialising*/
    private boolean createMoveableTokens(){
        final int MAXITOKEN = 12;       //max. I - Tokens
        final int MAXLTOKEN = 14;       //max. L - Tokens
        final int MAXTTOKEN = 6;        //max. T - Token
        int randomInt;                  //random numbers to create random tokens
        String names[]= new String[32]; //Array for the 32 moveable Tokens
        boolean b_all;                  //counter if all tokens are created
        int itoken; ltoken, ttoken;     //tokencounter

        for(int i = 0;b_all == false;i++){
            a = (int) (Math.random() * 2);
            if (a = 0 && a <= MAXITOKEN){names[i] = "I-Token";itoken++;}
            if (a = 1 && a <= MAXLTOKEN){names[i] = "L-Token";ltoken++;}
            if (a = 2 && a <= MAXTTOKEN){names[i] = "T-Token";ttoken++;}
            if(itoken == MAXITOKEN && ltoken == MAXLTOKEN && ttoken == MAXTTOKEN){b_all = true;}
        }

        return boolean createMTokens(names);
    }
}

    /* second class to create moveable tokens */
    private boolean createMTokens(String[] names) {

        int namecounter = 0;
        int i = 0;
        int roundcounter = 1;
        boolean rount = true;
        while (i <= desklength) {
            if(i = 0 || (roundcounter % 2 == 0) && (roundcounter % (desklength/desklength) == 0)) {
                i++;
            }
            if (rountcounter % (desklength/desklength) == 0) {
                if (rount == true) {rount = false;}
                else {rount = true;}
            }
            standardDesk[i] = new token(names[namecounter], getInt(names[namecounter]), getMarkNr(names[namecounter]));
            namecounter++;
            rountcounter++;
            if (rount == true) {i + 2;}
            else {i++;}
        }
    }
    /* get as Int if the token is a "I-", "L-" or a "T- Token"*/
    private int getInt(s){
        if(s == "I-Token"){return 0;}
        else if(s == "L-Token"){return 1;}
        else {return 2;}
    }

    /* get the mark of the token */
    getMarkNr(s) {
        if (s == "T-Token"){
            nr = mark[marknr];
            marknr++;
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
        standardDesk[18] = new token("T-Token",new int[]{1,0,1,1},9);
        standardDesk[20] = new token("T-Token",new int[]{1,0,1,1},10);
        standardDesk[28] = new token("T-Token",new int[]{1,1,1,0},11);
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
    public token[]getstandardDesk(){
        return standardDesk;
    }
}