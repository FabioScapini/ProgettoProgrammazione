package view.popup;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import controller.ChessController;


public class CheckMatePopUp extends JFrame	{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Color color = new Color(204, 0, 0);

	public CheckMatePopUp(final ChessController controller)	{
		
		JPanel center = new JPanel();
		center.setBackground(color);
		setTitle("GAME OVER!");
		
		JLabel pic = new JLabel(new ImageIcon("img/chesses.png"));
		pic.setBackground(color);
		center.add(pic);
		
		/* South panel */
		
		JPanel south = new JPanel();
				
		south.setLayout(new GridLayout(2, 1));
		south.setBackground(color);
		
		JPanel southFirst = new JPanel();
		southFirst.setBackground(color);
		southFirst.setLayout(new GridLayout(3, 1));
		
		JPanel centralMenu = new JPanel();
		centralMenu.setBackground(color);
		
		JPanel southButton = new JPanel();
		southButton.setBackground(color);
	
		JLabel message = new JLabel("Warning: THERE'S A CHECKMATE.");
		message.setFont(new Font("Ubuntu Mono", Font.BOLD, 30));
		message.setForeground(Color.WHITE);
		message.setHorizontalAlignment(JLabel.CENTER);
		southFirst.add(message);
		//south.add(southFirst);
		
		String color = "Sorry " + ((controller.getModel()).isWhiteTurn() ? "BLACK! " : "WHITE! ");		
		JLabel youlost = new JLabel(color + "You lost! :(");
		youlost.setFont(new Font("Georgia", Font.ITALIC, 30));
		youlost.setForeground(new Color(0,255,255));
		youlost.setHorizontalAlignment(JLabel.CENTER);
		southFirst.add(youlost);
		south.add(southFirst);
		
		JLabel doom = new JLabel("Here's your doom");
		doom.setFont(new Font("Georgia", Font.ITALIC, 15));
		doom.setHorizontalAlignment(JLabel.CENTER);
		doom.setForeground(Color.WHITE);
		southFirst.add(doom);
		south.add(southFirst);
		
		JMenuBar bar = new JMenuBar();
		bar.setBackground(Color.WHITE);
		bar.setForeground(Color.BLACK);
		
		JMenu menu = new JMenu("Press here, NOW!");
		menu.setBackground(Color.WHITE);
		menu.setBorderPainted(false);
		final JMenuItem firstItem = new JMenuItem("Start again!");
		firstItem.setForeground(Color.BLACK);
		firstItem.setBackground(Color.WHITE);
		firstItem.setBorderPainted(false);
		
		final JMenuItem secondItem = new JMenuItem("I don't wanna play.");
		secondItem.setForeground(Color.BLACK);
		secondItem.setBackground(Color.WHITE);
		secondItem.setBorderPainted(false);
		
		firstItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                
            	controller.start();
            	controller.getHistory().restart();
            	controller.getModel().getStats()[0].restart();
            	controller.getModel().getStats()[1].restart();
            	controller.getModel().getView().onConfigurationChange();
            	dispose();
            	
            }
        });
		
		secondItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	System.exit(0);
            }
        });	
		
		centralMenu.add(bar);
		menu.add(firstItem);
		menu.add(secondItem);
		centralMenu.add(menu);
		south.add(centralMenu);
		bar.add(menu);
			
		add(center, BorderLayout.CENTER);
		add(south, BorderLayout.SOUTH);
		
		pack();
		setVisible(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setAlwaysOnTop(true);
		setLocationRelativeTo(null);
	}

		
		
		
}