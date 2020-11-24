import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class DAG {
	
    int vertex;
    int edge;
    int [] outDegree;
    int [] inDegree;
    int [] visit;
    int [][] adjacentList;

    public DAG(int vertex){
        if(vertex < 0){
            system.out.println("number of vertices cannot be less than 0"); // cant use vertex that is out of bounds
        }        
		else {
		this.vertex = vertex;
		this.edge = 0;
		inDegree = new int[vertex];
		outDegree = new int[vertex];
		visit  = new int[vertex];
		adjacentList = new int[vertex][vertex];
		//initialising the graph in an empty
            for(int i = 0; i < vertex; i++)
            {
			    for(int j =0; j < vertex; j++){

            
                    adjacentList[i][j] = 0;
                }
            } 
        }      
    }

    public int vertices(){
        return vertex;
    }

    public int edges(){
        return edge;
    }

    public void addEdges(){
        adjacentList[x][y] = 1;
		inDegree[y]++;
		outDegree[x]++;
		edge++;
    }

    public void removeEdges(){
        if(adjacentList[x][y] == 1) 
		    {
		adjacentList[x][y] = 0;
		inDegree[y]--;
		outDegree[x]--;
		edge--;
		    }
		else
		    return;
    }

    public void checkScope(int v){
        if(v < 0 || v>= vertex)
		{
			throw new IllegalArgumentException("not a valid vertex(not within scope)");
		}
    }

    public int inDegree(int x)
	{
		checkScope(x);
		return inDegree[x];
    }
    
    public int outDegree(int x)
	{
		checkScope(x);
		return outDegree[x];
	
    }
    
    public boolean checkCycle()
	{
		boolean cycle = false;
		int count = 0;
		for(int i = 0; i < vertex; i++)
		{
			visit[count] = i;
			for(int j = 0; j < vertex; j++)
			{
				for(int k = 0; k < vertex; k++)
				{
					if(visit[k] == j && adjacentList[i][j] == 1) //if visit[k] is equal to the vertex j and i and j have an edge between them 
					{
						cycle = true; // a cycle exists 
						return cycle;
					}
				}
			}
			count++; 
		}
		return cycle;
    }
    
    public int LCA(int x, int y)
	{
		checkScope(x);
		checkScope(y);
		boolean cycle;
		cycle = checkCycle();
		if(edge > 0 && cycle == false) //if there are no edges or there is a cycle, it cannot be a directed acyclic graph
			return LCAHelp(x, y);
		else
		{
			return -1;  //not an acyclic graph so cant find LCA
		}
    }
    
    private int LCASupport(int x, int y)
	{
		int[] xPath = new int[edge]; //create a first path
		int[] yPath = new int[edge]; 
		
		boolean[] xVisited = new boolean[vertex]; //an array of booleans storing vertices that have been visited
		boolean[] yVisited = new boolean[vertex]; 
		int countX = 0;
		int countY = 0;
		xPath[countX] = x;
		yPath[countY] = y;
		for(int i = 0; i < vertex; i++)
		{
			xVisited[i] = false;		
			yVisited[i] = false;		
		}
		for(int j = 0; j < vertex; j++)
		{
			xVisited[x] = true;
			yVisited[y] = true;
			for(int k = 0; k<vertex; k++)
			{
				if(adjacentList[j][k] == 1 && xVisited[j])
				{
					countX++;
					xPath[countX] = k;		
					xVisited[k] = true;
				}
				if(adjacentList[j][k] == 1 && yVisited[j])
				{
					countY++;
					yPath[countY] = k;		
					yVisited[k] = true;
				}
				if(yPath[countY] == xPath[countX]) 
				{
					return yPath[countY];
				}
			}
		}
		return -1; // no ancestor so return -1.
				
    }
    
    public static void main(String[] args)
	{

	}



}
