package O6Graph.day3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
class Pair{
    int node, dis;
    Pair(int node,int dis){
        this.node=node;
        this.dis=dis;
    }
}
public class ShortestPathDAG {
    public int[] shortestPath(int n,int m, int[][] edges) {
		ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
		
		
		for(int i=0;i<n;i++){
		    adj.add(new ArrayList<Pair>());    
		}
		
		for(int i=0;i<m;i++){
		    adj.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
		}
		
		int[] dis = new int[n];
		Arrays.fill(dis,Integer.MAX_VALUE);
		
		//topo sort
		Queue<Integer> q = new LinkedList<>();
		
		List<Integer> topo = new ArrayList<>();
		int[] indegree = new int[n];
		
		for(int i=0;i<n;i++){
		    for(Pair it:adj.get(i)){
		        indegree[it.node]++;
		    }
		}
		
		for(int i=0;i<n;i++){
		    if(indegree[i]==0)  q.offer(i);
		}
		
		while(!q.isEmpty()){
		    int nd = q.poll();
		    topo.add(nd);
		    
		    for(Pair it:adj.get(nd)){
		        indegree[it.node]--;
		        if(indegree[it.node]==0)
		            q.offer(it.node);
		    }
		}
		
		//till now we got topo sort
		
		dis[0]=0;
		
		for(Integer it:topo){
		    for(Pair p : adj.get(it)){
		        int nd = p.node;
		        int d = p.dis;
		        if(dis[it]==Integer.MAX_VALUE){
		            dis[it]=-1;
		            break;
		        }
		            
		        int ndis = dis[it]+d;
		        if(ndis<dis[nd]){
		            dis[nd]=ndis;
		        }
		    }
		}
		for(int i=0;i<n;i++){
		    if(dis[i]==Integer.MAX_VALUE)
		        dis[i]=-1;
		}
		
	    return dis;
	}
}
