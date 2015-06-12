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
        for(int i=5; i<24; i++){
            new mark[i-5] = i;
        }
    }

    private boolean createMoveableTokens(){
        return true;
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