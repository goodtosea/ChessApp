package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class PawnPromotionWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PawnPromotionWindow frame = new PawnPromotionWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * Create the frame.
	 */
	public PawnPromotionWindow() 
	{
		setTitle("Pawn Promotion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(195, 100, 260, 110);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel instruction_panel = new JPanel();
		contentPane.add(instruction_panel, BorderLayout.NORTH);
		
		JLabel pawn_promotion_instruction = new JLabel("Select the piece to replace your pawn:");
		instruction_panel.add(pawn_promotion_instruction);
		
		JPanel button_panel = new JPanel();
		contentPane.add(button_panel, BorderLayout.CENTER);
		button_panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton rook_button = new JButton("");
		rook_button.setIcon(new ImageIcon("icons/rook.png"));
		rook_button.setPreferredSize(new Dimension(40, 40));
		button_panel.add(rook_button);
		
		JButton knight_button = new JButton("");
		knight_button.setPreferredSize(new Dimension(40, 40));
		button_panel.add(knight_button);
		
		JButton bishop_button = new JButton("");
		bishop_button.setPreferredSize(new Dimension(40, 40));
		button_panel.add(bishop_button);
		
		JButton queen_button = new JButton("");
		queen_button.setPreferredSize(new Dimension(40, 40));
		button_panel.add(queen_button);
	}

}
