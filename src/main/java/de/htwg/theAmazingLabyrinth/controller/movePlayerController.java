package de.htwg.theAmazingLabyrinth.controller;

import de.htwg.theAmazingLabyrinth.model.token;
import de.htwg.theAmazingLabyrinth.model.player;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class movePlayerController{
    private token oldToken;
    private token newToken;
    private player Player;
    private Map<Integer, player> player = new HashMap<Integer, player>();
    private Map<Integer, token> token = new HashMap<Integer, token>();

    private int deskLength;


    public void movePlayer(Map<Integer, token> token, Map<Integer, player> player, player Player, int deskLength){
        this.player = player;
        this.Player = Player;
        this.token = token;
        this.deskLength = deskLength;
    }

    /*Method move the player*/
    public int movePl(String Eingabe){
        if(Eingabe == "W"){
            setPlayerPos(Eingabe);
        } else if(Eingabe == "D"){
            setPlayerPos(Eingabe);
        } else if(Eingabe == "S"){
            setPlayerPos(Eingabe);
        } else if(Eingabe == "A"){
            setPlayerPos(Eingabe);
        }
        return Player.getPosition();
    }

    /*set Player pos if no walls or end in the way*/
    private void setPlayerPos(String s){
        if(!testWays(s)) {
            int pos = Player.getPosition();
            player.put(pos - deskLength, Player);
            Player.setPosition(pos - deskLength);
        }
    }

    /* test if the player moves out of the map*/
    private boolean testEnd(String s){
        int pos = Player.getPosition();
        if(s == "W" && (pos<deskLength)){
            return true;
        }
        if(s =="D" && ((pos +1)%deskLength == 0)){
            return true;
        }
        if(s == "S" && pos > (deskLength * (deskLength-1))){
            return true;
        }
        if(s == "A" && pos%deskLength == 0){
            return true;
        }
        return false;
    }

    /*test if on the way are walls*/
    private boolean testWays(String s){
        if(!testEnd(s)) {
            oldToken = token.get(Player.getPosition());
            if (!testWalls(0, oldToken)) {
                token newToken = token.get(Player.getPosition() - deskLength);
                return testWalls(2, newToken);
            }
        }
        return false;
    }

    /*test if or ifnot a wall at this site */
    private boolean testWalls(int site, token Token){
        int wall = Token.getWay(site);
        if(wall == 1){
            return true;
        }
        return false;
    }
}
