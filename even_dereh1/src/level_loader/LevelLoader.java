package level_loader;

import java.io.IOException;
import java.io.InputStream;

import levels.Level;

public interface LevelLoader {
	public void loadlevel(Level lvl, InputStream levelfile) throws IOException, ClassNotFoundException;

}
