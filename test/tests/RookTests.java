package tests;
import pieces.Rook;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RookTests
{

	// Won't pass until Piece is implemented
	@Test
	void rookValidMoveTest()
	{
		Rook r = new Rook(0, 8, true);
		assertEquals(r.isValidMove(4, 7), false);	// Up-right 1
		assertEquals(r.isValidMove(4, 8), true);	// Up 1 (invalid)
		assertEquals(r.isValidMove(5, 6), false);	// Up-right 2
		assertEquals(r.isValidMove(2, 7), false);	// Up-left 1
	}
}
