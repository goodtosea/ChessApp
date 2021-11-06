package pieces;

import game.Board;

import java.util.ArrayList;
import java.util.List;

/**
 * An abstract chess piece.
 */
public abstract class Piece
{
    protected int x, y;
    protected boolean isWhite;
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
    public abstract boolean isValidMove(int x, int y);
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public boolean isWhite(){
        return isWhite;
    }

    /**
     * Finds all the ways the piece can move, not accounting for check or player turn.
     * @return an ArrayList arr such that the valid moves are to the cells x=arr.get(2k), y=arr.get(2k+1) for integers k
     */
    public List<List<Integer>> findAllValidMoves()
    {
        List<List<Integer>> listRes = new ArrayList<List<Integer>>();
        int i = 0;
        while(i < Board.getBoardArray().length)
        {
            int j = 0;
            while(j < Board.getBoardArray().length)
            {
                List<Integer> li = new ArrayList<Integer>();
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

}
