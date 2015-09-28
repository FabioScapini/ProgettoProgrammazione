package test;

import static org.junit.Assert.*;

import model.ChessModel;

import org.junit.Test;

import controller.ChessController;
import controller.Teams;
import controller.pieces.Chessman;
import controller.pieces.EmptyMan;
import controller.pieces.King;
import controller.pieces.Pawn;
import controller.pieces.Queen;

public class TestPieces {

	@Test
	public void TestKingE() {		
		assertEquals(new King(Teams.BLACK), new King(Teams.BLACK));		
	}
	
	@Test
	public void TestTiles1() {		
		assertNotEquals(new King(Teams.BLACK), new Pawn(Teams.BLACK));		
	}
	
	@Test
	public void TestTiles2() {		
		assertNotEquals(new King(Teams.BLACK), new Queen(Teams.WHITE));		
	}
	
	@Test
	public void EmptyTeam(){
		assertEquals((new EmptyMan()).getColor(), Teams.EMPTY);
	}

	@Test
	public void KnightTest(){
		ChessController controller = new ChessController();
		controller.start();
		ChessModel model = controller.getModel();
		Chessman table [][] = model.getTable();
		
		//il cavallo si muove da (7,6) a (5,5)
		assertTrue(table[7][6].mkMove(7, 6, 5, 5, model));
	}
	
	@Test
	public void CheckMateTest(){
		//scacco matto

		ChessController controller = new ChessController();
		controller.start();
		ChessModel model = controller.getModel();
		Chessman table [][] = model.getTable();
		
		assertTrue(table[6][6].mkMove(6, 6, 4, 6, model));		
		table[4][6] = table [6][6];
		table[6][6] = new EmptyMan();		

		assertTrue(table[1][4].mkMove(1, 4, 3, 4, model));
		table[3][4] = table [1][4];
		table[1][4] = new EmptyMan();
		
		assertTrue(table[6][5].mkMove(6, 5, 5, 5, model));
		table[5][5] = table [6][5];
		table[6][5] = new EmptyMan();
		
		assertTrue(table[0][3].mkMove(0, 3, 4, 7, model));
		table[4][7] = table [0][3];
		table[0][3] = new EmptyMan();
		
		assertTrue(controller.checkMate(false));
	
	}
	
	public void CheckTest(){
		//scacco

		ChessController controller = new ChessController();
		controller.start();
		ChessModel model = controller.getModel();
		Chessman table [][] = model.getTable();
		
		assertTrue(table[6][4].mkMove(6, 4, 5, 4, model));		
		table[5][4] = table [6][4];
		table[6][4] = new EmptyMan();	
		
		assertTrue(table[1][3].mkMove(1, 3, 3, 3, model));		
		table[3][3] = table [3][3];
		table[3][3] = new EmptyMan();
		
		table[7][5].movement(7, 5, 3, 1, model);		
		
		assertTrue(model.isThereACheck());
	}
	
	
}
