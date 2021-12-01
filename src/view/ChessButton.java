package view;

import javax.swing.JButton;

/**
 * Buttons which hold their coordinates for the chess window
 */
public class ChessButton extends JButton
{

	private int grid_x, grid_y;
	
	public ChessButton(int grid_x, int grid_y)
	{
		this.grid_x = grid_x;
		this.grid_y = grid_y;
	}
	
	
	public int getGridX()
	{
		return grid_x;
	}
	
	
	public int getGridY()
	{
		return grid_y;
	}
	
}
