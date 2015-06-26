package de.htwg.theAmazingLabyrinth.controller;

import de.htwg.theAmazingLabyrinth.model.player;

public interface Icontroller {
    /*move a row of token from the place the first token(starttoken) in a line*/
    boolean moveToken(int startToken);

    /*test if the player can move and if he can he get moved via W,A,S,D (Hoch, Rechts, Runter, Links)*/
    boolean movePlayer(player Player, String s);
}
