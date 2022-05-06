package me.aid.rga;

public class Main {

	public static void main(String[] args) {
		Board b = new Board(10);
		Robot r = new Robot(b);
		
		r.generateGenes(16);
		r.printGenes();
		
		b.setNextRobot(r);
		b.print();
	}

}
