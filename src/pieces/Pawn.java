package pieces;

import game.Board;
import game.*;

/**
 * Chess piece that can move 1 cell forward (or 2 on its first move) and captures one cell diagonally forward.
 * It can also promote to any other piece if it reaches the other side of the board.
 */
public class Pawn extends Piece
{
    private boolean hasMoved;

    /**
     * Constructs a pawn and places it at a specified position on the board.
     * @param x - the column to place the pawn
     * @param y - the row to place the pawn
     */
    public Pawn(int x, int y, boolean isWhite) {
        super(x,y,isWhite);
        hasMoved = false;
    }

    /**
     * Getter method for x coordinate.
     * @return x the row of the piece
     */
    public int getX(){
        return x;
    }

    /**
     * Getter method for x coordinate.
     * @return x the row of the piece
     */
    public int getY(){
        return y;
    }

    /**
     * Checks if the piece can move in the specified way, not accounting for check or player turn.
     * Does not account for en passant.
     * @param x - the column to move to
     * @param y - the row to move to
     * @return true if the move is valid, and false otherwise
     */
    @Override
    public boolean isValidMove(int x, int y) {
        int stepDirectionY = isWhite ? 1 : -1;
        boolean noAllyAtDestination = Board.getPiece(x, y) == null || isWhite != Board.getPiece(x, y).isWhite();

        // diagonal move valid only if enemy present
        if (y - this.y == stepDirectionY && Math.abs(x - this.x) == 1) {
            return noAllyAtDestination && Board.getPiece(x, y) != null; // awkward phrasing but avoids null pointer
        }

        // step of 2 valid only if pawn hasn't moved and no obstacles
        if (y - this.y == stepDirectionY*2 && x == this.x) {
            boolean noObstacles = Board.getPiece(this.x, this.y + stepDirectionY) == null;
            return !hasMoved && noObstacles && noAllyAtDestination;
        }

        // step of 1
        if (y - this.y == stepDirectionY && x == this.x) {
            return noAllyAtDestination;
        }

        return false;
    }
    
    
    /**
     * Used for power moving
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
	 * Accessor for if Pawn has moved
	 * @return true if Pawn has moved, and false otherwise
	 */
	public boolean hasMoved() {
    	return hasMoved;
	}
	
}
