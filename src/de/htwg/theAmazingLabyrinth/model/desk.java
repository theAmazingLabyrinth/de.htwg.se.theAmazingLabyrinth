package de.htwg.theAmazingLabyrinth.model;

import java.lang.System;

public class desk {

    token[][] standardDesk = new token[7][7]; /*7*7 standard deskSize*/

    /*Initialising*/
    public desk(){
        createFixTokens();
        createMoveableTokens();
    }

    //Prototyp!
    /*create all moveable Tokens on the Table by Initialising*/
    public boolean createMoveableTokens(){
        // 	0 == "I-Token" ; 1 == "L-Token" ; 2 == "T-Token"
        int token;

        int i;
        int j = 1;
        int count;       //count the rounds from the while - funktion
        boolean again = false;  //looks, if the while - funktion must do an additional go.
        int Null = 0;   //count, how often token get null, max. 12;
        int One = 0;    //count, how often token get one, max. 16;
        int Two = 0;    //count, how often token get two, max. 6;

        //first while()
        while(i <= 6){
            again = false;
            token = (int)(Math.random()*3);
            switch(token){
                case 0:{
                    if(Null >= 12) {
                        standartDesk[i][j] = new token("I-Token", new int[] = randomWays(0), 0);
                        Null++;
                    } else {
                        again = true;
                    }
                    break;
                }
                case 1:{
                    if(One >= 16){
                        standardDesk[i][j] = new token("L-Token", new int[] = randomWays(1), 0);
                        One++;
                    } else {
                        again = true;
                    }
                    break;
                }
                case 2:{
                    if(Two)>= 6){
                        standardDesk[i][j] = new token("T-Token", new int[] = randomWays(2), 0);
                        Two++;
                    } else {
                        again = true;
                    }
                    break;
                }

                default:{
                    System.out.println("Error at 'createMoveableTokens'! First while - funktion");
                }
            }

            if(count == 2){
                i += 2;
                mal3 = 0;
                j = 0;
            }
            if(!again) {
                j++;
                count++;
            }
        }

        int i = 1;
        int j;

        //return all counters to the original
        int count;
        int Null = 0;
        int One = 0;
        int Two = 0;

        //second while()
        while(i <= 4){
            again = false;
            token = (int)(Math.random()*3);
            switch(token){
                case 0:{
                    if(Null >= 12) {
                        standartDesk[i][j] = new token("I-Token", new int[] = randomWays(0), 0);
                        Null++;
                    } else {
                        again = true;
                    }
                    break;
                }
                case 1:{
                    if(One >= 16){
                        standardDesk[i][j] = new token("L-Token", new int[] = randomWays(1), 0);
                        One++;
                    } else {
                        again = true;
                    }
                    break;
                }
                case 2:{
                    if(Two)>= 6){
                        standardDesk[i][j] = new token("T-Token", new int[] = randomWays(2), 0);
                        Two++;
                    } else {
                        again = true;
                    }
                    break;
                }

                default:{
                    System.out.println("Error at 'createMoveableTokens'! Second while - funktion");
                }
            }

            if(count == 6){
                i += 2;
                count = 0;
                j = -1;
            }
            if(!again) {
                j++;
                count++;
            }
        }
        return false;
    }

    /* creates all fix Tokens on the Table by Initialising */
    public boolean createFixTokens(){
        standardDesk[0][0] = new token("L-Token",new int[]{0,1,1,0},0);
        standardDesk[0][2] = new token("T-Token",new int[]{0,1,1,1},0);
        standardDesk[0][4] = new token("T-Token",new int[]{0,1,1,1},0);
        standardDesk[0][6] = new token("L-Token",new int[]{0,0,1,1},0);
        standardDesk[2][0] = new token("T-Token",new int[]{1,1,1,0},0);
        standardDesk[2][2] = new token("T-Token",new int[]{0,1,1,1},0);
        standardDesk[2][4] = new token("T-Token",new int[]{1,0,1,1},0);
        standardDesk[2][6] = new token("T-Token",new int[]{1,0,1,1},0);
        standardDesk[4][0] = new token("T-Token",new int[]{1,1,1,0},0);
        standardDesk[4][2] = new token("T-Token",new int[]{1,1,1,0},0);
        standardDesk[4][4] = new token("T-Token",new int[]{1,1,0,1},0);
        standardDesk[4][6] = new token("T-Token",new int[]{1,0,1,1},0);
        standardDesk[6][0] = new token("L-Token",new int[]{1,1,0,0},0);
        standardDesk[6][2] = new token("T-Token",new int[]{1,1,0,1},0);
        standardDesk[6][4] = new token("T-Token",new int[]{1,1,0,1},0);
        standardDesk[6][6] = new token("L-Token",new int[]{1,0,0,1},0);
        return true;
    }
}