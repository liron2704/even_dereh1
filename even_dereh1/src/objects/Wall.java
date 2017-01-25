package objects;

import java.io.Serializable;

public class Wall implements Serializable{
	private int location[];

	
	public int[] getLocation() {
		return location;
	}

	public void setLocation(int[] location) {
		this.location = location;
	}

	public Wall()
	{
		location=null;
	}
	
	public Wall(int location[])
	{
		this.location=location;
	}

}
