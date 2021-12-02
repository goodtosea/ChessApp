package controller;

public class ApplySettingsMessage implements Message
{
	private int boardWidth, boardHeight;
	
	public ApplySettingsMessage(int boardWidth, int boardHeight)
	{
		this.boardWidth = boardWidth;
		this.boardHeight = boardHeight;
	}
	
	
	public int getboardWidth()
	{
		return this.boardWidth;
	}
	
	
	public int getboardHeight()
	{
		return this.boardHeight;
	}
}
