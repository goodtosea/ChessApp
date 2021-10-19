package pieces;

import java.util.ArrayList;

/**
 * An abstract chess piece.
 */
public class Piece
{
    /**
     * Constructs a piece.
     */
    public Piece() {

    }

    /**
     * Constructs a piece and places it at a specified position on the board.
     * @param x - the column to place the piece
     * @param y - the row to place the piece
     */
    public Piece(int x, int y) {

    }

    /**
     * Checks if the piece can move in the specified way, not accounting for check or player turn.
     * @param x - the column to move to
     * @param y - the row to move to
     * @return true if the move is valid, and false otherwise
     */
    public boolean isValidMove(int x, int y) {

    }

    // should probably make a Position class that stores two integers, so that this returns ArrayList<Position>
    /**
     * Finds all the ways the piece can move, not accounting for check or player turn.
     * @return an ArrayList arr such that the valid moves are to the cells x=arr.get(2k), y=arr.get(2k+1) for integers k
     */
    public ArrayList<Integer> findAllValidMoves() {
        // possible brute force: for each cell (x,y) on the board, call isValidMove(x,y)
    }

}
