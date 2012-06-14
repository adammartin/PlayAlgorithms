package life.game;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ConwayBoardTest {

	private ConwayBoard board;

	@Before
	public void setUp() throws Exception {
		board = new ConwayBoard(6);
	}

	@Test
	public void boardIsInProperInitialState() throws Exception {
		board = new ConwayBoard(2);
		for(int yPos = 0; yPos < 2; yPos++){
			for(int xPos = 0; xPos < 2; xPos ++){
				assertFalse(board.isAlive(xPos, yPos));
			}
		}
	}

	@Test
	public void canSetAPositionToAlive() throws Exception {
		board.live(0,0);
		assertTrue(board.isAlive(0,0));
	}

	@Test
	public void canSetADifferentPositionToAlive() throws Exception {
		board.live(0,3);
		assertTrue(board.isAlive(0,3));
	}

	@Test
	public void livingCellWithZeroNeighborsWillDie() throws Exception {
		board.live(3, 3);
		board.turn();
		assertFalse(board.isAlive(3, 3));
	}

	@Test
	public void livingCellWithOneNeighborsWillDie() throws Exception {
		board.live(3, 3);
		board.live(3, 4);
		board.turn();
		assertFalse(board.isAlive(3, 3));
	}

	@Test
	public void livingCellWithTwoNeighborsWillNotDie() throws Exception {
		board.live(0, 0);
		board.live(0, 1);
		board.live(1, 1);
		board.turn();
		assertTrue(board.isAlive(0, 0));
		assertTrue(board.isAlive(0, 1));
		assertTrue(board.isAlive(1, 1));
	}

	@Test
	public void livingCellWithTwoNeighborsWillNotDieButOthersWillDie() throws Exception {
		board.live(0, 0);
		board.live(0, 1);
		board.live(0, 2);
		board.turn();
		assertFalse(board.isAlive(0, 0));
		assertTrue(board.isAlive(0, 1));
		assertFalse(board.isAlive(0, 2));
	}

	@Test
	public void livingCellWithMoreThanThreeWillDie() throws Exception {
		board.live(0, 0);
		board.live(1, 0);
		board.live(0, 1);
		board.live(1, 1);
		board.live(0, 2);
		board.turn();
		assertFalse(board.isAlive(0, 1));
		assertFalse(board.isAlive(1, 1));
	}

	@Test
	public void deadCellWithThreeLiveNeighborsWillBecomeAlive() throws Exception {
		board.live(1, 0);
		board.live(0, 1);
		board.live(1, 1);
		board.turn();
		assertTrue(board.isAlive(0, 0));
	}

	@Test
	public void presetBoardForGliderSetsBoardFor29Length() throws Exception {
		board.preset(ConwayBoard.GLIDER);
		assertTrue(board.printState().contains("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - \n"));
	}

	@Test
	public void presetBoardForGliderSetsBoardPutsGliderInMiddle() throws Exception {
		board.preset(ConwayBoard.GLIDER);
		assertTrue(board.isAlive(13, 13));
		assertTrue(board.isAlive(14, 14));
		assertTrue(board.isAlive(12, 15));
		assertTrue(board.isAlive(13, 15));
		assertTrue(board.isAlive(14, 15));
	}

	@Test
	public void boardPrintIsProper() throws Exception {
		String expectedInitialState	= "- - - - - - \n"
									+ "- - - - - - \n"
									+ "- - - - - - \n"
									+ "- - - - - - \n"
									+ "- - - - - - \n"
									+ "- - - - - - \n";
		assertEquals(expectedInitialState, board.printState());
	}

	@Test
	public void boardPrintIsProperWithALivingRecord() throws Exception {
		board.live(0,3);
		String expectedInitialState	= "- - - - - - \n"
									+ "- - - - - - \n"
									+ "- - - - - - \n"
									+ "X - - - - - \n"
									+ "- - - - - - \n"
									+ "- - - - - - \n";
		assertEquals(expectedInitialState, board.printState());
	}

}
