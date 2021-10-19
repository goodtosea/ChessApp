package pieces;

/**
 * Chess piece that moves and captures horizontally and vertically.
 */
public class Rook extends Piece
{
    /**
     * Constructs a rook and places it at a specified position on the board.
     * @param x - the column to place the rook
     * @param y - the row to place the rook
     */
    public Rook(int x, int y) {
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
