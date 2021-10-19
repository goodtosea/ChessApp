package tests;
import game.Board;
import pieces.Piece;

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
		Board b = new Board();
		for (Piece[] col : b.getBoardArray())
			for (Piece p : col)
				assertNull(p);
	}
}
