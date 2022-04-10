package me.aid.rga;

import java.util.ArrayList;
import java.util.Random;

public class Robot {
	
	private int xPos, yPos;
	private boolean isActive = false;
	private ArrayList<Character> genes;
	private final Board board;
	
	public Robot(Board board) {
		this.board = board;
		this.genes = new ArrayList<>(16);
		this.generateInitialPosition();
		this.activate();
	}
	
	public Robot(Board board, int x, int y) {
		this.xPos = x;
		this.yPos = y;
		this.board = board;
		this.genes = new ArrayList<>(16);
		this.activate();
	}
	
	public int getX() {
		return xPos;
	}

	public int getY() {
		return yPos;
	}
	
	public Board getBoard() {
		return this.board;
	}
	
	public ArrayList<Character> getGenes() {
		return this.genes;
	}
	
	public boolean isActive() {
		return isActive;
	}

	public void activate() {
		this.isActive = true;
	}
	
	public void deactivate() {
		this.genes.clear();
		this.board.setNextRobot(null);
		this.isActive = false;
	}
	
	private void generateInitialPosition() {
		Random random = new Random();
		
		this.xPos = random.nextInt(this.board.size()) + 1;
		this.yPos = random.nextInt(this.board.size()) + 1;
	}
	
	//Only called for first generation
	//TODO Move method to separate function in board
	public void generateGenes() {
		
		Random random = new Random();
		
		for(int i = 0; i < 16; i++) {
			int ranNum = random.nextInt(4) + 65;
			char gene = (char) ranNum;
			this.genes.add(gene);
		}
	}

	public Robot reproduce(Robot otherParent) {
		
		if(!this.isActive) return null;
		
		Robot offspring = new Robot(this.board);
		
		for(int i = 0; i < 16; i++) {
			if(i < 8) {
				offspring.getGenes().add(this.getGenes().get(i));
			}else {
				offspring.getGenes().add(otherParent.getGenes().get(i));
			}
		}
		
		offspring.activate();
		return offspring;
	}

	public boolean move(Direction dir) {
		
		if(!this.isActive) return false;
		
		int xChange = this.xPos;
		int yChange = this.yPos;
		
		switch(dir) {
		case NORTH:
			yChange += 1;
			break;
		case SOUTH:
			yChange -= 1;
			break;
		case WEST:
			xChange -= 1;
			break;
		case EAST:
			xChange += 1;
			break;
		}
		
		//Higher than size
		if((xChange > this.board.size()) || (yChange > this.board.size())) return false;
		//Lower than 1
		if((xChange <= 0) || (yChange <= 0)) return false;
		
		this.xPos = xChange;
		this.yPos = yChange;
		return true;
	}
	
	public void printGenes() {
		System.out.print(this.genes + "\n");
	}

}