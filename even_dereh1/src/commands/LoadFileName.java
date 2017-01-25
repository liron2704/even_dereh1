package commands;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import level_loader.LevelLoader;
import level_loader.MyObjectLevelLoader;
import level_loader.MyTextLevelLoader;
import level_loader.MyXMLLevelLoader;
import levels.Level;

public class LoadFileName implements Command {

	Level lvl;
	private LevelLoader lvlloader;
	String fileName;
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	Map<String, LevelLoader> extantion;//hashmap for extantion (txt xml or obj)
	
	
	
	public LoadFileName( String fileName,Level lvl) {
		
		extantion=new HashMap<String, LevelLoader>();
		
		extantion.put("xml", new MyXMLLevelLoader());//xml file
		extantion.put("txt", new MyTextLevelLoader());//text file
		extantion.put("obj", new MyObjectLevelLoader());//object file
		this.fileName = fileName;
		this.lvl=lvl;
		

	}
	
	
	
	@Override
	public void execute() throws ClassNotFoundException, FileNotFoundException, IOException {
		
		int indPoint = fileName.lastIndexOf('.');//need the string after the '.'
		++indPoint;
		String type= fileName.substring(indPoint, fileName.length());//file type
		this.lvlloader= extantion.get(type);//send the file type
		
		
			
			lvlloader.loadlevel(this.lvl, new FileInputStream(fileName));

			
		

	}
	

}
