package de.htwg.theAmazingLabyrinth.controller;

import de.htwg.theAmazingLabyrinth.model.token;
import de.htwg.theAmazingLabyrinth.model.player;

import java.util.Map;

public class moveTokenController {
    private int[] a = {1,0,1,0};
    private token freeToken = new token("freeToken", a, 0, true);
    private Map<Integer, token> token;
    private Map<Integer, player> player;


    public moveTokenController(Map<Integer, token> token, Map<Integer, player> player){
        this.token = token;
        this.player = player;
    }

    /*Method to move token from left to right */
    public int moveTokenToRight(int counter, int number){
        int free = counter + number;
        freeToken = token.get(free);
        for (int i = 0; i < number; i++) {
            token.put(counter + number - i, token.get(counter + number - (i+1)));
        }
        return free;
    }

    /*Method to move a token from right to left */
    public int moveTokenToLeft(int counter, int number){
        int free = counter - number -1;
        freeToken = token.get(free);
        for(int i = 1; i < number; i++){
            token.put((counter - number - 1) + i, token.get(counter - number - 1 + i));
        }
        return free;
    }

    /*Method to move a token from top to bottom*/
    public int moveTokenToBottom(int counter, int number) {
        int free = counter + (number * (number + 1));
        freeToken = token.get(free);
        for (int i = 1; i < number; i++) {
            token.put(counter + (number * (number +1)), token.get(counter + ((number - i - 1) * (number +1))));
        }
        return free;
    }

    /*Method to move a token from bottom to top */
    public int moveTokenToTop(int counter, int number) {
        freeToken = token.get(counter);
        for (int i = 1; i < number; i++) {
            token.put(counter, token.get(counter + ((i + 1) * (number + 1))));
        }
        return counter;
    }


    /*Method test if a player is on the token with get the new freeToken*/
    public void testMovePlayer(int lastPoint, int jumpPoint){
        player pl = player.get(lastPoint);
        if(player.get(jumpPoint) != null) {
            player.put(lastPoint, pl);
            player.remove(jumpPoint);
        }
    }
}
