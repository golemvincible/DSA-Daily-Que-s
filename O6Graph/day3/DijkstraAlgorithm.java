package O6Graph.day3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
class Pair{
    int node,dis;
    Pair(int node,int dis){
        this.node=node;
        this.dis=dis;
    }
}
public class DijkstraAlgorithm {
    static int[] dijkstra(int v, ArrayList<ArrayList<ArrayList<Integer>>> adj, int s)
    {
        int[] dis = new int[v];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[s]=0;
        
        PriorityQueue<Pair> q = new PriorityQueue<>((Pair a,Pair b) ->{
            if(a.dis!=b.dis)
                return a.dis-b.dis;
            else
                return a.node-b.node;
        });
        
        q.offer(new Pair(s,0));
        
        while(!q.isEmpty()){
            Pair p = q.poll();
            
            
                for(ArrayList<Integer> it:adj.get(p.node)){
                    int nd = it.get(0);
                    int ds = it.get(1);
                    int ndis = p.dis + ds;
                    
                    if(ndis<dis[nd]){
                        dis[nd]=ndis;
                        q.offer(new Pair(nd,dis[nd]));
                    }
                }
            
        }
        
        return dis;
    }
}
