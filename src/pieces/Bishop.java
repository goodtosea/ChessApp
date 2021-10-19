package pieces;

/**
 * Chess piece that moves and captures diagonally.
 */
public class Bishop extends Piece
{
    /**
     * Constructs a bishop and places it at a specified position on the board.
     * @param x - the column to place the bishop
     * @param y - the row to place the bishop
     */
    public Bishop(int x, int y) {
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
