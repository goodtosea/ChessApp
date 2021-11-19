package tests;
import game.*;
import pieces.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MoverTests {

    @Test
    void isValidMoveTest() {
        Board board = new Board();
        Board.fillBoard();
        King whiteKing = (King) Board.getPiece(4, 0);
        King blackKing = (King) Board.getPiece(4, 7);

        Mover mover = new Mover(true, whiteKing, blackKing);

        assertFalse(Mover.isValidMove(Board.getPiece(0,0), 0, 1)); // move bottom-left rook
        //assertTrue(Mover.isValidMove(Board.getPiece(0,1), 0, 2)); // move pawn

        // remove pawns
        for (int x = 0; x < 8; x++) {
            Board.setPosition(null, x, 1);
            Board.setPosition(null, x, 6);
        }

        assertTrue(Mover.isValidMove(Board.getPiece(0,0), 0, 1)); // move bottom-left rook

        // set up castling
        ((Rook) Board.getPiece(0,0)).setHasMoved();
        Board.setPosition(null, 1,0);
        Board.setPosition(null, 2,0);
        Board.setPosition(null, 3,0);
        Board.setPosition(null, 5,0);
        Board.setPosition(null, 6,0);
        assertFalse(Mover.isValidMove(Board.getPiece(4,0), 2, 0));
        assertFalse(Mover.isValidMove(Board.getPiece(4,0), 7, 0));
        assertTrue(Mover.isValidMove(Board.getPiece(4,0), 6, 0));
        ((King) Board.getPiece(4, 0)).setHasMoved();
        assertFalse(Mover.isValidMove(Board.getPiece(4,0), 6, 0));
    }
}
