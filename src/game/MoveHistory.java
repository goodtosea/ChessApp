package game;

import pieces.*;

/**
 * The overall Move History of the game that accounts for all the moves encountered during the game.
 */
public class MoveHistory extends ArrayList<Move>{

    private ArrayList<Move> moves;

    /**
     * Stores the moves in the move history.
     * @param m - the move that is to be stored
     */
    public void storeMove(Move m){
        moves.add(m);
    }

    /**
     * Gets the History of the Moves.
     * @return the list of all the moves in the current game
     */
    public ArrayList<Move> getHistory(){
        return moves;
    }

    /**
     * Gets the Last Move of the current game.
     * @return the last move encountered during the game
     */
    public Move getLastMove(){
        return moves.get(moves.size() - 1);
    }


}