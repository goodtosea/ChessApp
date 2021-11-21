package tests;
import game.*;
import pieces.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MoverTests
{

	@Test
	void testTryMovePiece()
	{
		Board b = new Board();
		King k1 = new King(4, 0, true);
		King k2 = new King(4, 7, false);
		Mover m = new Mover(true, k1, k2);
		
		Board.setPosition(k1, 4, 0);
		Board.setPosition(k2, 4, 7);
		
		// Tries moving the white king up one
		assertEquals(true, m.tryMovePiece(k1, 4, 1));
		assertEquals(k1, Board.getPiece(4, 1));
		
		// Wrong turn
		assertEquals(false, m.tryMovePiece(k1, 4, 2));
		
		// Move into check
		Bishop b1 = new Bishop(2, 4, true);
		Board.setPosition(b1, 2, 4);
		
		assertEquals(false, m.tryMovePiece(k2, 4, 6));
	}

}
