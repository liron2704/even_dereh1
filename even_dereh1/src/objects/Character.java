package objects;

import java.io.Serializable;

public class Character implements Serializable{

	private int location[];

	
	public int[] getLocation() {
		return location;
	}

	public void setLocation(int[] location) {
		this.location = location;
	}

	public Character()
	{
		location=null;
	}
	
	public Character(int location[])
	{
		this.location=location;
	}
}
