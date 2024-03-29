package O6Graph.day2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CycleDetection {
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
    public boolean isCyclic(int v, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> res = kahnsAlgo(adj,v);
        
        return res.size()!=v;
    }
}
