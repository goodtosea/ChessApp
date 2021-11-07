package pieces;

import java.util.*;

import game.*;

/**
 * Chess piece that can move to and capture the 8 cells adjacent to it.
 * When the king is inescapably threatened, its player loses.
 */
public class King extends Piece
{
    private boolean hasMoved;

    /**
     * Constructs a king and places it at a specified position on the board.
     * @param x - the column to place the king
     * @param y - the row to place the king
     * @param isWhite - whether the piece is white
     */
    public King(int x, int y, boolean isWhite) {
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
        Piece[][] boardArrCopy = Board.getBoardArray();

        boolean xLessThan2 = Math.abs(x-this.x) < 2;
        boolean yLessThan2 = Math.abs(y-this.y) < 2;
        boolean bothNot0 = x != this.x && y != this.y;
        boolean destinationNotSameColor =
                boardArrCopy[x][y] == null ? true : boardArrCopy[x][y].isWhite() != this.isWhite;

        boolean castling = false;
        int deltaX = Integer.signum(x-this.x);
        // if hasn't moved yet, and move in question is 2 cells horizontal
        if (!hasMoved && y == this.y && Math.abs(deltaX) == 2) {
            for (int i = this.x + deltaX; i < boardArrCopy.length && i >= 0; i += deltaX) {
                if (boardArrCopy[i][y] instanceof Rook) {
                    if (((Rook) boardArrCopy[i][y]).hasMoved() && boardArrCopy[i][y].isWhite()) {
                        castling = true;
                    }
                }
                else if (boardArrCopy[i][y] != null) {
                    break;
                }
            }
        }

        return (xLessThan2 && yLessThan2 && bothNot0 && destinationNotSameColor) || castling;
    }

    /**
     * Checks if the king is in check.
     * @return true if the king is in check, and false otherwise
     */
    public boolean isInCheck() {
        Map<Piece, List<List<Integer>>> allEnemyMoves = everyPieceValidMoves(!isWhite);
        Set<Piece> enemyPieces = allEnemyMoves.keySet();

        // try to find one move with King's position as destination, in which case return true
        for (Piece piece : enemyPieces) {
            List<List<Integer>> moves = allEnemyMoves.get(piece);
            for (List<Integer> move : moves) {
                if (move.get(0) == x && move.get(1) == y) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks for checkmate.
     * @return true if king is in checkmate, and false otherwise
     */
    private boolean isInCheckmate() {
        Map<Piece, List<List<Integer>>> possibleMoves = everyPieceValidMoves(isWhite);

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
    private Map<Piece, List<List<Integer>>> everyPieceValidMoves(boolean onlyWhitePieces) {
        Map<Piece, List<List<Integer>>> possibleMoves = new HashMap<>();

        // loop through board to find all of player's pieces
        Piece[][] boardArrCopy = Board.getBoardArray();
        Piece currPiece;
        for (int x = 0; x < boardArrCopy.length; x++) {
            for (int y = 0; y < boardArrCopy[0].length; y++) {

                // check if piece is right color, in which case call findAllValidMoves()
                currPiece = boardArrCopy[x][y];
                if (currPiece != null && currPiece.isWhite() == onlyWhitePieces) {
                    possibleMoves.put(currPiece, currPiece.findAllValidMoves());
                }

            }
        }

        return possibleMoves;
    }

}
