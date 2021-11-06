package tests;
import pieces.Queen;
import game.Board;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class QueenTests
{

	// Won't pass until Piece is implemented
	@Test
	void queenValidMoveTest()
	{
		Queen q = new Queen(4, 8, true);
		Board b = new Board();
		assertEquals(q.isValidMove(4, 7), true);	// Down 1
		assertEquals(q.isValidMove(4, 8), false);	// Same position
		assertEquals(q.isValidMove(2, 7), false);	// Left 2 Down 1
		assertEquals(q.isValidMove(0, 0), false);
	}

}
