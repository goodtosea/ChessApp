package game;

import pieces.*;

/**
 * Agent to manage the movement of pieces.
 */
public class Mover
{
    /**
     * Constructs a mover.
     */
    public Mover() {

    }

    /**
     * Moves a piece if the move follows the rules of chess.
     * @param piece - the piece to attempt to move
     * @param x - the column to attempt to move to
     * @param y - the row to attempt to move to
     * @return true if the piece moves successfully, and false otherwise
     */
    boolean tryMovePiece(Piece piece, int x, int y) {
        // if (isValidMove(...)) then move
    }

    /**
     * Checks if a move follows the rules of chess.
     * @param piece - the piece to check a move for
     * @param x - the column to simulate a move to
     * @param y - the row to simulate a move to
     * @return
     */
    public boolean isValidMove(Piece piece, int x, int y) {
        /*
           check:
           (1) if the specific piece can move that way,
           (2) if it is the appropriate player's turn,
           (3) if the player's king is in check.
         */
    }

}
