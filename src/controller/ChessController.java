package controller;

import game.Board;
import pieces.Piece;
import view.BoardWindow;

import java.util.List;

public class ChessController
{
	
	private Piece selectedPiece; // Holds the piece we're currently operating on for logic in tryMovePiece and highlighting
	
	/**
	 * Redraws the view "board" given the properties of the model Board
	 */
	public void redrawBoard()
	{
		
	}
	
	
	/**
	 * Moves a piece in the model Board to a certain position and updates the view afterwards
	 * @param x
	 * @param y
	 */
	public void tryMovePiece(int x, int y)
	{
		
	}
	
	
	/**
	 * Highlights the valid moves of a piece on Board and sends the pieces up to the view
	 */
	public void tryHighlightValidMoves(int x, int y)
	{
		BoardWindow.highlightSquare(x, y);
		selectedPiece = Board.getPiece(x, y);
		List<List<Integer>> allValidMoves = selectedPiece.findAllValidMoves(true);
		for (List<Integer> move : allValidMoves) {
			BoardWindow.highlightSquare(move.get(0), move.get(1));
		}
	}
	
		
	/**
	 * Logic for what happens when a button is clicked
	 * Calls controller methods related to movement and simplifies the actionListener code for each button
	 */
	public void onSquareClick()
	{
		
	}
	
}
