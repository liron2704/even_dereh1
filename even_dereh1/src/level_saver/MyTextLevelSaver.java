package level_saver;



import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;


import levels.Level;

public class MyTextLevelSaver implements LevelSaver {

	@Override
	public void savelevel(Level lvl, OutputStream output){
		char line;
		int maxsize[]=new int[2];
		maxsize=lvl.getSize();
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(output));
		
		for(int i=0;i<maxsize[0];i++)//line
		{
			for(int j=0;j<maxsize[1];j++)//row
			{
				line=reMatrix(lvl)[i][j];
				try {
					bw.write(line);//save char
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			
			}
			try {
				bw.write('\n');
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		try {
			bw.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}


	}
	private char[][] reMatrix(Level lvl)//return level matrix
	{
		int maxsize[]=new int[2];
		maxsize=lvl.getSize();// biggest line and row
		char matrix[][]=new char[maxsize[0]][maxsize[1]];
		
		for(int i=0;i<maxsize[0];i++)
		{
			for(int j=0;j<maxsize[1];j++)
			{
				matrix[i][j]=' ';
			}
		}//make empty matrix with the level size 
		
		for(int i=0;i<lvl.getWall().size();i++)//wall array
		{		
			int arr[]=lvl.getWall().get(i).getLocation();//arr has the wall location		
			matrix[arr[0]][arr[1]] = '#';	
			
		}
		
		
		for(int i=0;i<lvl.getTarget().size();i++)//target array
		{		
			int arr[]=lvl.getTarget().get(i).getLocation();//arr has the target location			
			matrix[arr[0]][arr[1]] = 'o';	
		}
		
		for(int i=0;i<lvl.getCharacter().size();i++)//character array
		{		
			int arr[]=lvl.getCharacter().get(i).getLocation();//arr has the character location			
			matrix[arr[0]][arr[1]] = 'A';	
		}
		
		for(int i=0;i<lvl.getBox().size();i++)//box array
		{		
			int arr[]=lvl.getBox().get(i).getLocation();//arr has the box location			
			matrix[arr[0]][arr[1]] = '@';	
		}	
		return matrix;
	}


}
