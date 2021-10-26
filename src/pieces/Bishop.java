package pieces;

import java.util.ArrayList;

/**
 * Chess piece that moves and captures diagonally.
 */
public class Bishop implements Piece
{
	private int 	x;
	private int 	y;
	private boolean isWhite;
	
    /**
     * Constructs a bishop and places it at a specified position on the board.
     * @param x - the column to place the bishop
     * @param y - the row to place the bishop
     */
    public Bishop(int x, int y, boolean isWhite) {
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
    	// Change in x == change in y
    	if (Math.abs(x - this.x) == Math.abs(y - this.y))
    		return true;
    	return false;
    }
    
}
