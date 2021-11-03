package tests;
import pieces.Rook;
import game.Board;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RookTests
{

	// Won't pass until Piece is implemented
	@Test
	void rookValidMoveTest()
	{
		Rook r = new Rook(0, 7, true);
		Board b = new Board();
		assertEquals(r.isValidMove(4, 7), true);	// Right 4
		assertEquals(r.isValidMove(5, 6), false);	// Right 5 Down 2
		assertEquals(r.isValidMove(2, 7), true);	// Right 2 Down 1
	}
}
