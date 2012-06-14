package conway.life.game;

import org.apache.commons.lang.ArrayUtils;

public class Board {
    private static final String NL			= System.getProperty("line.separator");
    private static final String ALIVE		= "X";
    String[][] board;

	public Board(int width, int height) {
		board	= new String[height][width];
	}

	public void live(int column, int row) {
		board[row][column] = ALIVE;
	}

	public void runGeneration() {
	    String[][] newBoard	= cloneBoard();
		for(int row = 0; row < board.length; row++){
			for(int column = 0; column < board[row].length; column++){
				survivalLogic(column, row, newBoard);
			}
		}
		board	= newBoard;
	}


	public String print() {
		StringBuilder builder	= new StringBuilder();
		for(int row = 0; row < board.length; row++){
			for(int column = 0; column < board[row].length; column++){
				builder.append(getValue(board[row][column]));
			}
			if(row < board.length-1)
				builder.append(NL);
		}
		return	builder.toString();
	}

	private String[][] cloneBoard() {
		String[][] newBoard	= new String[board.length][];
		for(int row = 0; row < board.length; row++){
			newBoard[row] = (String[]) ArrayUtils.clone(board[row]);
		}
		return newBoard;
	}

	private void survivalLogic(int column, int row, String[][] newBoard) {
		int countOfLiveNeighbors	= countOfLiveNeighbors(column, row);
		if(countOfLiveNeighbors < 2){
			newBoard[row][column] = null;
		} else if (countOfLiveNeighbors > 3) {
			newBoard[row][column] = null;
		} else if(!ALIVE.equals(board[row][column]) && countOfLiveNeighbors == 3){
			newBoard[row][column] = ALIVE;
		}
	}

	private int countOfLiveNeighbors(int column, int row) {
		int countOfLiveNeighbors	= 0;
		for(int neighborRow = minNeighborValue(row); neighborRow <= maxNeighborValue(row, board.length); neighborRow++){
			for(int neighborColumn = minNeighborValue(column); neighborColumn <= maxNeighborValue(column, board[row].length); neighborColumn++){
				if(!(neighborColumn == column && neighborRow == row) && ALIVE.equals(board[neighborRow][neighborColumn])){
					countOfLiveNeighbors++;
				}
			}
		}
		return countOfLiveNeighbors;
	}

	private int maxNeighborValue(int dimension, int dimensionSize) {
		return dimension < dimensionSize-1? dimension+1:dimension;
	}

	private int minNeighborValue(int dimension) {
		return dimension > 0?dimension-1:0;
	}

	private String getValue(String string) {
		return ALIVE.equals(string)?ALIVE:".";
	}

}
