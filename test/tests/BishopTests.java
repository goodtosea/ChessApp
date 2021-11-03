package tests;
import pieces.Bishop;
import game.Board;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BishopTests
{

	// Won't pass until Piece is implemented
	@Test
	void bishopValidMoveTest()
	{
		Bishop b = new Bishop(2, 2, true);
		Board board = new Board();
		Board.setPosition(b, 2, 2);
		Board.setPosition(new Bishop(4, 4, true), 4, 4);
		Board.setPosition(new Bishop(6, 6, false), 6, 6);
		
//		b.isValidMove(2, 2);
		assertEquals(b.isValidMove(2, 2), false);	// Same position
//		b.isValidMove(3, 3);
		assertEquals(b.isValidMove(3, 3), true);	// Up-right 1
		assertEquals(b.isValidMove(4, 4), false);
		assertEquals(b.isValidMove(2, 3), false);	// Up 1 (invalid)
		assertEquals(b.isValidMove(5, 5), false);	// Up-right 2
		assertEquals(b.isValidMove(6, 6), true);
		assertEquals(b.isValidMove(1, 3), true);	// Up-left 1
	}
}
