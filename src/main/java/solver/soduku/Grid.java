package solver.soduku;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Grid {
	public static final int GRID_SIZE = 9;
	public static final String UNKNOWN = " ";
	private static final Set<String> RANGE	= new HashSet<String>(Arrays.asList("1","2","3","4","5","6","7","8","9"));
	private String[][] grid;

	public Grid(String[][] grid){
		this.grid = grid;
	}

	public String[][] print(){
		String[][] newGrid = new String[GRID_SIZE][GRID_SIZE];
		for(int row = 0; row<GRID_SIZE; row++){
			for(int column = 0; column<GRID_SIZE; column++){
				newGrid[row][column] = grid[row][column];
			}
		}
		return newGrid;
	}

	public boolean containsUnknown(){
		for(int row = 0; row < GRID_SIZE; row++){
			for(int column = 0; column< GRID_SIZE; column++){
				if(UNKNOWN.equals(grid[row][column])){
					return true;
				}
			}
		}
		return false;
	}

	public String getValue(Coordinate coordinate){
		return grid[coordinate.row][coordinate.column];
	}

	public void setValue(Coordinate coordinate, String value){
		grid[coordinate.row][coordinate.column] = value;
	}

	public Set<String> available(Coordinate coordinate) {
		Set<String> available = new HashSet<String>(RANGE);
		available.removeAll(knownRowValues(coordinate.row));
		available.removeAll(knownColumnValues(coordinate.column));
		available.removeAll(knownQuadrantValues(coordinate));
		return available;
	}

	private List<String> knownRowValues(int row) {
		return Arrays.asList(grid[row]);
	}

	private Set<String> knownColumnValues(int column) {
		Set<String> columnValues	= new HashSet<String>();
		for(int y=0; y<GRID_SIZE; y++){
			columnValues.add(grid[y][column]);
		}
		return columnValues;
	}

	private Set<String> knownQuadrantValues(Coordinate coordinate) {
		Set<String> taken	= new HashSet<String>();
		for(int y = minFor(coordinate.row); y < minFor(coordinate.row)+3; y++){
			for(int x = minFor(coordinate.column); x < minFor(coordinate.column)+3; x++){
				taken.add(grid[y][x]);
			}
		}
		return taken;
	}

	private int minFor(int row) {
		return (row/3)*3;
	}

	public Coordinate getFirstUnknown() {
		for(int row = 0; row < Grid.GRID_SIZE; row++){
			for(int column = 0; column < Grid.GRID_SIZE; column++){
				Coordinate coordinate = new Coordinate(row, column);
				if(UNKNOWN.equals(getValue(coordinate))){
					return coordinate;
				}
			}
		}
		return Coordinate.NULL;
	}
}
