package level_loader;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

import levels.Level;


public class MyXMLLevelLoader implements LevelLoader {

	@Override
	public void loadlevel(Level lvl, InputStream levelfile) throws IOException, ClassNotFoundException {
		
		XMLDecoder xmlde = new XMLDecoder(new BufferedInputStream(levelfile));
		
		 lvl = (Level) xmlde.readObject();//read xml file
		 xmlde.close();
		
	}

}
