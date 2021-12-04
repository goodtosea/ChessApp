package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class CreditsWindow extends JFrame
{

	private JPanel contentPane;

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
					CreditsWindow frame = new CreditsWindow();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CreditsWindow()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		JPanel credits_panel = new JPanel();
		credits_panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		credits_panel.setLayout(new GridBagLayout());
		setContentPane(credits_panel);
		
		GridBagConstraints gbc1 = new GridBagConstraints();
		gbc1.gridwidth = GridBagConstraints.REMAINDER;
		gbc1.anchor = GridBagConstraints.CENTER;
		gbc1.fill = GridBagConstraints.HORIZONTAL;
		
		credits_panel.add(new JLabel("Created by:"), gbc1);
		credits_panel.add(new JLabel("Mohibkhan Pathan"), gbc1);
		credits_panel.add(new JLabel("Nathan Nguyen"), gbc1);
		credits_panel.add(new JLabel("& Alexander Lane"), gbc1);
		credits_panel.add(new JLabel("for Maria Surmenok's CS 151 class"), gbc1);
		
		JButton menu_button = new JButton("Main Menu");
		credits_panel.add(menu_button, gbc1);
	}

}
