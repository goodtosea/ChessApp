package view;
import controller.*;

import pieces.*;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.concurrent.BlockingQueue;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.Message;
import game.Board;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Window and View logic for the Chess Application
 */
public class View extends JFrame
{
	
	private static ChessButton[][] board;
	private BlockingQueue<Message> queue;
//	private int boardWidth;
//  private int boardHeight;
    
    private JPanel board_panel;
    private JPanel board_holding_panel;
	
	/**
	 * Create the application.
	 */
	public View(BlockingQueue<Message> queue)
	{
		this.queue = queue;
//		this.boardWidth = Board.getBoardArray().length;
//		this.boardHeight = Board.getBoardArray()[0].length;
//		this.board = new ChessButton[boardWidth][boardHeight];
		this.initialize();
//		this.paintBoard();
		this.setVisible(true);
	}

	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		this.setBounds(100, 100, 450, 450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel card_panel = new JPanel(new CardLayout());
		
		this.setContentPane(card_panel);
		
		// Menu Panel Stuff
		JPanel menu_panel = new JPanel();
		
		menu_panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0};
		gbl_contentPane.rowHeights = new int[]{0};
		gbl_contentPane.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{Double.MIN_VALUE};
		menu_panel.setLayout(gbl_contentPane);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.NORTH;
		
		menu_panel.add (new JLabel("Chess App"), gbc);
		
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		
		JPanel buttons = new JPanel(new GridBagLayout());
		
		JButton play_game_button = new JButton("Play Game");
		JButton settings_button = new JButton("Settings");
		JButton credits_button = new JButton("Credits");
		
		play_game_button.addActionListener(e ->  {
        	try 
        	{
        		CardLayout cl = (CardLayout) card_panel.getLayout();
        		cl.next(card_panel);
        		queue.put(new PlayGameMessage());
        	}
        	catch (Exception exception)
        	{
        		exception.printStackTrace();
        	}
        });
		
		settings_button.addActionListener(e ->  {
        	try 
        	{
        		CardLayout cl = (CardLayout) card_panel.getLayout();
        		cl.next(card_panel);
        		cl.next(card_panel);
//        		queue.put(new PlayGameMessage());
        	}
        	catch (Exception exception)
        	{
        		exception.printStackTrace();
        	}
        });
		
		
		buttons.add(play_game_button, gbc);
		buttons.add(settings_button, gbc);
		buttons.add(credits_button, gbc);
		
		gbc.weighty = 1;
		menu_panel.add(buttons, gbc);
		
		
		// Game Panel Stuff
		JPanel game_panel = new JPanel(new BorderLayout());
		
		JPanel button_panel = new JPanel();
		game_panel.add(button_panel, BorderLayout.SOUTH);
		button_panel.setLayout(new BorderLayout(0, 0));
		
		JButton main_menu_button = new JButton("Main Menu");
		main_menu_button.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				CardLayout cl = (CardLayout) card_panel.getLayout();
        		cl.first(card_panel);
//				queue.put(new Message());
			}
		});
		
		button_panel.add(main_menu_button, BorderLayout.CENTER);
		
		board_holding_panel = new JPanel();
		board_holding_panel.setLayout(new BoxLayout(board_holding_panel, BoxLayout.Y_AXIS));
		board_holding_panel.setBorder(new EmptyBorder(40, 0, 0, 0));
		game_panel.add(board_holding_panel, BorderLayout.CENTER);
		
		
//		board_panel = new JPanel(new GridLayout(boardHeight, boardWidth));
//		board_panel.setMaximumSize(new Dimension(40*boardWidth, 40*boardHeight));
//		board_holding_panel.add(board_panel);
//
//        for (int y = boardHeight-1; y >= 0; y--) 
//        {
//            for (int x = 0; x < boardWidth; x++) 
//            {
//            	// Makes new chess button and adds it to the corresponding position in the 2Darr
//            	ChessButton b = new ChessButton(x, y);
//            	
//            	// Fix this please
//            	int z = x;
//                int f = y;
//                
//                b.addActionListener(e ->  {
//                	try 
//                	{
//                		queue.put(new OnSquareClickMessage(z, f));
//                	}
//                	catch (InterruptedException exception)
//                	{
//                		exception.printStackTrace();
//                	}
//                });
//            	
//            	board[x][y] = b;
//                
//                b.setOpaque(true);
//                b.setBorderPainted(false);
//                board_panel.add(b);
//            }
//        }
        
		JPanel settings_panel = new JPanel();
				
		GridBagLayout gbl_contentPane1 = new GridBagLayout();
		gbl_contentPane1.columnWidths = new int[]{0};
		gbl_contentPane1.rowHeights = new int[]{0};
		gbl_contentPane1.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_contentPane1.rowWeights = new double[]{Double.MIN_VALUE};
		settings_panel.setLayout(gbl_contentPane1);
		
		GridBagConstraints gbc1 = new GridBagConstraints();
		gbc1.gridwidth = GridBagConstraints.REMAINDER;
		gbc1.anchor = GridBagConstraints.NORTH;
		
		settings_panel.add (new JLabel("Settings"), gbc1);
		settings_panel.add (new JLabel("Columns >= 8 and Rows >= 4"), gbc1);
		
		gbc1.anchor = GridBagConstraints.CENTER;
		gbc1.fill = GridBagConstraints.HORIZONTAL;
		
		JPanel buttons1 = new JPanel(new GridBagLayout());
		
		JTextField column_field = new JTextField("8");
		JTextField row_field = new JTextField("8");
		
		JButton apply_button = new JButton("Apply");
		JButton main_from_settings = new JButton("Main Menu");
		
		buttons1.add(new JLabel("Column Count"), gbc1);
		buttons1.add(column_field, gbc1);
		buttons1.add(new JLabel("Row Count"), gbc1);
		buttons1.add(row_field, gbc1);
		buttons1.add(apply_button, gbc1);
		buttons1.add(main_from_settings, gbc1);
		
		apply_button.addActionListener(e -> 
		{
			try
			{
				queue.put(new ApplySettingsMessage(Integer.parseInt(column_field.getText()), Integer.parseInt(row_field.getText())));
			}
			catch (InterruptedException exception)
			{
				
			}
		});
		
		main_from_settings.addActionListener(e -> 
		{
			CardLayout cl = (CardLayout) card_panel.getLayout();
    		cl.first(card_panel);
		});
		
		gbc1.weighty = 1;
		settings_panel.add(buttons1, gbc1);
		
        card_panel.add(menu_panel);
        card_panel.add(game_panel);
        card_panel.add(settings_panel);
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
	public void pawnPromotion(int last_move_y)
	{
		PawnPromotionWindow frame = new PawnPromotionWindow(queue, last_move_y);
		frame.setVisible(true);
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
		for (int y = Board.getBoardArray()[0].length - 1; y >= 0; y--) 
        {
            for (int x = 0; x < Board.getBoardArray().length; x++) 
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
	
	
	public void panelDraw(int boardWidth, int boardHeight)
	{
		try
		{
			board_holding_panel.remove(board_panel);
		}
		catch (NullPointerException exception)
		{
			
		}
		
		this.board = new ChessButton[boardWidth][boardHeight];
		board_panel = new JPanel(new GridLayout(boardHeight, boardWidth));
		board_panel.setMaximumSize(new Dimension(40*boardWidth, 40*boardHeight));

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
        
        board_holding_panel.add(board_panel);
	}
	
}
