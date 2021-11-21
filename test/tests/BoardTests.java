package tests;
import game.Board;
import pieces.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BoardTests
{
	/**
	 * Checks if the board is correctly initialized empty
	 */
	@Test
	void boardCtorTest()
	{
		new Board();
		for (Piece[] col : Board.getBoardArray())
			for (Piece p : col)
				assertNull(p);
	}
	
	
	/**
	 * Checks that fillBoard fills the board correctly (default size)
	 */
	@Test
	void fillBoardTest()
	{
		new Board();
		Board.fillBoard();
		Piece[][] p = Board.getBoardArray();
		assertEquals(Rook.class, 	p[0][0].getClass());
		assertEquals(Knight.class, 	p[1][0].getClass());
		assertEquals(Bishop.class, 	p[2][0].getClass());
		assertEquals(Queen.class, 	p[3][0].getClass());
		assertEquals(King.class, 	p[4][0].getClass());
		assertEquals(Bishop.class, 	p[5][0].getClass());
		assertEquals(Knight.class, 	p[6][0].getClass());
		assertEquals(Rook.class, 	p[7][0].getClass());
		
		for (int i = 0; i < 8; i++)
		{
			assertEquals(Pawn.class, p[i][1].getClass());
			assertEquals(Pawn.class, p[i][6].getClass());
		}
		
		assertEquals(Rook.class, 	p[0][7].getClass());
		assertEquals(Knight.class, 	p[1][7].getClass());
		assertEquals(Bishop.class, 	p[2][7].getClass());
		assertEquals(Queen.class, 	p[3][7].getClass());
		assertEquals(King.class, 	p[4][7].getClass());
		assertEquals(Bishop.class, 	p[5][7].getClass());
		assertEquals(Knight.class, 	p[6][7].getClass());
		assertEquals(Rook.class, 	p[7][7].getClass());
	}
	
	
	/**
	 * Clone test for changed instance variables
	 */
	@Test
	void cloneInstanceVariableTest()
	{
		new Board();
		Board.fillBoard();
		Piece p = Board.getPiece(0,0);
		Rook r = (Rook) p;
		r.setHasMoved();
		Piece[][] board = Board.getBoardArray();
		assertEquals(true, ((Rook) board[0][0]).hasMoved());
	}
}
