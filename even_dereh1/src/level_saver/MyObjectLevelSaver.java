package level_saver;


import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import levels.Level;

public class MyObjectLevelSaver implements LevelSaver {

	@Override
	public void savelevel(Level lvl, OutputStream output) {
		ObjectOutputStream out;
		
		try {
			out= new ObjectOutputStream(output);//save 
			out.writeObject(lvl);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
