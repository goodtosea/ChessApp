package view;
import controller.*;

import pieces.*;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.util.concurrent.BlockingQueue;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Message;

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
	private BlockingQueue<Message> queue;
	private int boardWidth;
    private int boardHeight;

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
					BoardWindow window = new BoardWindow(null, 8, 8);
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
	public BoardWindow(BlockingQueue<Message> queue, int boardWidth, int boardHeight)
	{
		this.queue = queue;
		this.boardWidth = boardWidth;
		this.boardHeight = boardHeight;
		this.board = new ChessButton[boardWidth][boardHeight];
		this.initialize();
		this.paintBoard();
		this.setVisible(true);
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
		
		
		JPanel board_panel = new JPanel(new GridLayout(boardHeight, boardWidth));
		board_panel.setMaximumSize(new Dimension(40*boardWidth, 40*boardHeight));
		board_holding_panel.add(board_panel);

        for (int y = boardHeight-1; y >= 0; y--) 
        {
            for (int x = 0; x < boardWidth; x++) 
            {
            	// Makes new chess button and adds it to the corresponding position in the 2Darr
            	ChessButton b = new ChessButton(x, y);
            	
            	// Fix this please
            	int z = x;
                int f = y;
                
                b.addActionListener(e ->  {
                	try 
                	{
                		queue.put(new OnSquareClickMessage(z, f));
                	}
                	catch (InterruptedException exception)
                	{
                		exception.printStackTrace();
                	}
                });
            	
            	board[x][y] = b;
                
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
		board[x][y].setIcon(icon);
	}


	/**
	 * For a specified piece, returns its icon
	 * @param piece
	 * @return the piece's icon
	 */
	public static Icon iconForPiece(Piece piece) {		// maybe temporary method. idk how we want to do this.
		if 		(piece instanceof Pawn) 	return piece.isWhite() ? new ImageIcon("icons/white_pawn.png") 		: new ImageIcon("icons/black_pawn.png");
		else if (piece instanceof Rook) 	return piece.isWhite() ? new ImageIcon("icons/white_rook.png") 		: new ImageIcon("icons/black_rook.png");
		else if (piece instanceof Bishop) 	return piece.isWhite() ? new ImageIcon("icons/white_bishop.png") 	: new ImageIcon("icons/black_bishop.png");
		else if (piece instanceof Knight) 	return piece.isWhite() ? new ImageIcon("icons/white_knight.png") 	: new ImageIcon("icons/black_knight.png");
		else if (piece instanceof Queen) 	return piece.isWhite() ? new ImageIcon("icons/white_queen.png") 	: new ImageIcon("icons/black_queen.png");
		else if (piece instanceof King) 	return piece.isWhite() ? new ImageIcon("icons/white_king.png") 		: new ImageIcon("icons/black_king.png");
		else 								return null;
	}
	
	
	public void paintBoard()
	{
		for (int y = boardHeight-1; y >= 0; y--) 
        {
            for (int x = 0; x < boardWidth; x++) 
            {
		
				Color dark 	= new Color(100, 90, 80);
		        Color light = new Color(200, 170, 120);
		        
		        if ((x+y)%2 == 0) {
		            board[x][y].setBackground(dark);
		        }
		        else {
		            board[x][y].setBackground(light);
		        }
            }
        }
	}
	
}
