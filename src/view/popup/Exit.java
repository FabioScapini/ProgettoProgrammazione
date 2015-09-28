package view.popup;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import view.ChessFrame;

import java.awt.event.*;

public class Exit extends JFrame {

	
	private static final long serialVersionUID = 1L;


	public Exit()	{
		
		Color color = new Color(34,54,68);
		
		setTitle("Are you sure?");
		
		JPanel north = new JPanel();
		
		JLabel message = new JLabel("Do you really wanna exit?");
		message.setFont(new Font("Georgia", Font.PLAIN, 20));
		message.setForeground(Color.WHITE);
		message.setHorizontalAlignment(JLabel.CENTER);
		message.setVerticalAlignment(JLabel.CENTER);
		message.setPreferredSize(new Dimension(450,50));
		message.setBackground(color);
		
		north.setBackground(color);
		north.add(message);
		
		JPanel south = new JPanel();
		south.setBackground(color);
		south.setLayout(new GridLayout(2,1));
		
		JPanel yesP = new JPanel();
		yesP.setBackground(color);
		JButton yesB = new JButton("Sure.");
		//play.setBorder(new CompoundBorder(BorderFactory.createMatteBorder(0, 3, 0, 0, Color.BLACK), BorderFactory.createMatteBorder(0, 7, 0, 0, Color.RED)));
		yesB.setFont(new Font("Georgia", Font.BOLD, 18));
		yesB.setForeground(color);
		yesB.setBackground(Color.WHITE);
		yesB.setFocusable(false);
		yesB.setBorderPainted(false);
		
		yesB.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);	
				}
			});
		
		yesP.add(yesB);
		south.add(yesP);
		
		
		
		JPanel noP = new JPanel();
		noP.setBackground(color);
		JButton noB = new JButton("Just Kidding!");
		noB.setFont(new Font("Georgia", Font.BOLD, 18));
		noB.setForeground(color);
		noB.setBackground(Color.WHITE);
		noB.setFocusable(false);
		noB.setBorderPainted(false);
		
		noB.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				dispose();
				}
			});
		
		noP.add(noB);
		south.add(noP);
		
		getContentPane().add(north, BorderLayout.NORTH);
		getContentPane().add(south, BorderLayout.CENTER);
		
		this.setBackground(color);
		setAlwaysOnTop(true);
		pack();
		setSize(450, 150);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
			
	}

}
