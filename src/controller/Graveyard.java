package controller;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.HashSet;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.pieces.Chessman;
import java.awt.Font;

public class Graveyard {
	
	private HashSet<Chessman> Wgraves= new HashSet<>();
	private HashSet<Chessman> Bgraves= new HashSet<>();
	private int Wdeath= 0;
	private int Bdeath= 0;
		
	public Graveyard (){
	}
	
	public void add(Chessman piece){
		if(piece.getColor().equals(Color.WHITE)){
			if(contains(piece)==0)
				Wdeath++;
			Wgraves.add(piece);
		}else{
			if(contains(piece)==0)
				Bdeath++;
			Bgraves.add(piece);
		}
	}
	
	private int contains(Chessman piece) {
		return contains(piece.getName(), piece.getColor());
	}
	
	private int contains(Piece name, Teams color) {
		int count=0;
		
		HashSet<Chessman> graves = color == Teams.WHITE ? Wgraves : Bgraves;
	
		for(Chessman b:graves)
			if(b.getName().equals(name))	
				count++;
		
		return count;
	}

	public void clear(){
		Wgraves.clear();
		Bgraves.clear();
		Wdeath= 0;
		Bdeath= 0;
	}
	
	public JPanel toVideo(Teams color){
		JPanel panel = new JPanel();
		
		
		Color col = color == Teams.WHITE ? Color.WHITE : Color.BLACK;
		Color inv = color == Teams.BLACK ? Color.WHITE : Color.BLACK;
				
		int length = color == Teams.WHITE ? Wdeath : Bdeath;
		ImageIcon image = null;
		panel.setBackground(col);
		int count;
		
	
		if(length == 0){
			JLabel label = new JLabel("The "+ color.toString().toLowerCase() +" graveyard is still Empty");
			label.setFont(new Font("Georgia", Font.ITALIC, 20));
			label.setForeground(inv);
			panel.add(label);
			
		}else{
			
			panel.setLayout(new GridLayout(length,1));
			
				for(Piece a : Piece.values()){
					count=contains(a,color);
					image= new ImageIcon("img/piece/"+color+"_"+a+".png"); 
					
					JPanel tile = null;
					if(count!=0){
						tile = new JPanel();
						tile.setLayout(new GridLayout(1,3));
						tile.setBackground(col);
						
						JLabel number= new JLabel(count+" x");
						number.setFont(new Font("Georgia", Font.ITALIC, 20));
						number.setHorizontalAlignment(JLabel.CENTER);
						number.setVerticalAlignment(JLabel.CENTER);
						
						JLabel name= new JLabel(a+"");
						name.setFont(new Font("Georgia", Font.ITALIC + Font.CENTER_BASELINE, 20));
						name.setVerticalAlignment(JLabel.CENTER);
						
						number.setBackground(col);
						name.setBackground(col);
						number.setForeground(inv);
						name.setForeground(inv);
						
						tile.add(number);
						tile.add(new JLabel(image));
						tile.add(name);
						panel.add(tile);
					}
				}
			
		}
		
		return panel;
	}

}
