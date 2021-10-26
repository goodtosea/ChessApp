package tests;
import pieces.Queen;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class QueenTests
{

	// Won't pass until Piece is implemented
	@Test
	void queenValidMoveTest()
	{
		Queen q = new Queen(4, 8, true);
		assertEquals(q.isValidMove(4, 7), true);	// Up-right 1
		assertEquals(q.isValidMove(4, 8), true);	// Up 1
		assertEquals(q.isValidMove(5, 6), true);	// Up-right 2
		assertEquals(q.isValidMove(2, 7), true);	// Up-left 1
		assertEquals(q.isValidMove(0, 0), false);
	}

}
