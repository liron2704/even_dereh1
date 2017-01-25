package commands;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Command {
	void execute() throws ClassNotFoundException, FileNotFoundException, IOException ;
	
}
