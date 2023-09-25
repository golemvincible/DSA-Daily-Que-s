package O6Graph.day3;

import java.util.ArrayList;

public class BellmanFordAlgorithm{
    static int[] bellman_ford(int n, ArrayList<ArrayList<Integer>> edges, int s) {
        int[] dist = new int[n];
        for(int i=0;i<n;i++)
            dist[i]=(int)(1e8);
            // dist[i]=Integer.MAX_VALUE;
        dist[s]=0;
        for(int i=0;i<n-1;i++){
            for(ArrayList<Integer> it:edges){
                int u=it.get(0);
                int v=it.get(1);
                int dis=it.get(2);
                
                if(dist[u]+dis<dist[v] && dist[u]!=1e8){
                    dist[v]=dist[u]+dis;
                }
            }
        }
        
        //checking for -ve cycle by iterating 1 more time
        for(ArrayList<Integer> it:edges){
            int u=it.get(0);
            int v=it.get(1);
            int dis=it.get(2);
            if(dist[u]+dis<dist[v] && dist[u]!=1e8){
                int[] temp = new int[1];
                temp[0]=-1;
                return temp;
            }
        }
        return dist;
    }
}