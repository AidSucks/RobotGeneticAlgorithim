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
	
	public void generateBatteries(int amount) {
		
		if(amount > (this.size * this.size)) return;
		
	}
	
	public void print() {
		
		for(int y = this.size; y >= 1; y--) {
			
			System.out.print(y);
			
			for(int x = 1; x <= this.size; x++) {
				if((currentRobot.getX() == x) && (currentRobot.getY() == y)) {
					System.out.print("[X]");
				}else {
					System.out.print("[ ]");
				}
			}
			
			System.out.print("\n");
			if(y == 1) {
				for(int x = 1; x <= this.size; x++) System.out.print("  " + x);
				System.out.print("\n");
			}
		}
		
	}
	
}
