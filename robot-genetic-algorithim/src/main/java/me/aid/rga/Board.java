package me.aid.rga;

public class Board {

	private int size = 10;
	private Robot currentRobot;
	
	public Board(int size) {
		this.size = size;
	}
	
	public int size() {
		return size;
	}
	
	public Robot getRobot() {
		return this.currentRobot;
	}
	
	public void setNextRobot(Robot robotToSet) {
		this.currentRobot = robotToSet;
	}
	
}
