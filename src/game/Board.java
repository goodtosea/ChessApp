package game;
import pieces.*;

/**
 * A 2D array of pieces.
 */
public class Board
{
    private Piece boardArray[][];
    
    /**
     * Constructs an empty 8x8 board.
     */
	public Board() 
	{
		boardArray = new Piece[8][8];
    }

	
    /**
     * Sets the value of a cell in the board to a specified piece.
     * @param piece - the piece to set the cell's value to
     * @param x - the column of the cell
     * @param y - the row of the cell
     */
    public void setPosition(Piece piece, int x, int y) 
    {
        boardArray[x][y] = piece;
    }

    
    /**
     * Fills the board with pieces in the standard chess layout.
     */
    public void fillboard()
    {
        int firstPieceCol = (boardArray.length - 8) / 2;
        int topRow = boardArray[0].length - 1;

        // white pawns
        for (int j = firstPieceCol; j < firstPieceCol + 8; j++) {
            setPosition(new Pawn(j, 1), j, 1);
        }

        // black pawns
        for (int j = firstPieceCol; j < firstPieceCol + 8; j++) {
            setPosition(new Pawn(j, topRow - 1), j, topRow - 1);
        }

        // white rooks
        setPosition(new Rook(firstPieceCol, 0), firstPieceCol, 0);
        setPosition(new Rook(firstPieceCol + 7, 0), firstPieceCol + 7, 0);

        // black rooks
        setPosition(new Rook(firstPieceCol, topRow), firstPieceCol, topRow);
        setPosition(new Rook(firstPieceCol + 7, topRow) firstPieceCol + 7, topRow);

        // white knights
        setPosition(new Knight(firstPieceCol + 1, 0), firstPieceCol + 1, 0);
        setPosition(new Knight(firstPieceCol + 6, 0), firstPieceCol + 6, 0);

        // black knights
        setPosition(new Knight(firstPieceCol + 1, topRow), firstPieceCol + 1, topRow);
        setPosition(new Knight(firstPieceCol + 6, topRow), firstPieceCol + 6, topRow);

        // white bishops
        setPosition(new Bishop(firstPieceCol + 2, 0), firstPieceCol + 2, 0);
        setPosition(new Bishop(firstPieceCol + 5, 0), firstPieceCol + 5, 0);

        // black bishops
        setPosition(new Bishop(firstPieceCol + 2, topRow), firstPieceCol + 2, topRow);
        setPosition(new Bishop(firstPieceCol + 5, topRow), firstPieceCol + 5, topRow);

        // white queen
        setPosition(new Queen(firstPieceCol + 3, 0), firstPieceCol + 3, 0);

        // black queen
        setPosition(new Queen(firstPieceCol + 3, topRow), firstPieceCol + 3, topRow);

        // white king
        setPosition(new Queen(firstPieceCol + 4, 0), firstPieceCol + 4, 0);

        // black king
        setPosition(new Queen(firstPieceCol + 4, topRow), firstPieceCol + 4, topRow);

    }
    
    
    /**
     * Getter method for the board 2D array
     * @return the 2D array with the board state
     */
    public Piece[][] getBoardArray()
    {
    	return boardArray.clone();
    }
}