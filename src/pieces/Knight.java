package pieces;

/**
 * Chess piece that moves to and captures cells positioned at an L-like path from it,
 * specifically 2 rows and 1 column away, or 2 columns and 1 row away.
 */
public class Knight extends Piece
{
    /**
     * Constructs a knight and places it at a specified position on the board.
     * @param x - the column to place the knight
     * @param y - the row to place the knight
     */
    public Knight (int x, int y) {
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
}
