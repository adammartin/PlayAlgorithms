package conway.life.game;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class BoardTest {
    private static final String NL		= System.getProperty("line.separator");
    private static String EMPTY_BOARD	= "....." + NL +
											"....." + NL +
											"....." + NL +
											"....." + NL +
											".....";

    private Board board;

	@Before
	public void setUp(){
		board	= new Board(5, 5);
	}

	@Test
	public void canPrintEmptyBoard() throws Exception {
		assertThat(this.board.print(), equalTo(EMPTY_BOARD));
	}

	@Test
	public void canPrintLargerEmptyBoard() throws Exception {
		board	= new Board(6, 5);
		assertThat(board.print(), equalTo(
				"......" + NL +
				"......" + NL +
				"......" + NL +
				"......" + NL +
				"......"));
	}

	@Test
	public void canSetACellToLive() throws Exception {
		board.live(2, 2);
		assertThat(board.print(), equalTo(
				"....." + NL +
				"....." + NL +
				"..X.." + NL +
				"....." + NL +
				"....."));
	}

	@Test
	public void afterGenerationPassesALoneCellDies() throws Exception {
		board.live(2, 2);
		board.runGeneration();
		assertThat(board.print(), equalTo(EMPTY_BOARD));
	}

	@Test
	public void afterGenerationPassesCellWithOneAdjacentNeighborWillDie() throws Exception {
		board.live(2, 2);
		board.live(2, 3);
		board.runGeneration();
		assertThat(board.print(), equalTo(EMPTY_BOARD));
	}

	@Test
	public void afterGenerationPassesCellWithTwoAdjacentNeighborsWillLive() throws Exception {
		board.live(1, 0);
		board.live(2, 0);
		board.live(3, 0);
		board.runGeneration();
		assertThat(board.print(), equalTo(
				"..X.." + NL +
				"..X.." + NL +
				"....." + NL +
				"....." + NL +
				"....."));
	}

	@Test
	public void afterGenerationPassesThreeAdjacentCellsLive() throws Exception {
		board	= new Board(5, 3);
		board.live(1, 0);
		board.live(2, 0);
		board.live(3, 0);
		board.live(2, 1);
		board.live(1, 2);
		board.live(2, 2);
		board.live(3, 2);
		board.runGeneration();
		assertThat(board.print(), equalTo(
				".XXX." + NL +
				"....." + NL +
				".XXX."));
	}

	@Test
	public void afterGenerationPassesDeadCellWithThreeLiveNeighborsLives() throws Exception {
		board.live(0, 0);
		board.live(1, 0);
		board.live(2, 0);
		board.runGeneration();
		assertThat(board.print(), equalTo(
				".X..." + NL +
				".X..." + NL +
				"....." + NL +
				"....." + NL +
				"....."));
	}

	@Test
	public void afterGenerationPassesCellWithMoreThanThreeAdjacentCellsDies() throws Exception {
		board.live(0, 0);
		board.live(0, 1);
		board.live(1, 0);
		board.live(2, 0);
		board.live(2, 1);
		board.runGeneration();
		assertThat(board.print(), equalTo(
				"X.X.." + NL +
				"X.X.." + NL +
				"....." + NL +
				"....." + NL +
				"....."));
	}
}