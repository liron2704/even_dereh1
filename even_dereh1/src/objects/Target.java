package objects;

import java.io.Serializable;

public class Target implements Serializable{

	private int location[];

	
	public int[] getLocation() {
		return location;
	}

	public void setLocation(int[] location) {
		this.location = location;
	}

	public Target()
	{
		location=null;
	}
	
	public Target(int location[])
	{
		this.location=location;
	}
}
