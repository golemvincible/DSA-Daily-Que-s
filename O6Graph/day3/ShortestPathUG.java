package O6Graph.day3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathUG {
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }
        
        for(int i=0;i<m;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        
        int[] dis = new int[n];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[src]=0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        
        while(!q.isEmpty()){
            int nd = q.poll();
            
            for(Integer it:adj.get(nd)){
                int ndis = dis[nd] + 1;
                if(ndis<dis[it]){
                    dis[it]=ndis;
                    q.offer(it);
                }
            }
        }
        
        for(int i=0;i<n;i++){
            if(dis[i]==Integer.MAX_VALUE)
                dis[i] = -1;
        }
        
        return dis;
    }
}
