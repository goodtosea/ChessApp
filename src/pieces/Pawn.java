package pieces;

import game.Board;
import game.*;

/**
 * Chess piece that can move 1 cell forward (or 2 on its first move) and captures one cell diagonally forward.
 * It can also promote to any other piece if it reaches the other side of the board.
 */
public class Pawn extends Piece, MoveHistory
{

    private boolean hasMoved;
    private boolean enPassantPossible;
    Mover mv = new Mover();
    Piece[][] p = Board.getBoardArray();
    /**
     * Constructs a pawn and places it at a specified position on the board.
     * @param x - the column to place the pawn
     * @param y - the row to place the pawn
     */
    public Pawn(int x, int y, boolean isWhite) {
        super(x,y,isWhite);
        hasMoved = false;
        enPassantPossible = false;
    }

    /**
     * Checks if the En Passant is Possible.
     * @return true is En Passant is Possible, else false
     */
    public boolean isEnPassantPossible() {
        return enPassantPossible;
    }

    /**
     * Checks if the piece can move in the specified way, not accounting for check or player turn.
     * @param x - the column to move to
     * @param y - the row to move to
     * @return true if the move is valid, and false otherwise
     */
    @Override
    public boolean isValidMove(int x, int y) {

        enPassantPossible = false;

        if(isWhite)
        {
            if((x == this.x + 1 && y == this.y + 1) || (x == this.x - 1 && y == this.y + 1))
                if(isWhite != p[x][y].isWhite())
                    return true;

            if(!mv.getHistory().getLastMove().isPawn().isWhite())
            {
                Move previousMove = mv.getHistory().getLastMove();
                if(previousMove.getEnd().get(1) - previousMove.getStart().get(1) == -2)
                {
                    if(previousMove.getEnd().get(1) == this.y)
                    {
                        if(this.x == previousMove.getEnd().get(0) - 1)
                        {
                            if(x == previousMove.getEnd().get(0) && y == previousMove.getEnd().get(1) + 1)
                            {
                                enPassantPossible = true;
                                return true;
                            }

                        }
                        if(this.x == previousMove.getEnd().get(0) + 1)
                        {
                            if(x == previousMove.getEnd().get(0) && y == previousMove.getEnd().get(1) + 1)
                            {
                                enPassantPossible = true;
                                return true;
                            }
                        }
                    }
                }

            }

            if(!hasMoved)
            {
                if(x == this.x && y == this.y + 1 && p[x][y] == null)
                {
                    hasMoved = true;
                    return true;
                }

                if(x == this.x && y == this.y + 2 && p[x][y-1] == null && p[x][y] == null)
                {
                    hasMoved = true;
                    return true;
                }
            }

            else
            {
                if(y == this.y + 1 && x == this.x && p[x][y] == null)
                    return true;
            }
            return false;
        }


        else
        {
            if((x == this.x + 1 && y == this.y - 1) || (x == this.x - 1 && y == this.y - 1))
                if(isWhite != p[x][y].isWhite())
                    return true;

            if(mv.getHistory().getLastMove().isPawn().isWhite())
            {
                Move previousMove = mv.getHistory().getLastMove();
                if(previousMove.getEnd().get(1) - previousMove.getStart().get(1) == 2)
                {
                    if(previousMove.getEnd().get(1) == this.y)
                    {
                        if(this.x == previousMove.getEnd().get(0) - 1)
                        {
                            if(x == previousMove.getEnd().get(0) && y == previousMove.getEnd().get(1) - 1)
                            {
                                enPassantPossible = true;
                                return true;
                            }
                        }
                        if(this.x == previousMove.getEnd().get(0) + 1)
                        {
                            if(x == previousMove.getEnd().get(0) && y == previousMove.getEnd().get(1) - 1)
                            {
                                enPassantPossible = true;
                                return true;
                            }
                        }
                    }
                }

            }

            if(!hasMoved)
            {
                if(x == this.x && y == this.y - 1 && p[x][y] == null)
                {
                    hasMoved = true;
                    return true;
                }

                if(x == this.x && y == this.y - 2 && p[x][y+1] == null && p[x][y] == null)
                {
                    hasMoved = true;
                    return true;
                }
            }

            else
            {
                if(y == this.y - 1 && x == this.x && p[x][y] == null)
                    return true;
            }
            return false;
        }



    }
}
