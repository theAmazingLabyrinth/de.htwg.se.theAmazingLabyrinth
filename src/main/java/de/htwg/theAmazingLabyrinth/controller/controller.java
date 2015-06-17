package de.htwg.theAmazingLabyrinth.controller;


import de.htwg.theAmazingLabyrinth.model.desk;
import de.htwg.theAmazingLabyrinth.model.token;
import java.util.HashMap;
import java.util.Map;

public class controller {

    private Map<Integer, token> token;
    private Map<Integer, String> player;
    private token freeToken;
    private int deskLength;
    private int anzPlayer;
    private desk Desk;

    public controller(int anzPlayer, int tokenNumbers){
        this.anzPlayer = anzPlayer;
        token = new HashMap<Integer, token>();
        player = new HashMap<Integer, String>();
        Desk = new desk(tokenNumbers);
        createTokenMap();
        createPlayerMap(this.anzPlayer);
    }

    private void createTokenMap(){
        token[] desk = Desk.getStandardDesk();

        for(int i = 0; i <= desk.length; i++) {
            token.put(i, desk[i]);
        }
    }

    private void createPlayerMap(int anzPlayer){
        return;
    }

}
