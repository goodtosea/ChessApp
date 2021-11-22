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

  
    @Test
    void isValidMoveTest() {
        Board board = new Board();
        Board.fillBoard();
        King whiteKing = (King) Board.getPiece(4, 0);
        King blackKing = (King) Board.getPiece(4, 7);

        Mover mover = new Mover(true, whiteKing, blackKing);

//        assertFalse(Mover.isValidMove(Board.getPiece(0,0), 0, 1)); // move bottom-left rook
//        //assertTrue(Mover.isValidMove(Board.getPiece(0,1), 0, 2)); // move pawn
//
//        // remove pawn above rook
//        Board.setPosition(null, 0, 1);
//        assertTrue(Mover.isValidMove(Board.getPiece(0,0), 0, 1)); // move bottom-left rook
//
//        // set up castling
//        ((Rook) Board.getPiece(0,0)).setHasMoved();
//        Board.setPosition(null, 1,0);
//        Board.setPosition(null, 2,0);
//        Board.setPosition(null, 3,0);
//        Board.setPosition(null, 5,0);
//        Board.setPosition(null, 6,0);
//        assertFalse(Mover.isValidMove(Board.getPiece(4,0), 2, 0));
//        assertFalse(Mover.isValidMove(Board.getPiece(4,0), 7, 0));
//        assertTrue(Mover.isValidMove(Board.getPiece(4,0), 6, 0));
//        ((King) Board.getPiece(4, 0)).setHasMoved();
//        assertFalse(Mover.isValidMove(Board.getPiece(4,0), 6, 0));
    }
  
}
