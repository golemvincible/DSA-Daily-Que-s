package O6Graph.day4;

import java.util.ArrayList;
import java.util.PriorityQueue;

class Node{
    int node,dis,parent;
    Node(int dis,int node,int parent){
        this.dis=dis;
        this.node=node;
        this.parent=parent;
    }
}
class Pair{
    int node,dis;
    Pair(int node,int dis){
        this.node=node;
        this.dis=dis;
    }
}
public class PrimsAlgo {
    static int spanningTree(int v, int e, int edges[][]){
	    
	    ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
	    
	    for(int i=0;i<v;i++)
	        adj.add(new ArrayList<Pair>());
	    
	    for(int i=0;i<edges.length;i++){
	        adj.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
	        adj.get(edges[i][1]).add(new Pair(edges[i][0],edges[i][2]));
	    }
	    
	    
	    boolean[] vis=new boolean[v];
	    PriorityQueue<Node> q= new PriorityQueue<Node>((x,y) -> x.dis-y.dis);
	    int sum=0;
	    q.offer(new Node(0,0,-1));
	    while(!q.isEmpty()){
	        
	        int node=q.peek().node;
	        int dis=q.peek().dis;
	        int parent=q.peek().parent;
	        q.remove();
	        
	        if(!vis[node]){
	            vis[node]=true;
	            sum=sum+dis;
	            
    	        for(Pair it:adj.get(node)){
    	            int nnode=it.node;
    	            int ndis=it.dis;
    	            
    	            if(!vis[nnode])
    	                q.offer(new Node(ndis,nnode,node));
    	        }
	            
	        }
	        
	    }
	    return sum;
	}

}
