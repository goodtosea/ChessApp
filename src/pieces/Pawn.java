package pieces;

/**
 * Chess piece that can move 1 cell forward (or 2 on its first move) and captures one cell diagonally forward.
 * It can also promote to any other piece if it reaches the other side of the board.
 */
public class Pawn extends Piece
{
    /**
     * Constructs a pawn and places it at a specified position on the board.
     * @param x - the column to place the pawn
     * @param y - the row to place the pawn
     */
    public Pawn(int x, int y) {
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
