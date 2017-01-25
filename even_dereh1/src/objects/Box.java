package objects;

import java.io.Serializable;

public class Box implements Serializable{
	private int location[];

	
	public int[] getLocation() {
		return location;
	}

	public void setLocation(int[] location) {
		this.location = location;
	}
	
	public Box()
	{
		location=null;
	}
	
	public Box(int location[])
	{
		this.location=location;
	}
	
}
