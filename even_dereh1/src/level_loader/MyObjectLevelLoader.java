package level_loader;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

import levels.Level;

public class MyObjectLevelLoader implements LevelLoader {

	@Override
	public void loadlevel(Level lvl, InputStream levelfile) throws IOException, ClassNotFoundException {
		
		 lvl = new Level((Level)(new ObjectInputStream(levelfile).readObject()));//load object file
		
		

		
	}

}
