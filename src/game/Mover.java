package game;

import pieces.*;

/**
 * Agent to manage the movement of pieces.
 */
public class Mover
{
    boolean isWhiteTurn;
    King whiteKing;
    King blackKing;

    /**
     * Constructs a mover.
     * @param isWhiteTurn - the current turn
     * @param whiteKing - the white king
     * @param blackKing - the black king
     */
    public Mover(boolean isWhiteTurn, King whiteKing, King blackKing) {
        this.isWhiteTurn = isWhiteTurn;
        this.whiteKing = whiteKing;
        this.blackKing = blackKing;
    }

    /**
     * Moves a piece if the move follows the rules of chess.
     * @param piece - the piece to attempt to move
     * @param x - the column to attempt to move to
     * @param y - the row to attempt to move to
     * @return true if the piece moves successfully, and false otherwise
     */
    protected boolean tryMovePiece(Piece piece, int x, int y) {
        // if (isValidMove(...)) then move
        if (isValidMove(piece, x, y)) {
            Board.setPosition(piece, x, y);
            isWhiteTurn = !isWhiteTurn;
            return true;
        }
        return false;
    }

    /**
     * Checks if a move follows the rules of chess.
     * @param piece - the piece to check a move for
     * @param x - the column to simulate a move to
     * @param y - the row to simulate a move to
     * @return
     */
    public boolean isValidMove(Piece piece, int x, int y) {
        /*
           check:
           (1) if the specific piece can move that way,
           (2) if it is the appropriate player's turn,
           (3) if the player's king is in check.
         */

        boolean pieceIsWhite = piece.isWhite();
        King playerKing = pieceIsWhite ? whiteKing : blackKing;

        if (pieceIsWhite == isWhiteTurn && piece.isValidMove(x,y)) {

            // if current player's king is not in check
            if (!playerKing.isInCheck()) {
                return true;
            }
            else {
                // store initial position and piece at destination
                int sourceX = piece.getX();
                int sourceY = piece.getY();
                Piece destinationPiece = Board.getBoardArray()[x][y];

                // carry out the move
                Board.setPosition(piece, x, y);

                // check if player's king is still in check
                boolean stillInCheck = playerKing.isInCheck();

                // undo move
                Board.setPosition(piece, sourceX, sourceY);
                Board.setPosition(destinationPiece, x, y);

                return !stillInCheck;
            }

        }


    }

}
