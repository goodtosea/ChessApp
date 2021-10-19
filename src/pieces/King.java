package pieces;

/**
 * Chess piece that can move to and capture the 8 cells adjacent to it.
 * When the king is inescapably threatened, its player loses.
 */
public class King extends Piece
{
    /**
     * Constructs a king and places it at a specified position on the board.
     * @param x - the column to place the king
     * @param y - the row to place the king
     */
    public King(int x, int y) {
        super(x,y);
    }

    /**
     * Checks if the piece can move in the specified way, not accounting for check or player turn.
     * @param x - the column to move to
     * @param y - the row to move to
     * @return true if the move is valid, and false otherwise
     */
    @Override
    public boolean isValidMove(int x, int y) {

    }

    /**
     * Checks if the king is in check.
     * @return true if the king is in check, and false otherwise
     */
    public boolean isInCheck() {
        // if true, then maybe call isInCheckmate().
    }

    /**
     * Checks for checkmate.
     * @return true if king is in checkmate, and false otherwise
     */
    private boolean isInCheckmate() {

    }

}
