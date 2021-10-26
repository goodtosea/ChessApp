package pieces;

/**
 * Chess piece that moves and captures horizontally and vertically.
 */
public class Rook implements Piece
{
	private int 	x;
	private int 	y;
	private boolean hasMoved;
	private boolean isWhite;
	
    /**
     * Constructs a rook and places it at a specified position on the board.
     * @param x - the column to place the rook
     * @param y - the row to place the rook
     */
    public Rook(int x, int y, boolean isWhite) {
        super(x, y, isWhite);
        hasMoved = false;
    }

    /**
     * Checks if the piece can move in the specified way, not accounting for check or player turn.
     * @param x - the column to move to
     * @param y - the row to move to
     * @return true if the move is valid, and false otherwise
     */
    @Override
    public boolean isValidMove(int x, int y) {
    	// Movement only on row or column
    	if (x == this.x || y == this.y)
    		return true;
    	return false;
    }
    
    
    /**
     * Used for castling later.
     * @return true if hasMoved was set to true
     */
    public boolean setHasMoved() {
    	if (hasMoved == false) {
    		hasMoved = true;
    		return true;
    	}
    	return false;
    }
    
}
