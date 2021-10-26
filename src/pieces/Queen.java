package pieces;

/**
 * Chess piece that moves and captures diagonally, vertically, and horizontally.
 */
public class Queen implements Piece
{
	private int 	x;
	private int 	y;
	private boolean isWhite;
	
    /**
     * Constructs a queen and places it at a specified position on the board.
     * @param x - the column to place the queen
     * @param y - the row to place the queen
     */
    public Queen(int x, int y, boolean isWhite) {
        super(x, y, isWhite);
    }

    /**
     * Checks if the piece can move in the specified way, not accounting for check or player turn.
     * @param x - the column to move to
     * @param y - the row to move to
     * @return true if the move is valid, and false otherwise
     */
    @Override
    public boolean isValidMove(int x, int y) {
    	// If it is a valid rook or bishop move, it's a valid queen move
    	if ((Math.abs(x - this.x) == Math.abs(y - this.y)) || ((x == this.x) || (y == this.y)))
    		return true;
    	return false;
    }
}
