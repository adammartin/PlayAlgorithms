package solver.soduku;

import java.util.Set;


public class SodukuSolver {
	private static final int MAX_ITERATION = 9;
	private Grid originalGrid;

	public SodukuSolver(String[][] sodukuGrid) {
		originalGrid	= new Grid(sodukuGrid);
		int iterations = 0;
		while(originalGrid.containsUnknown()
				&& iterations < MAX_ITERATION){
			updateKnown(originalGrid);
			iterations++;
		}
	}

	public String[][] solution() {
		return bruteForceSolve();
	}

	private void updateKnown(Grid grid) {
		for(int y = 0; y<Grid.GRID_SIZE; y++){
			for(int x = 0; x<Grid.GRID_SIZE; x++){
				updateKnown(new Coordinate(y, x), grid);
			}
		}
	}

	private void updateKnown(Coordinate coordinate, Grid grid) {
		if(Grid.UNKNOWN.equals(grid.getValue(coordinate))){
			Set<String> available = grid.available(coordinate);
			if(available.size() == 1){
				grid.setValue(coordinate, available.iterator().next());
			}
		}
	}

	private String[][] bruteForceSolve() {
		Coordinate unknown = originalGrid.getFirstUnknown();
		if(!Coordinate.NULL.equals(originalGrid.getFirstUnknown())){
			return bruteForce(unknown, originalGrid.available(unknown), originalGrid).print();
		}
		return originalGrid.print();
	}

	private Grid bruteForce(Coordinate coordinate, Set<String> available, Grid originalGrid) {
		for(String value:available){
			Grid newGrid = new Grid(originalGrid.print());

			newGrid.setValue(coordinate, value);
			updateKnown(newGrid);

			Coordinate unknown = newGrid.getFirstUnknown();
			if(!Coordinate.NULL.equals(unknown)){
				newGrid = bruteForce(unknown, newGrid.available(unknown), newGrid);
			}
			if(!newGrid.containsUnknown()){
				return newGrid;
			}
		}
		return originalGrid;
	}
}

