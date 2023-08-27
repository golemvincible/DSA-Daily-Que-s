package O6Graph.day3;

import java.util.ArrayList;
import java.util.PriorityQueue;
class Pair{
    int node,dis;
    Pair(int node,int dis){
        this.node=node;
        this.dis=dis;
    }
}
public class NumberofWaystoArriveatDestination {
    public int countPaths(int n, int[][] roads) {
        if(roads.length==1)
            return 1;
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        int[] dist = new int[n];
        int[] path = new int[n];

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Pair>());
            dist[i]=Integer.MAX_VALUE;
            path[i]=0;
        }
        dist[0]=0;
        path[0]=1;
        
        for(int i=0;i<roads.length;i++){
            adj.get(roads[i][0]).add(new Pair(roads[i][1],roads[i][2]));
            adj.get(roads[i][1]).add(new Pair(roads[i][0],roads[i][2]));
        }
        
        // Queue<Pair> q = new LinkedList<>();
        PriorityQueue<Pair> q = new PriorityQueue<Pair>((x,y) -> x.dis-y.dis);
        
        q.offer(new Pair(0,0));
        
        while(!q.isEmpty()){
            int node=q.peek().node;
            int dis=q.peek().dis;
            q.remove();
            
            for(Pair it:adj.get(node)){
                int nnode=it.node;
                int ndis=it.dis;
                if(dis+ndis<dist[nnode]){
                    dist[nnode]=dis+ndis;
                    q.offer(new Pair(nnode,dist[nnode]));
                    path[nnode]=path[node];
                }else if(dis+ndis==dist[nnode]){
                    path[nnode]=(path[nnode]+path[node])%(1000000000+7);
                }
            }
        }
        return path[n-1];
    }
}
