package cli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import commands.Command;
import commands.DisplayCommand;
import commands.ExitCommand;
import commands.LoadFileName;
import commands.MoveCommand;
import commands.SaveFileName;
import display.Display;
import display.Display2D;
import levels.Level;
import policy_move.MoveObj;
import policy_move.RegularMove;

public class CLI {

	Map<String, Command> commands;
	Level lvl;
	Display display;
	MoveObj move;
	Command commandc;
	
	public CLI() {
		lvl=new Level();
		display=new Display2D();
		move=new RegularMove();
		
		System.out.println("");
		commands = new HashMap<String, Command>();//hashmap for commands
		commands.put("load", new LoadFileName("",lvl ));
		commands.put("display", new DisplayCommand(lvl, display));
		commands.put("move up", new MoveCommand("up", move, lvl));
		commands.put("move down", new MoveCommand("down", move, lvl));
		commands.put("move left", new MoveCommand("left", move, lvl));
		commands.put("move right", new MoveCommand("right", move, lvl));
		commands.put("save", new SaveFileName(lvl, ""));
		commands.put("exit", new ExitCommand());
		
	}

	public void run ()
	{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while(true)//get commands from user until "exit"
		{
			try {
				String command= in.readLine();
				String address;
				commandc = commands.get(command);
				
				
				if(commandc==null)
					System.out.println("invaild command");
				else
				{
					try{
						if(commandc instanceof LoadFileName)//if its load command
						{
							System.out.println("enter URL: \n");
							address = in.readLine().toString();
							
							((LoadFileName) commandc).setFileName(address);
							
						}
						
						if(commandc instanceof SaveFileName)//if its save command
						{
							System.out.println("enter file name: ");
							address = in.readLine();
							((SaveFileName) commandc).setFileName(address);
						}
					
						commandc.execute();
					}
					catch (Exception e)
					{
						e.printStackTrace();
						System.out.println("error command");
					}
				}
					
			} catch (IOException e) {
				System.out.println("ivaild command");
				e.printStackTrace();
			}
			
		}

	}
	
}
