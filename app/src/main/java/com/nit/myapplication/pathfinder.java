package com.nit.myapplication;
public class pathfinder {
    int adj[][]=new int[10][10];
    int n, startnode, endnode;
    public pathfinder(int snode, int enode)
    {
    	n = 10;
    	startnode = snode; endnode = enode;
    	for(int i = 0; i < n; i++)
    	{
    		for(int j = 0; j < n; j++)
    		{
    			adj[i][j] = 0;
    		}
    	}
    	adj[1][2] = 1; adj[2][3] = 1;
    	adj[2][1] = 1; adj[3][2] = 1;	
    }

    public int bfs(int snode, int enode)
    {
    	// check if the startnode == end node
    	// 0 return value denotes snode == enode
    	// -1 denotes path does not exist
    	// +ve value denotes the node number
    	if(snode == enode) return 0;
    	

    	int num = 100;
    	int q[] = new int[num];
    	int visited[] = new int[num];
    	int pathStack[] = new int[num];
    	int parent[] = new int[num];

    	for(int i = 0; i < num; i++)
    	{
    		q[i] = 0; visited[i] = 0; pathStack[i] = 0;
    	}
    	int qindex = 0, curindex = 0, stackindex = 0, found = 0;
    	q[qindex++] = snode;
    	parent[snode] = -1;
    	visited[snode] = 1;

    	while(curindex < qindex)
    	{
    		int u = q[curindex++];
    		if(u == enode)
    		{
    			while(u != -1)
    			{
    				pathStack[stackindex++] = u;
    				u = parent[u];
    			}
    			found = 1;
    			break;
    		}
    		for(int i = 0; i < n; i++)
    		{
    			if(adj[u][i] == 1 && visited[i] == 0)
    			{
    				q[qindex++] = i; parent[i] = u;
    				visited[i] = 1;
    			}
    		}
    	}
    	if(found == 1)
    	{
    		return pathStack[stackindex - 2];
    	}
    	else return -1;
    }
    public int findNextNode()
    {
    	int nextnode = bfs(startnode, endnode);
   		return nextnode;
    }
}


