package me.aid.test;

import static org.junit.Assert.*;

import org.junit.Test;

import me.aid.rga.Board;
import me.aid.rga.Direction;
import me.aid.rga.Robot;

public class RobotTest {
	
	Board board = new Board(10);
	Robot uninitRobot = new Robot(this.board);
	Robot fixedRobot = new Robot(this.board, 2, 2);
	
	@Test
	public void newRobot_shouldBeActiveAfterInitialization() throws Exception {
		assertTrue(uninitRobot.isActive());
	}
	
	@Test
	public void newRobot_genesShouldBeEmpty() throws Exception {
		assertTrue(uninitRobot.getGenes().isEmpty());
	}
	
	@Test
	public void newRobot_xPosAndyPosShouldBeRandomGreaterThan0() throws Exception {
		assertNotEquals(0, uninitRobot.getX());
		assertNotEquals(0, uninitRobot.getY());
	}
	
	@Test
	public void genesAreNotEmptyAfterActivationAndGeneration() throws Exception {
		uninitRobot.generateGenes();
		assertFalse(uninitRobot.getGenes().isEmpty());
	}
	
	@Test
	public void genesAreEmptyAfterDeactivation() throws Exception {
		uninitRobot.deactivate();
		assertTrue(uninitRobot.getGenes().isEmpty());
	}
	
	@Test
	public void genesArraySizeEquals16AfterActivationAndGeneration() throws Exception {
		uninitRobot.generateGenes();
		assertEquals(16, uninitRobot.getGenes().size());
	}
	
	@Test
	public void genesShouldNotEqualPreviousGenesAfterReproduction() throws Exception {
		
		Robot mother = new Robot(this.board);
		
		uninitRobot.generateGenes();
		mother.generateGenes();
		
		Robot offspring1 = uninitRobot.reproduce(mother);
		Robot offspring2 = mother.reproduce(uninitRobot);
		
		assertNotEquals(offspring1.getGenes(), uninitRobot.getGenes());
		assertNotEquals(offspring1.getGenes(), mother.getGenes());
		
		assertNotEquals(offspring2.getGenes(), uninitRobot.getGenes());
		assertNotEquals(offspring2.getGenes(), mother.getGenes());
	}
	
	@Test
	public void yPlusOneWhenMoveNorth() throws Exception {
		
		int previousYValue = fixedRobot.getY();
		
		fixedRobot.move(Direction.NORTH);
		
		assertEquals(previousYValue + 1, fixedRobot.getY());
	}
	
	@Test
	public void yMinusOneWhenMoveSouth() throws Exception {
		
		int previousYValue = fixedRobot.getY();
		
		fixedRobot.move(Direction.SOUTH);
		
		assertEquals(previousYValue - 1, fixedRobot.getY());
	}
	
	@Test
	public void xPlusOneWhenMovesEast() throws Exception {
		
		int previousXValue = fixedRobot.getX();
		
		fixedRobot.move(Direction.EAST);
		
		assertEquals(previousXValue + 1, fixedRobot.getX());
	}
	
	@Test
	public void xMinusOneWhenMovesWest() throws Exception {
		
		int previousXValue = fixedRobot.getX();
		
		fixedRobot.move(Direction.WEST);
		
		assertEquals(previousXValue - 1, fixedRobot.getX());
	}
	
	@Test
	public void robotBoardShouldBeTheSameAsTheOneInitialized() throws Exception {
		Robot robot4 = new Robot(this.board);
		
		assertEquals(this.board, robot4.getBoard());
	}
	
	@Test
	public void xAndYShouldNotBeSetLargerThanBoardSize() throws Exception {
		
		Robot robot4 = new Robot(this.board);
		
		robot4.move(Direction.NORTH);
		robot4.move(Direction.EAST);
		
		assertFalse(robot4.getX() > robot4.getBoard().size());
		assertFalse(robot4.getY() > robot4.getBoard().size());
	}
	
	@Test
	public void xAndYShouldNotChangeDuringAbortedMove() throws Exception {
		Robot robot4 = new Robot(this.board);
		
		robot4.move(Direction.NORTH);
		robot4.move(Direction.EAST);
		
		assertNotEquals(11, robot4.getX());
		assertNotEquals(11, robot4.getY());
	}
	
	@Test
	public void xAndYShouldNotBeSetLowerThanOne() throws Exception {
		
		uninitRobot.move(Direction.SOUTH);
		uninitRobot.move(Direction.WEST);
		
		assertNotEquals(0, uninitRobot.getX());
		assertNotEquals(0, uninitRobot.getY());
	}
	
	@Test
	public void robotShouldNotMoveAfterDeactivation() throws Exception {
		
		uninitRobot.deactivate();
		
		assertFalse(uninitRobot.move(Direction.NORTH));
		
	}
	
	@Test
	public void robotShouldNotReproduceAfterDeactivation() throws Exception {
		Robot robot2 = new Robot(this.board);
		
		uninitRobot.generateGenes();
		robot2.generateGenes();
		
		uninitRobot.deactivate();
		
		assertNull(uninitRobot.reproduce(robot2));
	}

}
