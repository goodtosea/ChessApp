package game;

import pieces.*;

/**
 * Agent to manage the movement of pieces.
 */
public class Mover
{
    private static boolean isWhiteTurn;
    private static King whiteKing;
    private static King blackKing;
    private MoveHistory Mhistory;

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
    }

    /**
     * Gets the Mhistory object of the MoveHistory class
     * @return the move history object
     */
    public MoveHistory getMhistory()
    {
        return Mhistory;
    }

    /**
     * Moves a piece if the move follows the rules of chess.
     * @param piece - the piece to attempt to move
     * @param x - the column to attempt to move to
     * @param y - the row to attempt to move to
     * @param promoteTo - the piece to convert the pawn to
     * @return true if the piece moves successfully, and false otherwise
     */
    public static boolean tryMovePiece(Piece piece, int x, int y) {
        List<Integer> start = new ArrayList<Integer>(); // TODO: Should only add the move if the move is going to happen
        start.add(piece.getX());
        start.add(piece.getY());
        if (isValidMove(piece, x, y)) {

            if (tryMoveIsCastling(piece, x, y)) {
                int directionMoved = Integer.signum(x-piece.getX());
                int rookX = (directionMoved == 1 ? Board.getBoardArray().length - 1 : 0);
                Piece rook = Board.getPiece(rookX, y);
                Board.setPosition(piece, x, y);
                Board.setPosition(rook, x-directionMoved, y);
                Board.setPosition(null, rookX, y);
            }
            // else if (moveIsEnPassant) ...
            // else if (pawnPromotion) ...
            else {   // vanilla case
                Board.setPosition(piece, x, y);
            }
          
            isWhiteTurn = !isWhiteTurn;
            List<Integer> end = new ArrayList<Integer>();
            end.add(x);
            end.add(y);
            Move lastMove = new Move(piece, start, end, piece.isWhite());
            Mhistory.storeMove(lastMove);
            
            return true;
        }
        return false;
    }


    /**
     * Checks if a move follows the rules of chess.
     * @param piece - the piece to check a move for
     * @param x - the column to simulate a move to
     * @param y - the row to simulate a move to
     * @return true if move follows the rules of chess, and false otherwise
     */
    public static boolean isValidMove(Piece piece, int x, int y) {

        boolean pieceIsWhite = piece.isWhite();
        King playerKing = pieceIsWhite ? whiteKing : blackKing;

        boolean isValidIncludingSpecialMoves = piece.isValidMove(x, y) || isValidCastling(piece, x, y) ;
        //      || isValidEnPassant(piece, x, y)

        if (pieceIsWhite != isWhiteTurn || !isValidIncludingSpecialMoves) {
            return false;
        }

        // store initial position and piece at destination
        int sourceX = piece.getX();
        int sourceY = piece.getY();
        Piece destinationPiece = Board.getBoardArray()[x][y];

        // carry out the move
        Board.setPosition(piece, x, y);

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
    
}
