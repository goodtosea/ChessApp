package tests;

import game.*;
import pieces.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class KingTests {

    @Test
    void isInCheckTest() {
        Board board = new Board();
        Board.fillBoard();
        Piece[][] boardArr = Board.getBoardArray();
        King whiteKing = (King) Board.getPiece(4, 0);

        // remove pawns
        for (int x = 0; x < 8; x++) {
            Board.setPosition(null, x, 1);
            Board.setPosition(null, x, 6);
        }

        assertFalse(whiteKing.isInCheck());

        // move black queen to threaten white king
        Board.setPosition(Board.getPiece(3,7), 4, 6);
        Board.setPosition(null, 3, 7);

        assertTrue(whiteKing.isInCheck());
    }
}
