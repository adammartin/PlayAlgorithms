package life.game;

import org.apache.commons.lang.StringUtils;

public class ConwayBoard {
	public static final String GLIDER = "glider";
	private static final String ALIVE = "X";
	private static final String DEAD = null;
	private String[][] board;

	public ConwayBoard(int gridSize) {
		board 	= new String[gridSize][gridSize];
	}

	public boolean isAlive(int xPos, int yPos) {
		return ALIVE.equals(board[yPos][xPos]);
	}

	public void live(int xPos, int yPos) {
		board[yPos][xPos] = ALIVE;
	}

	public void turn() {
		String[][] newBoard	= new String[board.length][board.length];
		for(int yPos = 0; yPos < board.length; yPos++){
			String[] column = board[yPos];
			for(int xPos = 0; xPos < column.length; xPos++){
				newBoard[yPos][xPos] = runLifeCycle(yPos, xPos);
			}
		}
		board = newBoard;
	}

	public void preset(String preset) {
		//TODO: Refactor to object oriented when required;
		if(GLIDER.equals(preset)){
			board	= new String[29][29];
			live(13, 13);
			live(14, 14);
			live(12, 15);
			live(13, 15);
			live(14, 15);
		}
	}

	public String printState() {
		StringBuilder grid = new StringBuilder();
		for(int yPos = 0; yPos < board.length; yPos++){
			String[] column = board[yPos];
			for(int xPos = 0; xPos < column.length; xPos++){
				grid.append(getValue(column[xPos])+ " ");
			}
			grid.append("\n");
		}
		return grid.toString();
	}
	
	private String runLifeCycle(int yPos, int xPos) {
		int numberOfLivingNeighbors = numberOfLivingNeighbors(yPos, xPos);

		if(isAlive(xPos, yPos)
				&& numberOfLivingNeighbors > 2
				&& numberOfLivingNeighbors < 5){
			return ALIVE;
		}

		if(!isAlive(xPos, yPos)
				&& numberOfLivingNeighbors == 3){
			return ALIVE;
		}
		return DEAD;
	}

	private int numberOfLivingNeighbors(int yPos, int xPos) {
		int numberOfLivingNeighbors	= 0;
		for(int row = yPos-1; row <= yPos+1; row++){
			for(int col = xPos-1; col <= xPos+1; col++){
				numberOfLivingNeighbors += lifeAt(row, col);
			}
		}
		return numberOfLivingNeighbors;
	}

	private int lifeAt(int row, int col) {
		if(isOnBoard(row, col) && isAlive(col, row)){
			return 1;
		}
		return 0;
	}

	private boolean isOnBoard(int row, int col) {
		if(row < 0 || row >= board.length)
			return false;
		if(col < 0 || col >= board.length)
			return false;
		return true;
	}

	private String getValue(String positionVal){
		if(StringUtils.isBlank(positionVal))
			return "-";
		else 
			return positionVal;
	}

}
