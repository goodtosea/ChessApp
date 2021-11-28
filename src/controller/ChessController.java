package controller;

import pieces.Piece;
import view.*;
import game.*;

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
	 * @param x the row the piece is tried to move in
	 * @param y the column the piece is tried to move in
	 */
	public void tryMovePiece(int x, int y)
	{

		Mover.tryMovePiece(selectedPiece, x, y);
		selectedPiece = null;
		redrawBoard();
	}
	
	
	/**
	 * Highlights the valid moves of a piece on Board and sends the pieces up to the view
	 */
	public void tryHighlightValidMoves()
	{

	}
	
		
	/**
	 * Logic for what happens when a button is clicked
	 * Calls controller methods related to movement and simplifies the actionListener code for each button
	 */
	public void onSquareClick()
	{
		
	}
	
}
