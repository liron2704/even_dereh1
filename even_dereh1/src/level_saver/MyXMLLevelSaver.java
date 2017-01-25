package level_saver;



import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.OutputStream;

import levels.Level;

public class MyXMLLevelSaver implements LevelSaver {

	@Override
	public void savelevel(Level lvl, OutputStream output) {
		XMLEncoder x = new XMLEncoder(new BufferedOutputStream(output));
		x.writeObject(lvl);//save
		x.close();

	}

}
