package controller;

public class ApplySettingsMessage implements Message
{
	private int boardWidth, boardHeight;

	/**
	 * Constructs the ApplySettingsMessage
	 * @param boardWidth the width of the board
	 * @param boardHeight the height of the board
	 */
	public ApplySettingsMessage(int boardWidth, int boardHeight)
	{
		this.boardWidth = boardWidth;
		this.boardHeight = boardHeight;
	}

	/**
	 * Getter for board width.
	 * @return boardWidth, the width of the board
	 */
	public int getboardWidth()
	{
		return this.boardWidth;
	}

	/**
	 * Getter for board height.
	 * @return boardHeight, the height of the board
	 */
	public int getboardHeight()
	{
		return this.boardHeight;
	}
}
