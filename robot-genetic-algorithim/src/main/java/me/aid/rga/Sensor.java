package me.aid.rga;

public class Sensor {

	private State north, south, east, west;
	
	public State getNorth() {
		return north;
	}
	
	public State getSouth() {
		return south;
	}
	
	public State getEast() {
		return east;
	}
	
	public State getWest() {
		return west;
	}
	
	public void setNorth(State n) {
		north = n;
	}
	
	public void setSouth(State s) {
		south = s;
	}
	
	public void setEast(State e) {
		east = e;
	}
	
	public void setWest(State w) {
		west = w;
	}
	
	public enum State {
		NO_OBJECT, WALL, BATTERY
	}
	
}
