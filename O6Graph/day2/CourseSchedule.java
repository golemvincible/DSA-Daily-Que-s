package O6Graph.day2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {
    private static boolean dfs(ArrayList<ArrayList<Integer>> adj,int v,boolean[] vis,boolean[] pathVis,int node){
        vis[node]=true;
        pathVis[node]=true;
        
        for(Integer it:adj.get(node)){
            if(!vis[it]){
                if(dfs(adj,v,vis,pathVis,it))
                    return true;
            }
            else if(vis[it] && pathVis[it])
                return true;
        }
        pathVis[node] = false;
        return false;
    }
    private static ArrayList<Integer> kahnsAlgo(ArrayList<ArrayList<Integer>> adj,int v){
        ArrayList<Integer> res = new ArrayList<>();
        int[] indegree = new int[v];
        
        Queue<Integer> q = new LinkedList<>();
        
        //filling indegree
        for(int i=0;i<v;i++){
            for(Integer it:adj.get(i)){
                indegree[it]++;
            }
        }
        //initializing q
        for(int i=0;i<v;i++){
            if(indegree[i]==0)  q.offer(i);
        }
        int i=0;
        while(!q.isEmpty()){
            int n = q.poll();
            res.add(n);
            //reducing indegree of its adj nodes
            for(Integer it:adj.get(n)){
                indegree[it]--;
                if(indegree[it]==0)
                    q.offer(it);
            }
        }
        
        return res;
    }
    
    public boolean canFinish(int v, int[][] a) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<v;i++)
            adj.add(new ArrayList<Integer>());
        
        for(int[] arr:a){
            adj.get(arr[0]).add(arr[1]);
        }
        
        // return v==kahnsAlgo(adj,v).size();
        boolean[] vis = new boolean[v];
        boolean[] pathVis = new boolean[v];
        
        for(int i=0;i<v;i++){
            if(!vis[i]){
                if(dfs(adj,v,vis,pathVis,i))
                    return false;
            }
        }
        return true;
    }
}
