package tests;
import game.*;
import pieces.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class KnightTests
{

	@Test
	void movementTest()
	{
		new Board();
		Knight k = new Knight(3, 4, true);
		Pawn p = new Pawn(2, 6, true);
		Board b = new Board();
		Board.setPosition(k, 3, 4);
		Board.setPosition(p, 2, 6);
		assertEquals(false, k.isValidMove(2, 6));
		assertEquals(true, k.isValidMove(4, 6));
		assertEquals(false, k.isValidMove(2, 5));
	}

}
