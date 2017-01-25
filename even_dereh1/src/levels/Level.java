package levels;



import java.io.Serializable;
import java.util.ArrayList;

import objects.Box;
import objects.Character;
import objects.Target;
import objects.Wall;


public class Level implements Serializable{
	
	private ArrayList<Wall> wall;
	private ArrayList<Box> box;
	private ArrayList<Target> target;
	private ArrayList<Character> character;
	
	private String name;
	private String difficulty;
	private int size[];//max row and max line
	
	public Level(Level lvl)
	{
		this.wall=lvl.wall;
		this.box=lvl.box;
		this.target=lvl.target;
		this.character=lvl.character;
		this.name=lvl.name;
		this.difficulty=lvl.difficulty;
		this.size=lvl.size;
	}
	
	public Level() {
		this.wall=null;
		this.box=null;
		this.target=null;
		this.character=null;
		this.name=null;
		this.difficulty=null;
		this.size=null;
		
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
	public int[] getSize() {
		return size;
	}
	public void setSize(int[] size) {
		this.size = size;
	}
	public ArrayList<Wall> getWall() {
		return wall;
	}
	public void setWall(ArrayList<Wall> wall) {
		this.wall = wall;
	}
	public ArrayList<Box> getBox() {
		return box;
	}
	public void setBox(ArrayList<Box> box) {
		this.box = box;
	}
	public ArrayList<Target> getTarget() {
		return target;
	}
	public void setTarget(ArrayList<Target> target) {
		this.target = target;
	}
	public ArrayList<Character> getCharacter() {
		return character;
	}
	public void setCharacter(ArrayList<Character> character) {
		this.character = character;
	}
	
	
	
}
