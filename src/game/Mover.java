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
     * @return true if the piece moves successfully, and false otherwise
     */
    protected boolean tryMovePiece(Piece piece, int x, int y) {
        List<Integer> start = new ArrayList<Integer>();
        start.add(piece.getX());
        start.add(piece.getY());

        if(piece instanceof Pawn)
        {
            if(tryMoveIsEnPassantPossible(piece, x, y))
            {
                Board.setPosition(piece, x, y);
                List<Integer> end = new ArrayList<Integer>();
                end.add(x);
                end.add(y);
                int removeX = Mhistory.getHistory().get(history.getHistory().size() - 2).getEnd().get(0);
                int removeY = Mhistory.getHistory().get(history.getHistory().size() - 2).getEnd().get(1);
                Board.setPosition(null, removeX, removeY);
                Move lastMove = new Move(piece, start, end, piece.isWhite());
                Mhistory.storeMove(lastMove);
                return true;
            }

        }
        
        // if (isValidMove(...)) then move
        if (isValidMove(piece, x, y)) {

            Board.setPosition(piece, x, y);
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

    public boolean tryMoveIsEnPassantPossible(Piece piece, int x, int y)
    {
        Move previousMove = Mhistory.getLastMove();

        if(previousMove.isPawn() && !previousMove.isWhite())
        {
            if(previousMove.getEnd().get(1) - previousMove.getStart().get(1) == -2) {
                if (previousMove.getEnd().get(1) == piece.getY()) {
                    if (piece.getX() == previousMove.getEnd().get(0) - 1) {
                        if (x == previousMove.getEnd().get(0) && y == previousMove.getEnd().get(1) + 1) {

                            return true;
                        }

                    }
                    if (piece.getX() == previousMove.getEnd().get(0) + 1) {
                        if (x == previousMove.getEnd().get(0) && y == previousMove.getEnd().get(1) + 1) {

                            return true;
                        }
                    }
                }
            }
        }

        if(previousMove.isPawn().isWhite()) {
//            Move previousMove = mv.getMhistory().getLastMove();
            if (previousMove.getEnd().get(1) - previousMove.getStart().get(1) == 2) {
                if (previousMove.getEnd().get(1) == piece.getY()) {
                    if (piece.getX() == previousMove.getEnd().get(0) - 1) {
                        if (x == previousMove.getEnd().get(0) && y == previousMove.getEnd().get(1) - 1) {

                            return true;
                        }
                    }
                    if (piece.getX() == previousMove.getEnd().get(0) + 1) {
                        if (x == previousMove.getEnd().get(0) && y == previousMove.getEnd().get(1) - 1) {

                            return true;
                        }
                    }
                }
            }
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

}
