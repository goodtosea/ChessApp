package view;

import javax.swing.JButton;

/**
 * Buttons which hold their coordinates for the chess window
 */
public class ChessButton extends JButton
{

	private int x, y;

	/**
	 * Getter for the row of the button
	 * @return the row of the button
	 */
	public int getX()
	{
		return x;
	}

	/**
	 * Getter for the column of the button
	 * @return the column of the button
	 */
	public int getY()
	{
		return y;
	}
	
}
