package life.game;

public class RunConwaysGameOfLifeWithGlider {

	private static final int WAIT_TIME = 200;

	public static void main(String[] args) throws InterruptedException {
		ConwayBoard board	= new ConwayBoard(0);
		board.preset(ConwayBoard.GLIDER);
		for(int i=0;i<55;i++) runATurn(board);
		System.out.println(board.printState());
	}

	private static void runATurn(ConwayBoard board) throws InterruptedException {
		System.out.println(board.printState());
		board.turn();
		Thread.sleep(WAIT_TIME);
	}

}
