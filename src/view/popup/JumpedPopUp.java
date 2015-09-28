package view.popup;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.ChessModel;

public class JumpedPopUp extends JFrame {
		
	private static final long serialVersionUID = 1L;
	private Color color = new Color(34,54,68);
	
	public JumpedPopUp(int x, int y, ChessModel model){
		
		setTitle("Invalid Move!");
		setBackground(color);
		
		/* Pannello completo finestra */
		
		JPanel grid = new JPanel();
		grid.setBackground(color);
		grid.setLayout(new GridBagLayout());
		
		JPanel complete = new JPanel();
		complete.setLayout(new GridLayout(5,1));
		complete.setBackground(color);
		
		JPanel panelButton = new JPanel();
		panelButton.setBackground(color);
		
		final JButton OK = new JButton("OK");
		OK.setBorderPainted(false);
		OK.setFocusPainted(false);
		OK.setBackground(Color.WHITE);
		OK.setForeground(Color.BLACK);
		OK.setVerticalAlignment(JLabel.CENTER);
		OK.setHorizontalAlignment(JLabel.CENTER);
		panelButton.add(OK);
		
		JPanel panelImage = new JPanel();		
		panelImage.setBackground(color);
		JLabel image = new JLabel(model.getTable()[x][y].printImage());
		image.setBackground(color);
		image.setAlignmentX(CENTER_ALIGNMENT);
		image.setAlignmentY(CENTER_ALIGNMENT);
		panelImage.add(image);
		
		JLabel message = new JLabel("The");
		message.setBackground(color);
		message.setFont(new Font("Georgia", Font.ITALIC, 25));
		message.setForeground(Color.WHITE);
		message.setHorizontalAlignment(JLabel.CENTER);
		
		JLabel message2 = new JLabel(model.getTable()[x][y].getColor() + " "
				+ model.getTable()[x][y].getName());
		message2.setBackground(color);
		
		message2.setFont(new Font("Georgia", Font.BOLD, 30));
		message2.setForeground(Color.WHITE);
		message2.setHorizontalAlignment(JLabel.CENTER);
		
		JLabel message3 = new JLabel("has been jumped!");
		message3.setBackground(color);
		message3.setForeground(Color.WHITE);
		
		message3.setFont(new Font("Georgia", Font.ITALIC, 25));
		message3.setHorizontalAlignment(JLabel.CENTER);
		
		complete.add(message);
		complete.add(message2);
		complete.add(message3);
		complete.add(image);
		complete.add(panelButton);
		grid.add(complete);
		
		OK.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				
			}
			
		});
		
		OK.setVerticalAlignment(JButton.CENTER);

		add(grid, BorderLayout.NORTH);
				
		setVisible(true);
		setAlwaysOnTop(true);
		pack();
		setSize(500,300);
		setLocationRelativeTo(null);
		
	}
		
}
