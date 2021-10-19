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

        /**
         * White Pawns
         */
//        for(int j = 0; j < 8; j++)
//            boardArray[1][j] =

        /**
         * Black Pawns
         */
//        for(int j = 0; j < 8; j++)
//            boardArray[6][j] =

        /**
         * White Rooks
         */
//        for(int j = 0; j < 8; j = j + 7)
//            boardArray[0][j] =


        /**
         * Black Rooks
         */
//        for(int j = 0; j < 8; j = j + 7)
//            boardArray[7][j] =


        /**
         * White Knights
         */
//        for(int j = 1; j < 8; j = j + 5)
//            boardArray[0][j] =


        /**
         * Black Knights
         */
//        for(int j = 1; j < 8; j = j + 5)
//            boardArray[7][j] =

        /**
         * White Bishops
         */
//        for(int j = 2; j < 6; j = j + 3)
//            boardArray[0][j] =

        /**
         * Black Bishops
         */
//        for(int j = 2; j < 6; j = j + 3)
//            boardArray[7][j] =

        /**
         * White King
         */
//        boardArray[0][3] =

        /**
         * Black King
         */
//        boardArray[7][3] =

        /**
         * White Queen
         */
//        boardArray[0][4] =

        /**
         * Black Queen
         */
//        boardArray[7][4] =

    }

	
    /**
     * Sets the value of a cell in the board to a specified piece.
     * @param piece - the piece to set the cell's value to
     * @param x - the column of the cell
     * @param y - the row of the cell
     */
    public void setPosition(Piece piece, int x, int y) 
    {

    }

    
    /**
     * Fills the board with pieces in the standard chess layout.
     */
    public void fillboard() 
    {

    }
    
    
    /**
     * Getter method for the board 2D array
     * @return the 2D array with the board state
     */
    public Piece[][] getBoardArray()
    {
    	return boardArray;
    }
}