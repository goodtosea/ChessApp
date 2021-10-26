package tests;
import pieces.Bishop;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BishopTests
{

	// Won't pass until Piece is implemented
	@Test
	void bishopValidMoveTest()
	{
		Bishop b = new Bishop(3, 8, true);
		assertEquals(b.isValidMove(4, 7), true);	// Up-right 1
		assertEquals(b.isValidMove(4, 8), false);	// Up 1 (invalid)
		assertEquals(b.isValidMove(5, 6), true);	// Up-right 2
		assertEquals(b.isValidMove(2, 7), true);	// Up-left 1
	}

}
