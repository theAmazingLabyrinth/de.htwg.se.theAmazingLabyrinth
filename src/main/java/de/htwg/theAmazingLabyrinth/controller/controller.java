package de.htwg.theAmazingLabyrinth.controller;

import de.htwg.theAmazingLabyrinth.model.desk;
import de.htwg.theAmazingLabyrinth.model.token;
import de.htwg.theAmazingLabyrinth.model.player;
import java.util.HashMap;
import java.util.Map;

public class controller implements Icontroller{

    private Map<Integer, token> token = new HashMap<Integer, token>();
    private Map<Integer, player> player = new HashMap<Integer, player>();
    private token freeToken;
    private int tokenNumbers;
    private desk Desk;

    public controller(int anzPlayer, int tokenNumbers, token freeToken){
        this.tokenNumbers = tokenNumbers;
        Desk = new desk(this.tokenNumbers);
        this.freeToken = freeToken;
        createTokenMap();
        createPlayerMap(anzPlayer);
    }

    private void createTokenMap(){
        token[] desk = new token[49];
        for(int i = 0; i < desk.length; i++) {
            desk[i] = Desk.getStandardDesk(i);
        }
        for(int i = 0; i < desk.length; i++) {
            token.put(i, desk[i]);
        }
    }

    private boolean createPlayerMap(int anzPlayer){
        int max =  tokenNumbers * tokenNumbers - 1;
        if(anzPlayer < 2 || anzPlayer > 4){
            return false;
        }
        if(anzPlayer >= 3){
            player.put(max, new player("Player 1", max - 1));
            if(anzPlayer == 4) {
                player.put(max, new player("Player 3", max));
                player.put(max  - (tokenNumbers -1), new player("Player 4", max - (tokenNumbers -1 )));
            }
        }
        player.put(0, new player("Player 1", 0));
        player.put(tokenNumbers -1, new player("Player 2", tokenNumbers - 1));
        return true;
    }

    /* move token */
    @Override
    public boolean moveToken(int startToken){
        token tmp = token.get(startToken);
        token oldFreeToken = freeToken;
        int Numbers = tokenNumbers - 1;
        if(tmp.getMoveable()){
            testWay(startToken, Numbers);
            token.put(startToken, oldFreeToken);
            return true;
        }
        return false;
    }

    /*Method test witch way the token get moved */
    private void testWay(int startToken, int Numbers){
        token Token = token.get(startToken);
        int jumpPoint = 0;
        moveTokenController mtoken = new moveTokenController(token, player);
        if((startToken%(Numbers + 1)) == 0 && Token.getMoveable()) { //If moved from left to right
            jumpPoint = mtoken.moveTokenToRight(startToken, Numbers);
        }

        if(((startToken+1)%(Numbers + 1)) == 0 && Token.getMoveable()){ //If moved from right to left
            jumpPoint = mtoken.moveTokenToLeft(startToken, Numbers);
        }
        if(startToken < Numbers + 1  && Token.getMoveable()){       //If moved from top to bottom
            jumpPoint = mtoken.moveTokenToBottom(startToken, Numbers);
        }
        if(startToken > (Numbers * (Numbers + 1)) && Token.getMoveable()){  //If moved from bottom to top
            jumpPoint = mtoken.moveTokenToTop(startToken, Numbers);
        }
        mtoken.testMovePlayer(startToken, jumpPoint);
    }

    /*moves the player*/
    @Override
    public boolean movePlayer(player Player, String Eingabe){
        System.out.println(player);
        player tmp = new player(Player.getName(), Player.getPosition());
        movePlayerController mplayer = new movePlayerController();
        mplayer.movePlayer(token, Player, tokenNumbers);
        int pos = mplayer.movePl(Eingabe);
        if(free(pos)) {
            player.remove(tmp.getPosition());
            player.put(pos, Player);
        }
        System.out.println(player);
        return true;
    }

    /*actual only a method to set a player were we want him, get deleted after the finish of the game*/
    public void setPlayer(player Player, int pos){
        player.put(pos, Player);
    }

    /*looks if the field is free and u can walk on it*/
    private boolean free(int pos){
        if(player.get(pos) != null){
            return false;
        }
        return true;
    }
}
