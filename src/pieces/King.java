package pieces;

import java.util.*;

import game.Mover;

/**
 * Chess piece that can move to and capture the 8 cells adjacent to it.
 * When the king is inescapably threatened, its player loses.
 */
public class King extends Piece
{
    private boolean isChecked;

    /**
     * Constructs a king and places it at a specified position on the board.
     * @param x - the column to place the king
     * @param y - the row to place the king
     * @param isWhite - whether the piece is white
     */
    public King(int x, int y, boolean isWhite) {
        super(x, y, isWhite);
        isChecked = false;
    }

    /**
     * Checks if the piece can move in the specified way, not accounting for check or player turn.
     * @param x - the column to move to
     * @param y - the row to move to
     * @return true if the move is valid, and false otherwise
     */
    @Override
    public boolean isValidMove(int x, int y) {
        Piece[][] boardArrCopy = Board.getBoardArray();

        boolean xLessThan2 = Math.abs(x-this.x) < 2;
        boolean yLessThan2 = Math.abs(y-this.y) < 2;
        boolean bothNot0 = x != this.x && y != this.y;
        boolean destinationNotSameColor =
                boardArrCopy[x][y] == null ? true : boardArrCopy[x][y].isWhite() != this.isWhite;

        return xLessThan2 && yLessThan2 && bothNot0 && destinationNotSameColor;
    }

    /**
     * Checks if the king is in check.
     * @return true if the king is in check, and false otherwise
     */
    public boolean isInCheck() {
        // if true, then maybe call isInCheckmate().
    }

    /**
     * Checks for checkmate.
     * @return true if king is in checkmate, and false otherwise
     */
    private boolean isInCheckmate() {
        /*
        (1) is in check?
        (2) call findAllValidMoves() on every piece belonging to player
        (3) store all moves somehow
        (4) instantiate Mover class
        (5) loop through possible moves and call Mover's isValidMove() on each one
        (6) if one of the moves is valid, then return false. otherwise true
         */

        if (!isChecked) {
            return false;
        }

        Map<Piece, List<List<Integer>>> possibleMoves = everyPieceValidMoves();

        Mover mover = new Mover();
        Set<Piece> pieces = possibleMoves.keySet();

        // try to find at least one valid move, in which case return false
        for (Piece piece : pieces) {
            List<List<Integer>> pieceValidMoves = possibleMoves.get(piece);
            for (List<Integer> move : pieceValidMoves) {
                if (mover.isValidMove(piece, move.get(0), move.get(1)) == true) {
                    return false;
                }
            }
        }
        return true;

    }

    /**
     * Finds all valid moves of all pieces belonging to a player.
     * @return a map connecting each piece to a list of all its valid moves
     */
    private Map<Piece, List<List<Integer>>> everyPieceValidMoves() {
        Map<Piece, List<List<Integer>>> possibleMoves = new HashMap<>();

        // loop through board to find all of player's pieces
        Piece[][] boardArrCopy = Board.getBoardArray();
        Piece currPiece;
        for (int x = 0; x < boardArrCopy.length; x++) {
            for (int y = 0; y < boardArrCopy[0].length; y++) {

                // check if piece is right color, in which case call findAllValidMoves()
                currPiece = boardArrCopy[x][y];
                if (currPiece != null && currPiece.isWhite() == this.isWhite) {
                    possibleMoves.put(currPiece, currPiece.findAllValidMoves());
                }

            }
        }

        return possibleMoves;
    }

}
