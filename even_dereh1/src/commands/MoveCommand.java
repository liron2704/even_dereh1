package commands;

import levels.Level;
import policy_move.MoveObj;

public class MoveCommand implements Command {

	String diraction;
	MoveObj move;
	Level lvl;
	
	
	public MoveCommand(String diraction, MoveObj move,Level lvl) {
		this.diraction=diraction;//diraction of movment (up down left or right)
		this.move=move;
		this.lvl=lvl;
		
	} 
	
	@Override
	public void execute() {
		
		if(move.Movable(diraction, lvl)==true)//if we can move
		{
			
			move.Move(diraction, lvl);
			
		}
	}

}
