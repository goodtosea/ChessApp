package controller;

import pieces.King;
import pieces.Piece;
import view.*;

import java.util.List;
import java.util.concurrent.BlockingQueue;

import game.*;

public class ChessController
{
	
	private Piece 					selectedPiece; // Holds the piece we're currently operating on for logic in tryMovePiece and highlighting
	private BlockingQueue<Message> 	queue;
	private View 			board_window;
	
	// Settings Variables
	private int boardWidth = 8;
	private int boardHeight = 8;
	
	
	public ChessController(BlockingQueue<Message> queue, View board_window)
	{
		this.queue 			= queue;
		this.board_window 	= board_window;
	}
	
	
	/**
	 * Redraws the view "board" given the properties of the model Board
	 */
	public void redrawBoard()
	{
		Piece[][] boardArrCopy = Board.getBoardArray();
		for (int x = 0; x < boardArrCopy.length; x++) {
			for (int y = 0; y < boardArrCopy[0].length; y++) {
				View.setIcon(View.iconForPiece(boardArrCopy[x][y]), x, y);
			}
		}
		board_window.paintBoard();
	}
	
	
	/**
	 * Moves a piece in the model Board to a certain position and updates the view afterwards
	 * @param x the row the piece is tried to move in
	 * @param y the column the piece is tried to move in
	 */
	public void tryMovePiece(int x, int y)
	{

		Mover.tryMovePiece(selectedPiece, x, y);
		selectedPiece = null;
		redrawBoard();
		System.out.println("white in checkmate: " + Mover.isInCheckmate(true));
		System.out.println("black in checkmate: " + Mover.isInCheckmate(false));
	}
	
	
	/**
	 * Highlights the valid moves of a piece on Board and sends the pieces up to the view
	 * @param x - column of square clicked
	 * @param y - row of square clicked
	 */
	public void tryHighlightValidMoves(int x, int y)
	{
		selectedPiece = Board.getPiece(x, y);
		
		if (selectedPiece == null) return;
		
		if (Mover.isWhiteTurn() != selectedPiece.isWhite()) 
		{
			selectedPiece = null;
			return;
		}

		View.highlightSquare(x, y);

		List<List<Integer>> allValidMoves = selectedPiece.findAllValidMoves(true);
		try {
			for (List<Integer> move : allValidMoves) {
				View.highlightSquare(move.get(0), move.get(1));
			}
		}
		catch (NullPointerException e) {
			// do nothing
		}
	}
	
		
	/**
	 * Logic for what happens when a button is clicked
	 * Calls controller methods related to movement and simplifies the actionListener code for each button
	 * @param x - column of square clicked
	 * @param y - row of square clicked
	 */
	public void onSquareClick(int x, int y)
	{
		if (selectedPiece == null) {
			tryHighlightValidMoves(x, y);
		}
		else {
			tryMovePiece(x, y);
		}
	}
	
	
	public void mainLoop()
	{
//		
		
		while (board_window.isDisplayable())
		{
			Message message = null;
			try
			{
				message = queue.take();
			}
			catch (InterruptedException e)
			{
				
			}
			
			if (message.getClass() == OnSquareClickMessage.class)
			{
				OnSquareClickMessage osqm = (OnSquareClickMessage) message;
				this.onSquareClick(osqm.getX(), osqm.getY());
			}
			else if (message.getClass() == PlayGameMessage.class)
			{
				Board board = new Board(boardWidth, boardHeight);
				Board.fillBoard();

				int firstPieceCol = (Board.getBoardArray().length - 8) / 2;
				int topRow = Board.getBoardArray()[0].length - 1;
				King whiteKing = (King) Board.getPiece(firstPieceCol + 4, 0);
				King blackKing = (King) Board.getPiece(firstPieceCol + 4, topRow);
				
				Mover mover = new Mover(true, whiteKing, blackKing);
				
				board_window.panelDraw(boardWidth, boardHeight);
				board_window.paintBoard();
				this.redrawBoard();
			}
			else if (message.getClass() == ApplySettingsMessage.class)
			{
				ApplySettingsMessage apply = (ApplySettingsMessage) message;
				boardWidth 	= apply.getboardWidth();
				boardHeight = apply.getboardHeight();
			}
		}
	}
	
}
