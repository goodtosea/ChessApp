package view;

import pieces.*;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.util.concurrent.BlockingQueue;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import app.Message;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Window and View logic for the Chess Application
 */
public class BoardWindow extends JFrame
{
	
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
					BoardWindow window = new BoardWindow(null);
					window.setVisible(true);
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
	public BoardWindow(BlockingQueue<Message> queue)
	{
		this.board = new ChessButton[8][8];
		this.initialize();
	}

	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		this.setBounds(100, 100, 450, 450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel button_panel = new JPanel();
		getContentPane().add(button_panel, BorderLayout.SOUTH);
		button_panel.setLayout(new BorderLayout(0, 0));
		
		JButton main_menu_button = new JButton("Main Menu");
		main_menu_button.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
//				queue.put(new Message());
			}
		});
		
		button_panel.add(main_menu_button, BorderLayout.CENTER);
		
		JPanel board_holding_panel = new JPanel();
		board_holding_panel.setLayout(new BoxLayout(board_holding_panel, BoxLayout.Y_AXIS));
		board_holding_panel.setBorder(new EmptyBorder(40, 0, 0, 0));
		getContentPane().add(board_holding_panel, BorderLayout.CENTER);
//		board_holding_panel.setLayout(new BorderLayout(0, 0));
		
		
		int boardWidth = 8;
        int boardHeight = 8;
		JPanel board_panel = new JPanel(new GridLayout(boardHeight, boardWidth));
		board_panel.setMaximumSize(new Dimension(240, 240));
		board_holding_panel.add(board_panel);

        for (int y = boardHeight-1; y >= 0; y--) {
            for (int x = 0; x < boardWidth; x++) {
                //JButton b = new JButton("(" + x + ", " + y + ")");
                
            	// Makes new chess button and adds it to the corresponding position in the 2Darr
            	ChessButton b = new ChessButton(x, y);
//              board[x][y] = b;
//            	JButton b = new JButton();
                
                Color dark = new Color(110, 90, 80);
                Color light = new Color(200, 170, 120);
                
                if ((x+y)%2 == 0) {
                    b.setBackground(dark);
                    // b.setForeground(new Color(230,220,200)); // is only to make text more readable on dark square
                }
                else {
                    b.setBackground(light);
                }
                
//              b.setPreferredSize(new Dimension(20, 20)); // doesn't do anything?
                b.setOpaque(true);
                b.setBorderPainted(false);
                board_panel.add(b);
            }
        }
	}

	
	/**
	 * Highlights the square at the given coordinates to indicated selected piece and its available moves
	 * @param x coordinate of button to highlight
	 * @param y coordinate of button to highlight
	 */
	public static void highlightSquare(int x, int y)
	{
		board[x][y].setBackground(Color.lightGray);
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
		board[x][y] = new JButton(icon);
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
