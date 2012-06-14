package solver.soduku;


import static org.junit.Assert.*;

import org.junit.Test;

public class SodukuSolverTest {

	private SodukuSolver solver;
	private String[][] verySimpleGrid	=	{{"7"," ","6", "8","5","4", "3","2","1"},
			 								 {" ","4","3", "1"," ","6", "9","8","5"},
			 								 {"8"," "," ", "2"," ","9", "4","7","6"},

			 								 {"1","3","7", "9","6","5", " "," ","2"},
			 								 {"9","2","5", "4","1","8", "7"," "," "},
			 								 {"4","6","8", "7","2","3", " "," "," "},

			 								 {"6","1","4", "5","9","7", " "," ","8"},
			 								 {"5","8","2", "3","4","1", " ","9","7"},
			 								 {"3","7","9", "6","8","2", " ","5","4"}};
	private String[][] simpleGrid	=	{{"7","9"," ", " "," "," ", "3"," "," "},
			 							 {" "," "," ", " "," ","6", "9"," "," "},
			 							 {"8"," "," ", " ","3"," ", " ","7","6"},

			 							 {" "," "," ", " "," ","5", " "," ","2"},
			 							 {" "," ","5", "4","1","8", "7"," "," "},
			 							 {"4"," "," ", "7"," "," ", " "," "," "},

			 							 {"6","1"," ", " ","9"," ", " "," ","8"},
			 							 {" "," ","2", "3"," "," ", " "," "," "},
			 							 {" "," ","9", " "," "," ", " ","5","4"}};

	private String[][] hardGrid	=	{{" "," ","9", "7","4","8", " "," "," "},
									 {"7"," "," ", " "," "," ", " "," "," "},
									 {" ","2"," ", "1"," ","9", " "," "," "},
						
									 {" "," ","7", " "," "," ", "2","4"," "},
									 {" ","6","4", " ","1"," ", "5","9"," "},
									 {" ","9","8", " "," "," ", "3"," "," "},
						
									 {" "," "," ", "8"," ","3", " ","2"," "},
									 {" "," "," ", " "," "," ", " "," ","6"},
									 {" "," "," ", "2","7","5", "9"," "," "}};

	private String[][] hardGridSolved	=	{{"5","1","9", "7","4","8", "6","3","2"},
											 {"7","8","3", "6","5","2", "4","1","9"},
											 {"4","2","6", "1","3","9", "8","7","5"},

											 {"3","5","7", "9","8","6", "2","4","1"},
											 {"2","6","4", "3","1","7", "5","9","8"},
											 {"1","9","8", "5","2","4", "3","6","7"},

											 {"9","7","5", "8","6","3", "1","2","4"},
											 {"8","3","2", "4","9","1", "7","5","6"},
											 {"6","4","1", "2","7","5", "9","8","3"}};

	private String[][] simpleGridSolved	=	{{"7","9","6", "8","5","4", "3","2","1"},
											 {"2","4","3", "1","7","6", "9","8","5"},
											 {"8","5","1", "2","3","9", "4","7","6"},

											 {"1","3","7", "9","6","5", "8","4","2"},
											 {"9","2","5", "4","1","8", "7","6","3"},
											 {"4","6","8", "7","2","3", "5","1","9"},

											 {"6","1","4", "5","9","7", "2","3","8"},
											 {"5","8","2", "3","4","1", "6","9","7"},
											 {"3","7","9", "6","8","2", "1","5","4"}};

	@Test
	public void canLoadGrid() throws Exception {
		solver	= new SodukuSolver(simpleGridSolved);
		assertArrayEquals(simpleGridSolved, solver.solution());
	}

	@Test
	public void canSolveSimpleRow() throws Exception {
		solver	= new SodukuSolver(verySimpleGrid);
		assertArrayEquals(simpleGridSolved[0], solver.solution()[0]);
	}

	@Test
	public void canSolveAnotherSimpleRow() throws Exception {
		solver	= new SodukuSolver(verySimpleGrid);
		assertArrayEquals(simpleGridSolved[1], solver.solution()[1]);
	}

	@Test
	public void canSolveSimpleColumn() throws Exception {
		solver	= new SodukuSolver(verySimpleGrid);
		assertArrayEquals(simpleGridSolved[2], solver.solution()[2]);
	}

	@Test
	public void canSolveSimpleQuadrant() throws Exception {
		solver	= new SodukuSolver(verySimpleGrid);
		assertArrayEquals(simpleGridSolved[5], solver.solution()[5]);
	}

	@Test
	public void canSolveVerySimpleSoduku() throws Exception {
		solver	= new SodukuSolver(verySimpleGrid);
		assertArrayEquals(simpleGridSolved, solver.solution());
	}

	@Test
	public void canSolveSimpleSoduku() throws Exception {
		solver	= new SodukuSolver(simpleGrid);
		assertArrayEquals(simpleGridSolved, solver.solution());
	}

	@Test
	public void canSolveExtremeSoduku() throws Exception {
		solver	= new SodukuSolver(hardGrid);
		assertArrayEquals(hardGridSolved, solver.solution());
	}
}
