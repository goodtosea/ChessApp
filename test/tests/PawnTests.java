package tests;
import game.Board;
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
		assertEquals(true, p1.isValidMove(5, 2));
		assertEquals(false, p1.isValidMove(3, 2));
	}
	
	
	@Test
	void powerMoveTest()
	{
		
	}
	
	
	@Test
	void enPassantTest()
	{
		
	}

}
