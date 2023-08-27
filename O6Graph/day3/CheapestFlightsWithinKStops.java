package O6Graph.day3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
class Pair{
    int node,dis;
    Pair(int node,int dis){
        this.node=node;
        this.dis=dis;
    }
}
class Node{
    int dis,stop,node;
    Node(int dis,int stop,int node){
        this.dis=dis;
        this.stop=stop;
        this.node=node;
    }
}
public class CheapestFlightsWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        int[] dist = new int[n];
        
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Pair>());
            dist[i]=Integer.MAX_VALUE;
        }
        
        
        for(int i=0;i<flights.length;i++){
            adj.get(flights[i][0]).add(new Pair(flights[i][1],flights[i][2]));
        }
        
        // PriorityQueue<Node> pq = new PriorityQueue<Node>((x,y) -> x.dis-y.dis);
        Queue<Node> pq = new LinkedList<>();
        pq.offer(new Node(0,0,src));
        dist[src]=0;
        
        while(!pq.isEmpty()){
            int node = pq.peek().node;
            int stop = pq.peek().stop;
            int dis = pq.peek().dis;
            pq.remove();
            
            // if(node==dst){
            //     return dis;
            // }
            
            for(Pair it:adj.get(node)){
                int nnode=it.node;
                int nndis=it.dis;
                if(nndis+dis<dist[nnode] && stop<=k){
                    dist[nnode]=nndis+dis;
                    pq.offer(new Node(dist[nnode],stop+1,nnode));
                }
            }
        }
        if(dist[dst]!=Integer.MAX_VALUE){
            return dist[dst];
        }
        return -1;
    }
}
