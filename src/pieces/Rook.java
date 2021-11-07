package pieces;

import game.Board;

/**
 * Chess piece that moves and captures horizontally and vertically.
 */
public class Rook extends Piece
{
	private boolean hasMoved;
	
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
    	if (x == this.x ^ y == this.y)
    	{
    		// Pick the change that's greatest (one will always be 0 in a legal move)
    		int deltaX = Math.abs(x - this.x);
        	int deltaY = Math.abs(y - this.y);
        	int pathLength = deltaX == 0 ? deltaY : deltaX;
        	
        	// No movement isn't a valid move
        	if (pathLength == 0)
        		return false;
        	
        	// Works when difference is 0
        	// Determines the direction for the for loop that checks each space
        	int stepDirectionX = Integer.signum(deltaX);
        	int stepDirectionY = Integer.signum(deltaY);
        	
        	Piece[][] b = Board.getBoardArray();
        	
        	// When one is 0, it doesn't get changed here
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

	/**
	 * Accessor for if Rook has moved
	 * @return true if Rook has moved, and false otherwise
	 */
	public boolean hasMoved() {
		return hasMoved;
	}
    
}
