package game;
import pieces.*;

/**
 * A 2D array of pieces.
 */
public class Board
{
    private static Piece boardArray[][];
    
    /**
     * Constructs an empty 8x8 board.
     */
	public Board() 
	{
		boardArray = new Piece[8][8];
    }

	
    /**
     * Sets the value of a cell in the board to a specified piece and updates the piece's current position.
     * @param piece - the piece to set the cell's value to
     * @param x - the column of the cell
     * @param y - the row of the cell
     */
    public static void setPosition(Piece piece, int x, int y)
    {
        boardArray[x][y] = piece;
        if (piece != null) {
            piece.setX(x);
            piece.setY(y);
        }
    }

    
    /**
     * Fills the board with pieces in the standard chess layout.
     */
    public static void fillBoard()
    {
        int firstPieceCol = (boardArray.length - 8) / 2;
        int topRow = boardArray[0].length - 1;

        // white pawns
        for (int j = firstPieceCol; j < firstPieceCol + 8; j++) {
            setPosition(new Pawn(j, 1, true), j, 1);
        }

        // black pawns
        for (int j = firstPieceCol; j < firstPieceCol + 8; j++) {
            setPosition(new Pawn(j, topRow - 1, false), j, topRow - 1);
        }

        // white rooks
        setPosition(new Rook(firstPieceCol, 0, true), firstPieceCol, 0);
        setPosition(new Rook(firstPieceCol + 7, 0, true), firstPieceCol + 7, 0);

        // black rooks
        setPosition(new Rook(firstPieceCol, topRow, false), firstPieceCol, topRow);
        setPosition(new Rook(firstPieceCol + 7, topRow, false), firstPieceCol + 7, topRow);

        // white knights
        setPosition(new Knight(firstPieceCol + 1, 0, true), firstPieceCol + 1, 0);
        setPosition(new Knight(firstPieceCol + 6, 0, true), firstPieceCol + 6, 0);

        // black knights
        setPosition(new Knight(firstPieceCol + 1, topRow, false), firstPieceCol + 1, topRow);
        setPosition(new Knight(firstPieceCol + 6, topRow, false), firstPieceCol + 6, topRow);

        // white bishops
        setPosition(new Bishop(firstPieceCol + 2, 0, true), firstPieceCol + 2, 0);
        setPosition(new Bishop(firstPieceCol + 5, 0, true), firstPieceCol + 5, 0);

        // black bishops
        setPosition(new Bishop(firstPieceCol + 2, topRow, false), firstPieceCol + 2, topRow);
        setPosition(new Bishop(firstPieceCol + 5, topRow, false), firstPieceCol + 5, topRow);

        // white queen
        setPosition(new Queen(firstPieceCol + 3, 0, true), firstPieceCol + 3, 0);

        // black queen
        setPosition(new Queen(firstPieceCol + 3, topRow, false), firstPieceCol + 3, topRow);

        // white king
        setPosition(new King(firstPieceCol + 4, 0, true), firstPieceCol + 4, 0);

        // black king
        setPosition(new King(firstPieceCol + 4, topRow, false), firstPieceCol + 4, topRow);

    }
    
    
    /**
     * Getter method for the board 2D array
     * @return the 2D array with the board state
     */
    public static Piece[][] getBoardArray()
    {
    	return boardArray.clone();
    }

  
    /**
     * Getter method for piece at specified location
     * @param x - the column of the board
     * @param y - the row of the board
     * @return the piece on the xth column and yth row of the board
     */
    public static Piece getPiece(int x, int y) {
        return boardArray[x][y];
    }
  
}
