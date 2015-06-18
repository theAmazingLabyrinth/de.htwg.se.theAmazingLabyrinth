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
    private token Token;

    public controller(int anzPlayer, int tokenNumbers, token freeToken){
        this.anzPlayer = anzPlayer;
        this.tokenNumbers = tokenNumbers;
        token = new HashMap<Integer, token>();
        player = new HashMap<Integer, String>();
        Desk = new desk(this.tokenNumbers);
        this.freeToken = freeToken;
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

    /* move token */
    public boolean moveToken(int startToken){
        token tmp = token.get(startToken);
        int counter = startToken;
        token oldFreeToken = freeToken;
        if(tmp.getMoveable()){
            if((startToken%tokenNumbers) == 0){             //If moved from left to right
                freeToken = token.get((counter + tokenNumbers)-2);
                for(int i = tokenNumbers; i > 1; i--){
                    token.put((counter + tokenNumbers) - 2, token.get((counter + tokenNumbers)-3));
                    counter--;
                }
            }else if(((startToken+1)%tokenNumbers) == 0){         //If moved from right to left
                freeToken = token.get(counter - 1);
                for(int i = 1; i < tokenNumbers; i++){
                    token.put(counter - 1, token.get(counter));
                    counter++;
                }
            }else if(startToken < tokenNumbers){                    //If moved from top to bottom
                freeToken = token.get(counter + ((tokenNumbers -1) * tokenNumbers) - 2);
                for(int i = 1; i < tokenNumbers; i++){
                    token.put(counter + ((tokenNumbers - i) * tokenNumbers) - 2 , token.get(counter + ((tokenNumbers - (i+1)) * tokenNumbers) - 2));
                }
            }else if(startToken > ((tokenNumbers- 1) * tokenNumbers)){  //If moved from bottom to top
                freeToken = token.get(counter - ((tokenNumbers - 1) * tokenNumbers) - 1);
                for(int i = 1; i < tokenNumbers; i++) {
                    token.put((counter - ((tokenNumbers - i) * tokenNumbers) - 2), token.get(counter - ((tokenNumbers - i) * tokenNumbers) - 2));
                }
            }
            token.put(counter, oldFreeToken);
            return true;
        }
        return false;
    }

}
