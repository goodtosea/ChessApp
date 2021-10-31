package pieces;

import java.util.ArrayList;

/**
 * An abstract chess piece.
 */
abstract class Piece
{
    private int x, y;
    private boolean isWhite;
    /**
     * Constructs a piece.
     */
    public Piece() {
        x = 0;
        y = 0;
        isWhite = true;

    }

    /**
     * Constructs a piece and places it at a specified position on the board.
     * @param x - the column to place the piece
     * @param y - the row to place the piece
     */
    public Piece(int x, int y, boolean isWhite) {
        this.x = x;
        this.y = y;
        this.isWhite = isWhite;
    }

    /**
     * Checks if the piece can move in the specified way, not accounting for check or player turn.
     * @param x - the column to move to
     * @param y - the row to move to
     * @return true if the move is valid, and false otherwise
     */
    abstract boolean isValidMove(int x, int y);
    abstract int getX();
    abstract int getY();
    public boolean isWhite()
    {
        return isWhite;
    }

    // should probably make a Position class that stores two integers, so that this returns ArrayList<Position>
    /**
     * Finds all the ways the piece can move, not accounting for check or player turn.
     * @return an ArrayList arr such that the valid moves are to the cells x=arr.get(2k), y=arr.get(2k+1) for integers k
     */
    public List<ArrayList<Integer>> findAllValidMoves()
    {
        List<ArrayList<Integer>> listRes = new List<ArrayList<Integer>>();
        int i = 0;
        while(i < boardArray.length)
        {
            int j = 0;
            while(j < boardArray.length)
            {
                ArrayList<Integer> li = new ArrayList<Integer>();
                if(isValidMove(i,j))
                {
                    li.add(i);
                    li.add(j);
                }
                j++;
                listRes.add(li);
            }
            i++;
        }
        return listRes;
    }
        // possible brute force: for each cell (x,y) on the board, call isValidMove(x,y)


}
