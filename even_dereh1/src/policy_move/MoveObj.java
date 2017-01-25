package policy_move;

import levels.Level;

public interface MoveObj {
	
	public void Move(String diraction, Level lvl);
	public boolean Movable(String diraction, Level lvl);

}
