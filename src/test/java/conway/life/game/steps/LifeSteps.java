package conway.life.game.steps;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.jbehave.core.annotations.*;

import conway.life.game.Board;

public class LifeSteps {

	private Board board;

	@Given("a board $width by $height")
	public void aBoard(int width, int height){
		board		= new Board(width, height);
	}

	@When ("I tell cell ($column,$row) to live")
	public void aCellIsToldToLive(int column, int row){
		board.live(column, row);
	}

	@When ("I tell the board to run a generation")
	public void runGeneration(){
		board.runGeneration();
	}


	@Then("the board should look like $board")
	public void theBoardShouldLookLike(String board){
		assertThat(this.board.print(), equalTo(board));
	}
}
