import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class DAG {
	
    int vertex;
    int edge;
    int [] outDegree;
    int [] inDegree;
    int [][] adjacentList;

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

}
