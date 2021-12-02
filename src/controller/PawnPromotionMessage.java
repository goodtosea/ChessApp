package controller;

import pieces.Piece;

public class PawnPromotionMessage implements Message
{
	private Piece piece;
	
	public PawnPromotionMessage(Piece piece)
	{
		this.piece = piece;
	}
	
	
	public Piece getPiece()
	{
		return this.piece;
	}
	
}
