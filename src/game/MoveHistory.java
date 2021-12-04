package game;

import java.util.*;

import pieces.*;

/**
 * The overall Move History of the game that accounts for all the moves encountered during the game.
 */
public class MoveHistory extends ArrayList<Move>{   

    /**
     * Gets the Last Move of the current game.
     * @return the last move encountered during the game
     */
    public Move getLastMove(){
        return size() > 0 ? get(size() - 1) : null;
    }

}