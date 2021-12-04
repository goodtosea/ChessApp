package pieces;

import game.Board;

/**
 * Chess piece that moves to and captures cells positioned at an L-like path from it,
 * specifically 2 rows and 1 column away, or 2 columns and 1 row away.
 */
public class Knight extends Piece
{
    /**
     * Constructs a knight and places it at a specified position on the board.
     * @param x the column to place the knight
     * @param y the row to place the knight
     * @param isWhite the color of the Knight
     */
    public Knight (int x, int y, boolean isWhite) {
        super(x,y,isWhite);
    }
    /**
     * Checks if the piece can move in the specified way, not accounting for check or player turn.
     * @param x the column to move to
     * @param y the row to move to
     * @return true if the move is valid, and false otherwise
     */
    @Override
    public boolean isValidMove(int x, int y) {
        if(Board.getPiece(x, y) == null || isWhite != Board.getPiece(x, y).isWhite())
        {
            if((y == this.y + 2 || y == this.y - 2) && (x == this.x + 1 || x == this.x - 1))
                return true;
            if((x == this.x + 2 || x == this.x -2) && (y == this.y + 1 || y == this.y - 1))
                return true;
        }
        return false;

    }
}
