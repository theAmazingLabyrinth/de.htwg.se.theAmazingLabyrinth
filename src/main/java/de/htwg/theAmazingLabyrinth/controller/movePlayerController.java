package de.htwg.theAmazingLabyrinth.controller;

import de.htwg.theAmazingLabyrinth.model.token;
import de.htwg.theAmazingLabyrinth.model.player;
import java.util.HashMap;
import java.util.Map;

public class movePlayerController{
    private player Player;
    private Map<Integer, token> token = new HashMap<Integer, token>();

    private int deskLength;


    public void movePlayer(Map<Integer, token> token, player Player, int deskLength){
        this.Player = Player;
        this.token = token;
        this.deskLength = deskLength;
    }

    /*Method move the player*/
    public int movePl(String Eingabe){
        int move = 0;
        if(Eingabe.equals("W")){
            move = setPlayerPos(Eingabe);
        } else if(Eingabe.equals("D")){
            move = setPlayerPos(Eingabe);
        } else if(Eingabe.equals("S")){
            move = setPlayerPos(Eingabe);
        } else if(Eingabe.equals("A")){
            move = setPlayerPos(Eingabe);
        }
        return move;
    }

    /*set Player pos if no walls or end in the way*/
    private int setPlayerPos(String s){
        if(testWays(s)) {
            return newPlayerPosition(s);
        } else return 0;
    }


    /*test if on the way are walls*/
    private boolean testWays(String s){
        if(testEnd(s)) {
            token oldToken = token.get(Player.getPosition());
            if (testWalls(s, oldToken, true)) {
                token newToken = getNewPlayerToken(s);
                return testWalls(s, newToken, false);
            }
        }
        return false;
    }

    /* test if the player moves out of the map*/
    private boolean testEnd(String s){
        int pos = Player.getPosition();
        if(s.equals("W") && (pos<deskLength)){
            return false;
        }
        if(s.equals("D") && ((pos +1)%deskLength == 0)){
            return false;
        }
        if(s.equals("S") && pos >= (deskLength * (deskLength-1))){
            return false;
        }
        if(s.equals("A") && (pos%deskLength) == 0){
            return false;
        }
        return true;
    }

    /*test if or ifnot a wall at this site */
    private boolean testWalls(String s , token Token, boolean firstway){
        int side = 0;
        if(firstway) {
            side = checkfirstWay(s);
        } else if(!firstway){
            side = checksecondWay(s);
        }
        /////////////////////////////////
        System.out.print(" Token: ");
        for(int i = 0; i < 4; i++){
            System.out.print(Token.getWay(i));
        }
        System.out.println();
        /////////////////////////////////////7
        if(Token.getWay(side) != 0){
            return true;
        }
        return false;
    }

    /* looks with side the walls must get tested*/
    private int checkfirstWay(String s){
        int back = -1;
        if(s.equals("W")){
            back = 0;
        } else if(s.equals("D")){
            back = 1;
        } else if(s.equals("S")){
            back = 2;
        } else if(s.equals("A")){
            back = 3;
        }
        return back;
    }

    /*looks with side the walls of the next token must get tested*/
    private int checksecondWay(String s){
        int back = -1;
        if(s.equals("W")){
            back = 2;
        } else if(s.equals("D")){
            back = 3;
        } else if(s.equals("S")){
            back = 0;
        } else if(s.equals("A")){
            back = 1;
        }
        return back;
    }

    /*return the second token from witch the walls must get tested*/
    private token getNewPlayerToken(String s){
        token Token = null;
        if(s.equals("W")){
            Token = token.get(Player.getPosition() - deskLength);
        } else if(s.equals("D")){
            Token = token.get(Player.getPosition() + 1);
        } else if(s.equals("S")){
            Token = token.get(Player.getPosition() + deskLength);
        } else if(s.equals("A")){
            Token = token.get((Player.getPosition() - 1));
        }
        return Token;
    }

    /*get the new position of the player*/
    private int newPlayerPosition(String s){
        int pos = -1;
        if(s.equals("W")){
            pos = Player.getPosition() - deskLength;
        } else if(s.equals("D")){
            pos = Player.getPosition() + 1;
        } else if(s.equals("S")){
            pos = Player.getPosition() + deskLength;
        } else if(s.equals("A")){
            pos = Player.getPosition() - 1;
        }
        return pos;
    }
}
