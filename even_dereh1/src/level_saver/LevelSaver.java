package level_saver;





import java.io.OutputStream;

import levels.Level;

public interface LevelSaver {
	public void savelevel(Level lvl, OutputStream output);
}
