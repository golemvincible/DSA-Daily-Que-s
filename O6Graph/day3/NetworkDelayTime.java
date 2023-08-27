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
public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        int[] dist = new int[n+1];
        
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<Pair>());
            dist[i]=Integer.MAX_VALUE;
        }
        
        for(int i=0;i<times.length;i++){
            adj.get(times[i][0]).add(new Pair(times[i][1],times[i][2]));
        }
        
        dist[k]=0;
        dist[0]=0;
        PriorityQueue<Pair> q = new PriorityQueue<>((Pair a,Pair b)->{
           return a.dis-b.dis; 
        });
        
        q.offer(new Pair(k,0));
        while(!q.isEmpty()){
            Pair p = q.poll();
            
            for(Pair it:adj.get(p.node)){
                if(p.dis+it.dis<dist[it.node]){
                    q.offer(new Pair(it.node,p.dis+it.dis));
                    dist[it.node]=p.dis+it.dis;
                }
            }
        }
        int maxi=-1;
        for(Integer it:dist)
            maxi=Math.max(it,maxi);
        
        return maxi!=Integer.MAX_VALUE?maxi:-1;
    }
}
