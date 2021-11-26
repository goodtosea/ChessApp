package tests;
import game.*;
import pieces.King;
import pieces.Pawn;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PawnTests
{

	/**
	 * Checks that a pawn can move forward once
	 */
	@Test
	void normalMovementTest()
	{
		new Board();
		Pawn p = new Pawn(4, 1, true);
		Board.setPosition(p, 4, 1);
		assertEquals(true, p.isValidMove(4, 2));
	}
	
	
	/**
	 * Checks the pawn can capture another piece diagonally of the opposite color
	 */
	@Test
	void captureTest()
	{
		new Board();
		Pawn p1 = new Pawn(4, 1, true);
		Pawn p2 = new Pawn(5, 2, false);
		Pawn p3 = new Pawn(3, 2, true);
		Board.setPosition(p1, 4, 1);
		Board.setPosition(p2, 5, 2);
		Board.setPosition(p3, 3, 2);
		assertEquals(true, p1.isValidMove(5, 2));
		assertEquals(false, p1.isValidMove(3, 2));
	}
	
	
	/**
	 * Checks that a pawn can move twice only when hasMoved is false
	 */
	@Test
	void powerMoveTest()
	{
		new Board();
		Pawn p = new Pawn(4, 1, true);
		Board.setPosition(p, 4, 1);
		assertEquals(true, p.isValidMove(4, 3));
		p.setHasMoved();
		assertEquals(false, p.isValidMove(4, 3));
	}
	
	
	@Test
	void enPassantTest()
	{
		new Board();
		Pawn p1 = new Pawn(3, 3, true);
		Pawn p2 = new Pawn(2, 5, false); // Has just done the power move forward (black)
		Board.setPosition(p1, 3, 3);
		Board.setPosition(p2, 2, 5);
		p1.setHasMoved();

		Mover m = new Mover(false, new King(7, 7, true), new King(0, 7, false));
		assertTrue(Mover.tryMovePiece(p2, 2, 3));
		
		// Need a way to simulate a move
		assertTrue(Mover.isValidMove(p1, 2, 4, false));
		assertTrue(Mover.tryMovePiece(p1, 2, 4)); // TODO the pawn isValidMove has an error because it expects when you move diagonally for there to be a piece there (throws exception when trying to get isWhite on a null space)
		assertEquals(p1, Board.getPiece(2, 4));
		assertEquals(null, Board.getPiece(2, 3));
	}

}
