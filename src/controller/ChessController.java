package controller;

import game.Board;
import pieces.*;
import view.BoardWindow;

import javax.swing.*;

public class ChessController
{
	
	private Piece selectedPiece; // Holds the piece we're currently operating on for logic in tryMovePiece and highlighting
	
	/**
	 * Redraws the view "board" given the properties of the model Board
	 */
	public void redrawBoard()
	{
		Piece[][] boardArrCopy = Board.getBoardArray();
		for (int x = 0; x < boardArrCopy.length; x++) {
			for (int y = 0; y < boardArrCopy[0].length; y++) {
				BoardWindow.setIcon(BoardWindow.iconForPiece(selectedPiece), x, y);
			}
		}
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