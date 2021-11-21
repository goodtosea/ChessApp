package game;

import pieces.*;

/**
 * The Individual moves done by the players, used to keep track of the MoveHistory.
 */
public class Move{

    private Piece pieceType;
    private boolean isWhite;
    private List<Integer> start;
    private List<Integer> end;

    /**
     * Constructs a move with the pieceType, color and start and end position.
     * @param pieceType the type of Piece
     * @param isWhite the color of Piece
     * @param start the start coordinates of Piece
     * @param end the end coordinates of Piece
     */
    public Move(Piece pieceType, boolean isWhite, List<Integer> start, List<Integer> end)
    {
        this.pieceType = pieceTyepe;
        this.isWhite = isWhite;
        this.start = start;
        this.end = end;
    }

    /**
     * Checks if the Piece is a Pawn
     * @return true if the Piece is Pawn, else false
     */
    public boolean isPawn(){
        return pieceType instanceof Pawn;
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