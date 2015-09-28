package main;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

import view.*;

public class Main {

	//public static ChessFrame global;
	private static Starting global;
	/**
	 * <p> This class create a new <b>ChessFrame</b> and set his icon and his default operation close
	 */
	public static void main(String[] args) {
	
		global = new Starting();
		
		Image icon = Toolkit.getDefaultToolkit().getImage("img/icona.png");
	    global.setIconImage(icon);
	    global.pack();
	    global.setVisible(true);
		global.setLocationRelativeTo(null);
		
	}
	
	public static ChessFrame getFrame(){
		return global.getFrame();
	}
}
