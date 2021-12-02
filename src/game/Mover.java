package game;

import java.util.*;

import pieces.*;

/**
 * Agent to manage the movement of pieces.
 */
public class Mover
{
    private static boolean isWhiteTurn;
    private static King whiteKing;
    private static King blackKing;
    private static MoveHistory history;

    /**
     * Constructs a mover.
     */
    public Mover() {

    }

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
        history = new MoveHistory();
    }

    /**
     * Moves a piece if the move follows the rules of chess.
     * @param piece - the piece to attempt to move
     * @param x - the column to attempt to move to
     * @param y - the row to attempt to move to
     * @return true if the piece moves successfully, and false otherwise
     */
    public static boolean tryMovePiece(Piece piece, int x, int y) {
        // is it appropriate player's turn?
        if (piece.isWhite() != isWhiteTurn) {
            return false;
        }

        // record initial position to store in history later
        List<Integer> start = new ArrayList<>();
        start.add(piece.getX());
        start.add(piece.getY());

        // if (isValidMove(...)) then move
        if (isValidMove(piece, x, y, true)) {

            if (tryMoveIsCastling(piece, x, y)) {
                int directionMoved = Integer.signum(x-piece.getX());
                int rookX = (directionMoved == 1 ? Board.getBoardArray().length - 1 : 0);
                Piece rook = Board.getPiece(rookX, y);
                Board.setPosition(piece, x, y);
                Board.setPosition(rook, x-directionMoved, y);
                Board.setPosition(null, rookX, y);
                Board.setPosition(null, start.get(0), start.get(1));
            }
            else if(tryMoveIsEnPassant(piece, x, y)) {
                Board.setPosition(piece, x, y);
                int removeX = history.getLastMove().getEnd().get(0);
                int removeY = history.getLastMove().getEnd().get(1);
                Board.setPosition(null, removeX, removeY);
                Board.setPosition(null, start.get(0), start.get(1));
            }
            else {   // vanilla case
                Board.setPosition(null, piece.getX(), piece.getY());
                Board.setPosition(piece, x, y);
            }
          
            isWhiteTurn = !isWhiteTurn;
            trySetHasMoved(piece);

            // add move to history
            List<Integer> end = new ArrayList<>();
            end.add(x);
            end.add(y);
            history.add(new Move(piece, piece.isWhite(), start, end));

            return true;
        }
        return false;
    }

    /**
     * Checks if a move is valid en passant.
     * @param piece - the piece to move
     * @param x - the destination column
     * @param y - the destination row
     * @return true if move is valid en passant, and false otherwise
     */
    private static boolean isValidEnPassant(Piece piece, int x, int y)
    {
        if (! (piece instanceof Pawn)) {
            return false;
        }

        int stepDirectionY = piece.isWhite() ? 1 : -1;

        // must be diagonal move of step size 1
        if (! (Math.abs(piece.getX() - x) == 1 && y - piece.getY() == stepDirectionY)) {
            return false;
        }

        // must not be first move of game
        if (history.size() == 0) {
            return false;
        }

        Move previousMove = history.getLastMove();
        Piece enemy = Board.getPiece(x, piece.getY());
        boolean validEnemyPosition = enemy != null && enemy.isWhite() != piece.isWhite();
        boolean emptyDestination = Board.getPiece(x, y) == null;
        boolean enemyIsPawn = enemy instanceof Pawn;
        boolean validPreviousMove = previousMove.getPiece() == enemy &&
                Math.abs(previousMove.getEnd().get(1) - previousMove.getStart().get(1)) == 2;

        return validEnemyPosition && emptyDestination && enemyIsPawn && validPreviousMove;
    }

    /**
     * Assuming that a move is valid, determines if the move is en passant.
     * Should not be called after changing state of board.
     * @param piece - the piece to move
     * @param x - the destination column
     * @param y - the destination row
     * @return true if move is en passant, and false otherwise
     */
    private static boolean tryMoveIsEnPassant(Piece piece, int x, int y) {
        // valid diagonal move to empty square implies en passant
        return (piece instanceof Pawn) && piece.getX() != x && Board.getPiece(x, y) == null;
    }


    /**
     * Checks if a move follows the rules of chess. Does not account for player turn.
     * @param piece - the piece to check a move for
     * @param x - the column to simulate a move to
     * @param y - the row to simulate a move to
     * @param accountForCheck - whether or not the method should ignore check
     * @return true if move follows the rules of chess, and false otherwise
     */
    public static boolean isValidMove(Piece piece, int x, int y, boolean accountForCheck) {

        boolean pieceIsWhite = piece.isWhite();
        King playerKing = pieceIsWhite ? whiteKing : blackKing;

        boolean isValidIncludingSpecialMoves = piece.isValidMove(x, y) ||
                isValidCastling(piece, x, y) || isValidEnPassant(piece, x, y);

        if (!isValidIncludingSpecialMoves) {
            return false;
        }

        if (!accountForCheck) {
            return true;
        }

        // store initial position and piece at destination
        int sourceX = piece.getX();
        int sourceY = piece.getY();
        Piece destinationPiece = Board.getBoardArray()[x][y];

        // carry out the move
        Board.setPosition(piece, x, y);
        Board.setPosition(null, sourceX, sourceY);

        // check if player's king is in check
        boolean isInCheck = playerKing.isInCheck();

        // undo move
        Board.setPosition(piece, sourceX, sourceY);
        Board.setPosition(destinationPiece, x, y);

        return !isInCheck;
    }
  
    /**
     * Checks if a move is valid castling.
     * @param piece - the piece to move
     * @param x - the destination column
     * @param y - the destination row
     * @return true if move is valid castling, and false otherwise
     */
    private static boolean isValidCastling(Piece piece, int x, int y) {
        boolean castling = false;
        Piece[][] boardArrCopy = Board.getBoardArray();

        if (!(piece instanceof King)) {
            return false;
        }

        King king = (King) piece;
        boolean kingIsWhite = king.isWhite();

        int deltaX = x - king.getX();
        int stepDirectionX = Integer.signum(deltaX);
        // if hasn't moved yet, and move in question is 2 cells only horizontal
        if (!king.hasMoved() && y == king.getY() && Math.abs(deltaX) == 2) {
            for (int i = king.getX() + stepDirectionX; i < boardArrCopy.length && i >= 0; i += stepDirectionX) {
                if (boardArrCopy[i][y] instanceof Rook) {
                    if (!((Rook) boardArrCopy[i][y]).hasMoved() && boardArrCopy[i][y].isWhite() == kingIsWhite) {
                        castling = true;
                    }
                }
                else if (boardArrCopy[i][y] != null) {
                    break;
                }
            }
        }

        return castling;
    }

    /**
     * Assuming that a move is valid, determines if the move is castling.
     * Should not be called after changing state of board.
     * @param piece - the piece to move
     * @param x - the destination column
     * @param y - the destination row
     * @return true if move is castling, and false otherwise
     */
    private static boolean tryMoveIsCastling(Piece piece, int x, int y) {
        int startX = piece.getX();
        return (piece instanceof King) && (Math.abs(x-startX) == 2);
    }
    
    
    /**
     * Does pawn promotion on the board, replacing the pawn on the board with what is given in the parameters
     * @param pawn is the pawn to be promoted
     * @param replacement is the type of piece to replace pawn
     * @return true if the promotion is successful, false otherwise (can be used to give the signal to view potentially)
     */
    private boolean pawnPromotion(Pawn pawn, Piece replacement)
    {
    	Piece[][] board = Board.getBoardArray();
    	if (pawn.isWhite() && pawn.getY() == board[0].length)
    	{
    		Board.setPosition(replacement, pawn.getX(), pawn.getY());
    	}
    	else if (!pawn.isWhite() && pawn.getY() == 0)
    	{
    		Board.setPosition(replacement, pawn.getX(), pawn.getY());
    	}
    	return false;
    }

    /**
     * Setter for piece's hasMoved field, if it has one.
     * @param piece - the piece to set hasMoved to true
     * @return - true if the piece's hasMoved is set to true
     */
    private static boolean trySetHasMoved(Piece piece) {
        if (piece instanceof Pawn) {
            ((Pawn) piece).setHasMoved();
            return true;
        }
        else if (piece instanceof Rook) {
            ((Rook) piece).setHasMoved();
            return true;
        }
        else if (piece instanceof King) {
            ((King) piece).setHasMoved();
            return true;
        }
        return false;
    }
    
    
    public static boolean isWhiteTurn()
    {
    	return isWhiteTurn;
    }


    public static boolean isInCheckmate(boolean forWhiteking) 
    {
        return forWhiteking ? whiteKing.isInCheckmate() : blackKing.isInCheckmate();
    }
    
    
    public static boolean lastMovePawnPromotion()
    {
    	Move move = history.getLastMove();
    	
    	if (move != null && move.getPiece() instanceof Pawn)
    	{
    		if (move.getEnd().get(1) == Board.getBoardArray()[0].length - 1 || move.getEnd().get(1) == 0)
    			return true;
    	}
    	return false;
    }
    
    
    public static MoveHistory getMoveHistory()
    {
    	return history;
    }
    
}
