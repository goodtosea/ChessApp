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
		
//		b.isValidMove(2, 2);
		assertEquals(b.isValidMove(2, 2), false);	// Same position
//		b.isValidMove(3, 3);
		assertEquals(b.isValidMove(3, 3), true);	// Up-right 1
		assertEquals(b.isValidMove(2, 3), false);	// Up 1 (invalid)
		assertEquals(b.isValidMove(5, 5), true);	// Up-right 2
		assertEquals(b.isValidMove(1, 3), true);	// Up-left 1
	}
}
