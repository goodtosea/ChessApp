package pieces;
import game.Board;

/**
 * Chess piece that moves and captures diagonally.
 */
public class Bishop extends Piece {
	
    /**
     * Constructs a bishop and places it at a specified position on the board.
     * @param x the column to place the bishop
     * @param y the row to place the bishop
     */
    public Bishop(int x, int y, boolean isWhite) {
        super(x, y, isWhite);
    }

    
    /**
     * Checks if the piece can move in the specified way, not accounting for check or player turn.
     * @param x the column to move to
     * @param y the row to move to
     * @return true if the move is valid, and false otherwise
     */
    @Override
    public boolean isValidMove(int x, int y) {
    	// Change in x == change in y and not in same position
    	int pathLength = Math.abs(x - this.x);
    	if (pathLength != Math.abs(y - this.y) || pathLength == 0) 
    		return false;
    	
    	// Determines the direction for the for loop that checks each space
    	int stepDirectionX = Integer.signum(x - this.x);
    	int stepDirectionY = Integer.signum(y - this.y);
    	
    	Piece[][] b = Board.getBoardArray();
    	
    	// Check that each cell between the start and end point is empty
    	for (int i = 1; i < pathLength; i++) {
    		int curr_x = this.x + stepDirectionX * i;
    		int curr_y = this.y + stepDirectionY * i;
    		
    		if (b[curr_x][curr_y] == null)
    			continue;
    		else
    			return false;
    	}
    	
    	// Check that if the end point is full, that it is the opposite color
    	// Board needs to be filled for the access to work
    	if (b[x][y] != null)
    		if (isWhite == b[x][y].isWhite())
    			return false;
    	
    	return true;
    }
    
}
