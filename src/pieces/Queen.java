package pieces;
import game.Board;

/**
 * Chess piece that moves and captures diagonally, vertically, and horizontally.
 */
public class Queen extends Piece
{
	
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
    	// Copy pasted bishop move
    	if ((Math.abs(x - this.x) == Math.abs(y - this.y))) {
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
    	// Copy pasted rook logic
    	else if (x == this.x ^ y == this.y)
    	{
    		// Pick the change that's greatest (one will always be 0 in a legal move)
    		int deltaX = x - this.x;
        	int deltaY = y - this.y;
        	int pathLength = deltaX == 0 ? Math.abs(deltaY) : Math.abs(deltaX);
        	
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
    
}
