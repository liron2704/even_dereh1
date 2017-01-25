package commands;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;


import level_saver.LevelSaver;
import level_saver.MyObjectLevelSaver;
import level_saver.MyTextLevelSaver;
import level_saver.MyXMLLevelSaver;
import levels.Level;
public class SaveFileName implements Command {

	Level lvl;
	private LevelSaver lvlSaver;
	String fileName;
	Map<String, LevelSaver> extantion;
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	
	
	public SaveFileName(Level lvl, String fileName){
		
		extantion=new HashMap<String,LevelSaver>();//hash map for file type
		
		extantion.put("xml", new MyXMLLevelSaver());
		extantion.put("txt", new MyTextLevelSaver());
		extantion.put("obj", new MyObjectLevelSaver());
		this.lvl=lvl;
		this.fileName=fileName;
		
		
		
	}
	
	@Override
	public void execute()  {
		
		int indPoint = fileName.lastIndexOf('.');//the type after the '.'
		++indPoint;
		String type= fileName.substring(indPoint, fileName.length());//file type
		
		this.lvlSaver= extantion.get(type);
		try {
			lvlSaver.savelevel(lvl, new FileOutputStream(fileName));// save
		} catch (FileNotFoundException e) {
			System.out.println("ivaild file name");
			e.printStackTrace();
		}

			
			

	}

}
