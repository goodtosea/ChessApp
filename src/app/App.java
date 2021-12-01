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
		
		Board board = new Board();
		Board.fillBoard();
		
		Mover mover = new Mover(true, (King) Board.getPiece(4, 0), (King) Board.getPiece(4, 7));
		
		BoardWindow board_window = new BoardWindow(queue);
		ChessController controller = new ChessController(queue, board_window);
		controller.mainLoop();
	}
}
