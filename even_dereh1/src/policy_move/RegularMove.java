package policy_move;

import levels.Level;

public class RegularMove implements MoveObj {

	@Override
	public void Move(String direction, Level lvl) {
		if(( nearbox(direction,lvl)==false))//if there is not a box near the direction i want to move
		{
			int arr[]=lvl.getCharacter().get(0).getLocation();//character location
			
			if(direction=="up")
			{
				
				arr[0]-=1;//move up
				lvl.getCharacter().get(0).setLocation(arr);//new location
			}
			else if(direction=="down")
			{
				
				arr[0]+=1;//move down
				lvl.getCharacter().get(0).setLocation(arr);//new location
			}
			else if(direction=="right")
			{
				
				arr[1]+=1;//move right
				lvl.getCharacter().get(0).setLocation(arr);//new location
			}
			else if(direction=="left")
			{
				
				arr[1]-=1;//move left
				lvl.getCharacter().get(0).setLocation(arr);//new location
			}
		}
		
		if((movableNearbox(direction,lvl)==true))//if there is a box and we can move the box
		{
			
			int arr[]=lvl.getCharacter().get(0).getLocation();//character location
			
			if(direction=="up")
			{
				for(int i=0;i<lvl.getBox().size();i++)//box array
				{
					int arrbox[]=lvl.getBox().get(i).getLocation();//box location
					int r=arrbox[0];//row
					int j=arrbox[1];//line
					arrbox=lvl.getCharacter().get(0).getLocation();//character location
					if(r==arrbox[0]-1 && j==arrbox[1])//if this is the box we want to move (for)
					{
						int newlocation[]=lvl.getBox().get(i).getLocation();
						newlocation[0]--;
						lvl.getBox().get(i).setLocation(newlocation);//move box
					}
				}
				arr[0]-=1;
				lvl.getCharacter().get(0).setLocation(arr);//move character
			}
			
			
			else if(direction=="down")
			{
				for(int i=0;i<lvl.getBox().size();i++)
				{
					int arrbox[]=lvl.getBox().get(i).getLocation();//box array
					int r=arrbox[0];//row
					int j=arrbox[1];//line
					arrbox=lvl.getCharacter().get(0).getLocation();//character location
					if(r==arrbox[0]+1 && j==arrbox[1])//if this is the box we want to move (for)
					{
						int newlocation[]=lvl.getBox().get(i).getLocation();
						newlocation[0]++;
						lvl.getBox().get(i).setLocation(newlocation);//move box
					}
				}
				arr[0]+=1;
				lvl.getCharacter().get(0).setLocation(arr);//move character
			}
			
			
			else if(direction=="right")
			{
				
				for(int i=0;i<lvl.getBox().size();i++)//box array
				{
					int arrbox[]=lvl.getBox().get(i).getLocation();
					int r=arrbox[0];//row
					int j=arrbox[1];//line 
					arrbox=lvl.getCharacter().get(0).getLocation();//character location
										
					if(r==arrbox[0] && j==arrbox[1]+1)//if this is the box we want to move (for)
					{
						
						int newlocation[]=lvl.getBox().get(i).getLocation();
						newlocation[1]++;
						lvl.getBox().get(i).setLocation(newlocation);//move box
					}
				}
				arr[1]+=1;
				lvl.getCharacter().get(0).setLocation(arr);//move character
				
			}
			
			
			else if(direction=="left")
			{
				
				for(int i=0;i<lvl.getBox().size();i++)//box array
				{
					int arrbox[]=lvl.getBox().get(i).getLocation();
					int r=arrbox[0];//row
					int j=arrbox[1];//line 
					arrbox=lvl.getCharacter().get(0).getLocation();//character location
					
					if(j==arrbox[0] && r==arrbox[1]-1)//if this is the box we want to move (for)
					{
						int newlocation[]=lvl.getBox().get(i).getLocation();
						newlocation[1]--;
						lvl.getBox().get(i).setLocation(newlocation);//move box
					}
				}
				arr[1]-=1;
				lvl.getCharacter().get(0).setLocation(arr);//move character
			}			
		}
	}

	
	@Override
	public boolean Movable(String direction, Level lvl)
	{
		int arr[]=lvl.getCharacter().get(0).getLocation();//character location
		char matrix[][]=reMatrix(lvl);//level matrix
		
		
		if(movableNearbox(direction,lvl)==true)//if there is a box and we can move the box		
			return true;
		
		
		else if(direction=="up")
		{
			if(matrix[arr[0]-1][arr[1]]==' '||matrix[arr[0]-1][arr[1]]=='o')//there is nothing near me or a target
				return true;
		}
		
		else if(direction=="down")
		{
			if(matrix[arr[0]+1][arr[1]]==' '||matrix[arr[0]+1][arr[1]]=='o')//there is nothing near me or a target
				return true;
		}
		
		else if(direction=="right")
		{
			if(matrix[arr[0]][arr[1]+1]==' '||matrix[arr[0]][arr[1]+1]=='o')//there is nothing near me or a target
				return true;
		}
		
		else if(direction=="left")
		{
			if(matrix[arr[0]][arr[1]-1]==' '||matrix[arr[0]][arr[1]-1]=='o')//there is nothing near me or a target
				return true;
		}
			
		return false;
	}
	
	
	private boolean nearbox(String direction, Level lvl)//the character have box near the direction he wants to move
	{
		int arr[]=lvl.getCharacter().get(0).getLocation();//character location
		char matrix[][]=reMatrix(lvl);//level matrix
		
		if(direction=="up")
		{
			if(matrix[arr[0]-1][arr[1]]=='@')//has box near him
			{
				return true;
			}
		}
		
		else if(direction=="down")
		{
			if(matrix[arr[0]+1][arr[1]]=='@')//has box near him
			{
				return true;
			}
		}
		
		else if(direction=="right")
		{
			
			if(matrix[arr[0]][arr[1]+1]=='@')//has box near him
			{
				
				return true;
			}
		}
		
		else if(direction=="left")
		{
			if(matrix[arr[0]][arr[1]-1]=='@')//has box near him
			{
				return true;
			}
		}
		
		return false;
	}

	
	private boolean movableNearbox(String direction,Level lvl)//movable if its known that we have a box near the character
	{
		if( (nearbox( direction,  lvl))==false)//doesnt havs a box near him
			return false;
		
		char matrix[][]= reMatrix(lvl);//level matrix
		int arr[]=lvl.getCharacter().get(0).getLocation();//character location
		
		if(direction=="up")
		{
			if(matrix[arr[0]-2][arr[1]]==' '||matrix[arr[0]-2][arr[1]]=='o')//there is nothing the box or a target
				return true;
		}
		
		else if(direction=="down")
		{
			if(matrix[arr[0]+2][arr[1]]==' '||matrix[arr[0]+2][arr[1]]=='o')//there is nothing the box or a target
				return true;
		}
		
		else if(direction=="right")
		{
			if(matrix[arr[0]][arr[1]+2]==' '||matrix[arr[0]][arr[1]-2]=='o')//there is nothing the box or a target
				return true;
			
		}
		
		else if(direction=="left")
		{
			if(matrix[arr[0]][arr[1]-2]==' '||matrix[arr[0]][arr[1]-2]=='o')//there is nothing the box or a target
				return true;
		}
		return false;
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
