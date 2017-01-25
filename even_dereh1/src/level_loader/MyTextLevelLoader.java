package level_loader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import levels.Level;
import objects.Box;
import objects.Wall;
import objects.Character;
import objects.Target;

public class MyTextLevelLoader implements LevelLoader {
	
	
	public MyTextLevelLoader() {
		
	}

	@Override
	public void loadlevel(Level lvl,InputStream levelfile) throws IOException {
		
		
		
		ArrayList<Wall> walls = new ArrayList<Wall>();
		ArrayList<Box> boxes = new ArrayList<Box>();
		ArrayList<Character> characters = new ArrayList<Character>();
		ArrayList<Target> targets = new ArrayList<Target>();
		
		
		int newsize[] = new int[2];	//level size
		int maxline=0;	
		String line;
		int x=0;//row
		int y=0;//line
		
		BufferedReader br  = new BufferedReader(new InputStreamReader(levelfile));
		
		while((line = br.readLine())!=null)//while the line not empty
		{
			
			for(y=0;y<line.length();y++)//each line
			{
				switch (line.charAt(y))
				{
				
					case '#': //wall case
					{
						int location[] = {x,y};
						walls.add(new Wall(location));// text location
						break;
					}
					case 'A'://character case
					{
						int location[] = {x,y};
						characters.add(new Character(location));// text location
						break;
					}
					case '@'://box case
					{
						int location[] = {x,y};
						boxes.add(new Box(location));// text location
						break;
					}
					case 'o'://target case
					{
						int location[] = {x,y};
						targets.add(new Target(location));// text location
						break;
					}
					default:
						break;
				}	
				if(maxline<y)//if the current line bigger then maxline
					maxline=y;
				
			}
			x++;
		}
		newsize[0] = x;
		newsize[1] = maxline+1;
		
		br.close();
		lvl.setBox(boxes);
		lvl.setWall(walls);
		lvl.setCharacter(characters);
		lvl.setTarget(targets);
		lvl.setSize(newsize);

		
	}

}
