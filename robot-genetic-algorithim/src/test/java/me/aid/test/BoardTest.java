package me.aid.test;

import static org.junit.Assert.*;

import org.junit.Test;

import me.aid.rga.Board;
import me.aid.rga.Robot;

public class BoardTest {
	
	Board board = new Board(10);
	
	@Test
	public void boardShouldBe10x10Square() throws Exception {
		assertEquals(10, board.size());
	}
	
	@Test
	public void currentRobotShouldBeSameWhenSet() throws Exception {
		Robot robot1 = new Robot(this.board);
		
		board.setNextRobot(robot1);
		
		assertEquals(robot1, board.getRobot());
	}
	
	@Test
	public void robotShouldBeRemovedFromBoardAfterDeactivation() throws Exception {
		Robot robot1 = new Robot(this.board);
		
		board.setNextRobot(robot1);
		
		robot1.deactivate();
		
		assertNotEquals(robot1, board.getRobot());
	}

}
