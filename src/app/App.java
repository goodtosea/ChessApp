package app;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import controller.*;
import game.*;
import pieces.*;
import view.*;

public class App
{
	public static void main(String[] args)
	{
		BlockingQueue<Message> queue = new LinkedBlockingQueue<>();

		// between 8 and 16 for now
//		int boardWidth = 16;
//		int boardHeight = 16;
//		
//		Board board = new Board(boardWidth, boardHeight);
//		Board.fillBoard();
//
//		int firstPieceCol = (Board.getBoardArray().length - 8) / 2;
//		int topRow = Board.getBoardArray()[0].length - 1;
//		King whiteKing = (King) Board.getPiece(firstPieceCol + 4, 0);
//		King blackKing = (King) Board.getPiece(firstPieceCol + 4, topRow);
//		
//		Mover mover = new Mover(true, whiteKing, blackKing);

//		View view = new View(queue, boardWidth, boardHeight);
		View view = new View(queue);
		ChessController controller = new ChessController(queue, view);
		controller.mainLoop();
	}
}
