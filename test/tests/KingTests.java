package tests;

import game.*;
import pieces.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class KingTests
{

//   @Test
//    void isInCheckTest() {
//         Board board = new Board();
//         Board.fillBoard();
//         Piece[][] boardArr = Board.getBoardArray();
//         King whiteKing = (King) Board.getPiece(4, 0);

//         // remove pawns
//         for (int x = 0; x < 8; x++) {
//             Board.setPosition(null, x, 1);
//             Board.setPosition(null, x, 6);
//         }

//         assertFalse(whiteKing.isInCheck());

//         // move black queen to threaten white king
//         Board.setPosition(Board.getPiece(3,7), 4, 6);
//         Board.setPosition(null, 3, 7);

//         assertTrue(whiteKing.isInCheck());
//     }
  
	@Test
	void movementTest()
	{
		Board b = new Board();
		King k = new King(3, 3, true);
		Pawn p1 = new Pawn(3, 4, true);
		Pawn p2 = new Pawn(4, 4, false);
		Board.setPosition(k, 3, 3);
		Board.setPosition(p1, 3, 4);
		Board.setPosition(p2, 4, 4);
		assertEquals(true, k.isValidMove(2, 4));
		assertEquals(false, k.isValidMove(3, 4)); // Collide with white pawn
		assertEquals(true, k.isValidMove(4, 4)); // Capture black pawn
		assertEquals(true, k.isValidMove(4, 3));
		assertEquals(true, k.isValidMove(4, 2));
		assertEquals(true, k.isValidMove(3, 2));
		assertEquals(true, k.isValidMove(2, 2));
		assertEquals(true, k.isValidMove(2, 3));
		
		assertEquals(false, k.isValidMove(3, 3)); // Same position
		assertEquals(false, k.isValidMove(5, 5)); // Outside the king's range
	}
	
	
	@Test
	void checkTest()
	{
		Board b = new Board();
		King k = new King(3, 3, true);
		Pawn p1 = new Pawn(2, 4, false);
		King k2 = new King(7, 7, false);
		Mover m = new Mover(true, k, k);
		Board.setPosition(k, 3, 3);
		Board.setPosition(p1, 2, 4);
		Board.setPosition(k2, 7, 7);
		assertEquals(true, k.isInCheck());
		Board.setPosition(null, 2, 4);
		assertEquals(false, k.isInCheck());
	}
	
	
	@Test
	void checkMateTest()
	{
		Board b = new Board();
		King k = new King(2, 2, true);
		Mover m = new Mover(true, k, new King(7, 7, false));
		Bishop b1 = new Bishop(3, 5, false);
		Bishop b2 = new Bishop(4, 4, false);
		Bishop b3 = new Bishop(5, 3, false);
		Bishop b4 = new Bishop(4, 5, false);
		Bishop b5 = new Bishop(5, 4, false);
		Board.setPosition(k, 2, 2);
		
		assertEquals(false, k.isInCheckmate());
		
		Board.setPosition(b1, 3, 5);
		Board.setPosition(b2, 4, 4);
		
		assertEquals(false, k.isInCheckmate());
		
		Board.setPosition(b3, 5, 3);
		
		assertEquals(false, k.isInCheckmate());

		Board.setPosition(b4, 4, 5);
		Board.setPosition(b5, 5, 4);

		assertEquals(true, k.isInCheckmate());
	}
	
	
	@Test
	void castlingTest()
	{
		Board b = new Board();
		King k = new King(4, 0, true);
		Rook r = new Rook(0, 0, true);
		Mover m = new Mover(true, k, new King(7, 7, false));
		Board.setPosition(k, 4, 0);
		Board.setPosition(r, 0, 0);
		
		assertFalse(Mover.isValidMove(k, 0, 0, true));
		assertTrue(Mover.isValidMove(k, 2, 0, true));
		assertTrue(Mover.tryMovePiece(k, 2, 0));
		assertEquals(r, Board.getPiece(3, 0));
		assertEquals(k, Board.getPiece(2, 0));
	}
  
}
