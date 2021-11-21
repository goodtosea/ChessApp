package game;

import java.util.*;

import pieces.*;

/**
 * The Individual moves done by the players, used to keep track of the MoveHistory.
 */
public class Move{

    private Piece piece;
    private boolean isWhite;
    private List<Integer> start;
    private List<Integer> end;

    /**
     * Constructs a move with the piece, color and start and end position.
     * @param piece the piece that is moved
     * @param isWhite the color of Piece
     * @param start the start coordinates of Piece
     * @param end the end coordinates of Piece
     */
    public Move(Piece piece, boolean isWhite, List<Integer> start, List<Integer> end)
    {
        this.piece = piece;
        this.isWhite = isWhite;
        this.start = start;
        this.end = end;
    }

    /**
     * Getter for piece of the move
     * @return piece of the move
     */
    public Piece getPiece(){
        return piece;
    }

    /**
     * Checks if the Piece is White
     * @return true if the Piece is White, else false
     */
    public boolean isWhite(){
        return isWhite;

    }

    /**
     * Gets the end coordinates of the Piece
     * @return a list of x and y coordinates after the piece is moved
     */
    public List<Integer> getEnd() {
        return end;
    }

    /**
     * Gets the start coordinates of the Piece
     * @return a list of x and y coordinates before the piece is moved
     */
    public List<Integer> getStart() {
        return start;
    }
}