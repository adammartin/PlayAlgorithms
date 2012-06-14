package solver.soduku;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GridTest {

	private Grid grid;
	private String[][] verySimpleGrid	=	{{"7"," ","6", "8","5","4", "3","2","1"},
											 {" ","4","3", "1"," ","6", "9","8","5"},
											 {"8"," "," ", "2"," ","9", "4","7","6"},
								
											 {"1","3","7", "9","6","5", " "," ","2"},
											 {"9","2","5", "4","1","8", "7"," "," "},
											 {"4","6","8", "7","2","3", " "," "," "},
								
											 {"6","1","4", "5","9","7", " "," ","8"},
											 {"5","8","2", "3","4","1", " ","9","7"},
											 {"3","7","9", "6","8","2", " ","5","4"}};
	private String[][] simpleGridSolved	=	{{"7","9","6", "8","5","4", "3","2","1"},
											 {"2","4","3", "1","7","6", "9","8","5"},
											 {"8","5","1", "2","3","9", "4","7","6"},
								
											 {"1","3","7", "9","6","5", "8","4","2"},
											 {"9","2","5", "4","1","8", "7","6","3"},
											 {"4","6","8", "7","2","3", "5","1","9"},
								
											 {"6","1","4", "5","9","7", "2","3","8"},
											 {"5","8","2", "3","4","1", "6","9","7"},
											 {"3","7","9", "6","8","2", "1","5","4"}};

	@Before
	public void setUp() throws Exception {
		grid	= new Grid(verySimpleGrid);
	}

	@Test
	public void canPrintGrid() throws Exception {
		assertArrayEquals(verySimpleGrid, grid.print());
	}

	@Test
	public void canSeeGridContainsUnknown() throws Exception {
		assertTrue(grid.containsUnknown());
	}

	@Test
	public void canSeeAGridDoesNotCointainUnknowns() throws Exception {
		assertFalse(new Grid(simpleGridSolved).containsUnknown());
	}

	@Test
	public void canGetFirstUnknownCoordinate() throws Exception{
		Coordinate unknownCoordinate	= grid.getFirstUnknown();
		assertEquals(0, unknownCoordinate.row);
		assertEquals(1, unknownCoordinate.column);
	}

	@Test
	public void canSeeGridContainsValue() throws Exception {
		assertEquals("7", grid.getValue(new Coordinate(0,0)));
	}

	@Test
	public void canUpdateGridValue() throws Exception {
		Coordinate coordinate = new Coordinate(0,1);
		String expected = "9";
		grid.setValue(coordinate, expected);
		assertEquals(expected, grid.getValue(coordinate));
	}

	@Test
	public void canGetAvailable() throws Exception {
		Coordinate coordinate = new Coordinate(0, 1);
		assertEquals(1, grid.available(coordinate).size());
		assertEquals("9", grid.available(coordinate).iterator().next());
	}
}
