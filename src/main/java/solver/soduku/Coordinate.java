package solver.soduku;

public class Coordinate {
	public static final Coordinate NULL = new Coordinate(-1, -1);
	public int row;
	public int column;

	public Coordinate(int row, int column){
		this.row = row;
		this.column = column;
	}
}
