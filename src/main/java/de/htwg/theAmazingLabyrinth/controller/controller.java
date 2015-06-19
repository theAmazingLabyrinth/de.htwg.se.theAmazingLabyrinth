package de.htwg.theAmazingLabyrinth.controller;


import de.htwg.theAmazingLabyrinth.model.desk;
import de.htwg.theAmazingLabyrinth.model.token;
import de.htwg.theAmazingLabyrinth.model.player;
import java.util.HashMap;
import java.util.Map;

public class controller {

    private Map<Integer, token> token = new HashMap<Integer, token>();
    private Map<Integer, player> player = new HashMap<Integer, player>();
    private token freeToken;
    private int tokenNumbers;
    private int anzPlayer;
    private desk Desk;
    private token Token;
    private moveTokenController mtoken;
    private player Player;

    public controller(int anzPlayer, int tokenNumbers, token freeToken){
        this.anzPlayer = anzPlayer;
        this.tokenNumbers = tokenNumbers;
        Desk = new desk(this.tokenNumbers);
        this.freeToken = freeToken;
        createTokenMap();
    }

    private void createTokenMap(){
        token[] desk = Desk.getStandardDesk();

        for(int i = 0; i <= desk.length; i++) {
            token.put(i, desk[i]);
        }
    }

    private boolean createPlayerMap(int anzPlayer){
        if(anzPlayer < 2){
            return false;
        }
        if(anzPlayer == 3){
            player.put(((tokenNumbers-1) * tokenNumbers)-1, new player("Player 1"));
        } else if(anzPlayer == 4) {
            player.put(((tokenNumbers-1) * tokenNumbers)-1, new player("Player 3"));
            player.put((tokenNumbers * tokenNumbers)-1, new player("Player 4"));
        }
        player.put(0, new player("Player 1"));
        player.put(tokenNumbers -1, new player("Player 2"));
        return true;
    }

    /* move token */
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
        int jumpPoint = 0;
        mtoken = new moveTokenController(token, player);
        if((startToken%Numbers + 1) == 0 && Token.getMoveable()) { //If moved from left to right
            jumpPoint = mtoken.moveTokenToRight(startToken, Numbers);
        }
        if(((startToken+1)%Numbers + 1) == 0 && Token.getMoveable()){ //If moved from right to left
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


    public void movePlayer(player Player){
        token.get(Player.getPosition());

    }

}
