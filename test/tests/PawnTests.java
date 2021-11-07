package tests;
import game.Board;
import pieces.Pawn;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PawnTests
{

	@Test
	void normalMovementTest()
	{
		new Board();
		Board.setPosition(new Pawn(4, 1, true), 4, 1);
	}
	
	
	@Test
	void captureTest()
	{
		
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
