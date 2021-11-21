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
		assertEquals(false, b.isValidMove(2, 2));	// Same position
//		b.isValidMove(3, 3);
		assertEquals(true, 	b.isValidMove(3, 3));	// Up-right 1
		assertEquals(false, b.isValidMove(4, 4));
		assertEquals(false, b.isValidMove(2, 3));	// Up 1 (invalid)
		assertEquals(false, b.isValidMove(5, 5));	// Up-right 2
		assertEquals(false, b.isValidMove(6, 6));
		assertEquals(true, 	b.isValidMove(1, 3));	// Up-left 1
	}
}
