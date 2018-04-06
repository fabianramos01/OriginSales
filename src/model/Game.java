package model;

public class Game {

	private int id;
	private String name;
	private int version;
	private int value;
	
	public Game(String name, int version) {
		id = (int) (Math.random() * 10000);
		this.version = version;
		this.name = name;
		value = (int) (Math.random() * 100);
	}
	
	public int getVersion() {
		return version;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public int getValue() {
		return value;
	}
}