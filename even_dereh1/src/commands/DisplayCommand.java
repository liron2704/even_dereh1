package commands;


import display.Display;
import levels.Level;

public class DisplayCommand implements Command {

	Level lvl;
	private Display dis;
	
	
	
	public DisplayCommand(Level lvl,Display display) {
		this.lvl=lvl;
		this.dis=display;
		
	}//Constructor
	
	@Override
	public void execute() {
		
		dis.Display1(lvl);//display the level
		
	}
	
}
