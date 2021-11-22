package view;

import pieces.*;

import java.awt.EventQueue;

import javax.swing.Icon;
import javax.swing.JFrame;

/**
 * Window and View logic for the Chess Application
 */
public class BoardWindow
{

	private JFrame frame;
	private static ChessButton[][] board;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					BoardWindow window = new BoardWindow();
					window.frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * Create the application.
	 */
	public BoardWindow()
	{
		initialize();
	}

	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
	/**
	 * Highlights the square at the given coordinates to indicated selected piece and its available moves
	 * @param x coordinate of button to highlight
	 * @param y coordinate of button to highlight
	 */
	public static void highlightSquare(int x, int y)
	{
		
	}
	
	
	/**
	 * Opens a panel on top of the board that prompts the user to select a type of piece for the promotion
	 */
	public static void pawnPromotion()
	{
		
	}
	
	
	/**
	 * Sets the icon of the button at the given coordinates
	 * @param icon the button will be changed to have
	 * @param x coordinate of the button
	 * @param y coordinate of the button
	 */
	public static void setIcon(Icon icon, int x, int y)
	{
		
	}


	/**
	 * For a specified piece, returns its icon
	 * @param piece
	 * @return the piece's icon
	 */
	public static Icon iconForPiece(Piece piece) {		// maybe temporary method. idk how we want to do this.
		if (piece instanceof Pawn) 			return null;
		else if (piece instanceof Rook) 	return null;
		else if (piece instanceof Bishop) 	return null;
		else if (piece instanceof Knight) 	return null;
		else if (piece instanceof Queen) 	return null;
		else if (piece instanceof King) 	return null;
		else return null;
	}
	
}
