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
    private int tokenNumbers;
    private int anzPlayer;
    private boolean b_player;
    private desk Desk;

    public controller(int anzPlayer, int tokenNumbers){
        this.anzPlayer = anzPlayer;
        this.tokenNumbers = tokenNumbers;
        token = new HashMap<Integer, token>();
        player = new HashMap<Integer, String>();
        Desk = new desk(this.tokenNumbers);
        createTokenMap();
        b_player = createPlayerMap(this.anzPlayer);
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
            player.put(((tokenNumbers-1) * tokenNumbers)-1, "Player 3");
        } else if(anzPlayer == 4) {
            player.put(((tokenNumbers-1) * tokenNumbers)-1, "Player 3");
            player.put((tokenNumbers * tokenNumbers)-1, "Player 4");
        }
        player.put(0, "Player 1");
        player.put(tokenNumbers -1, "Player 2");
        return true;
    }

}
