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
    public boolean tryMovePiece(Piece piece, int x, int y, Piece promoteTo) {
        List<Integer> start = new ArrayList<Integer>();
        start.add(piece.getX());
        start.add(piece.getY());

        // if (isValidMove(...)) then move
        if (isValidMove(piece, x, y)) {

            Board.setPosition(piece, x, y);
            isWhiteTurn = !isWhiteTurn;
            List<Integer> end = new ArrayList<Integer>();
            end.add(x);
            end.add(y);
            Move lastMove = new Move(piece, start, end, piece.isWhite());
            Mhistory.storeMove(lastMove);

            if(piece instanceof Pawn)
            {
                if(piece.isEnPassantPossible())
                {
                    int removeX = Mhistory.getHistory().get(history.getHistory().size() - 2).getEnd().get(0);
                    int removeY = Mhistory.getHistory().get(history.getHistory().size() - 2).getEnd().get(1);
                    Board.setPosition(null, removeX, removeY);
                }
                
                pawnPromotion((Pawn) piece, promoteTo);
            }
            
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
    public boolean isValidMove(Piece piece, int x, int y) {

        boolean pieceIsWhite = piece.isWhite();
        King playerKing = pieceIsWhite ? whiteKing : blackKing;

        if (pieceIsWhite != isWhiteTurn || ! piece.isValidMove(x,y)) {
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
