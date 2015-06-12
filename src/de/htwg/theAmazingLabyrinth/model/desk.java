package de.htwg.theAmazingLabyrinth.model;

import java.lang.System;

public class desk {

    private token[][] standardDesk = new token[7][7]; /*7*7 standard deskSize*/
    private mark[] = new mark[24]; /* the array to count the special tokens, 1-4 = startplaces*/
    private marknr; /*reader of the mark - array*/

    /*Initialising*/
    public desk(){
        createFixTokens();
        createMoveableTokens();
        while(int i = 1; i <= 24; i++){
            mark[i] = i;
        }
    }

    //Prototyp!
    /*create all moveable Tokens on the Table by Initialising*/
    private boolean createMoveableTokens(){
        marknr = 0;
        final int MAXITOKEN = 12;       //max. I - Tokens
        final int MAXLTOKEN = 14;       //max. L - Tokens
        final int MAXTTOKEN = 6;        //max. T - Token
        int randomInt;                  //random (zahl auf englisch) to create random tokens
        String names[]= new String[32]; //Array for the 32 moveable Tokens
        boolean b_all;                  //counter if all tokens are created
        int itoken; ltoken, ttoken;     //tokencounter

        for(int i = 0;b_all != true;i++){
            a = (int) (Math.random() * 2);
            if (a = 0 && a <= maxItoken){names[i] = "I-Token";itoken++;}
            if (a = 1 && a <= maxLtoken){names[i] = "L-Token";ltoken++;}
            if (a = 2 && a <= maxTtoken){names[i] = "T-Token";ttoken++;}
            if(itoken == MAXITOKEN && ltoken == MAXLTOKEN && ttoken == MAXTTOKEN){all = true;}
        }

        boolean b_first = createFirstHalf(s);
        boolean b_second = createSecondHalf(s);
        if(b_first == true && b_second == true){return true;}
    }

    /* create the first 12 moveable tokens */
    private boolean createFirstHalf(String s){
        for(int i = 0; i <= 6; i+2){
            for(int j = 1; j <= 3; j++) {
                if(getInt(s) == 2){
                    standardDesk[i][(j*2)-1] = new token(s, getInt(s), mark[marknr]);
                    marknr++;
                } else {standardDesk[i][(j*2)-1] = new token(s, getInt(s), 0);
            }
            if(i == 6){
                return true;
            }
        }
        return false;
    }

    /*create the second 20 moevable tokens*/
    private boolean createSecondHalf(String s){
        for(int i = 1; i <= 5; i++){
            for(int j = 0; j <= 6; j++){
                if(getInt(s) == 2){
                    standardDesk[i][(j*2)-1] = new token(s, getInt(s), mark[marknr]);
                    marknr++;
                } else {standardDesk[i][(j*2)-1] = new token(s, getInt(s), 0);
            }
            if(i == 5){
                return true;
            }
            return false;
        }
    }

    /* get as Int if the token is a "I-", "L-" or a "T- Token"*/
    private int getInt(s){
        if(s == "I-Token"){return 0;}
        else if(s == "L-Token"){return 1;}
        else {return 2;}
    }

    /* creates all fix Tokens on the Table by Initialising */
    private boolean createFixTokens(){
        standardDesk[0][0] = new token("L-Token",new int[]{0,1,1,0},1);
        standardDesk[0][2] = new token("T-Token",new int[]{0,1,1,1},0);
        standardDesk[0][4] = new token("T-Token",new int[]{0,1,1,1},0);
        standardDesk[0][6] = new token("L-Token",new int[]{0,0,1,1},2);
        standardDesk[2][0] = new token("T-Token",new int[]{1,1,1,0},0);
        standardDesk[2][2] = new token("T-Token",new int[]{0,1,1,1},0);
        standardDesk[2][4] = new token("T-Token",new int[]{1,0,1,1},0);
        standardDesk[2][6] = new token("T-Token",new int[]{1,0,1,1},0);
        standardDesk[4][0] = new token("T-Token",new int[]{1,1,1,0},0);
        standardDesk[4][2] = new token("T-Token",new int[]{1,1,1,0},0);
        standardDesk[4][4] = new token("T-Token",new int[]{1,1,0,1},0);
        standardDesk[4][6] = new token("T-Token",new int[]{1,0,1,1},0);
        standardDesk[6][0] = new token("L-Token",new int[]{1,1,0,0},3);
        standardDesk[6][2] = new token("T-Token",new int[]{1,1,0,1},0);
        standardDesk[6][4] = new token("T-Token",new int[]{1,1,0,1},0);
        standardDesk[6][6] = new token("L-Token",new int[]{1,0,0,1},4);
        return true;
    }

    public token[][] getstandardDesk(){
        return standardDesk;
    }
}