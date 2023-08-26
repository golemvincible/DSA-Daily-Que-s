package O6Graph.day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class CourseScheduleII {
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
    
    public int[] findOrder(int v, int[][] a) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<v;i++)
            adj.add(new ArrayList<Integer>());
        
        for(int[] arr:a){
            adj.get(arr[0]).add(arr[1]);
        }
        ArrayList<Integer> res = kahnsAlgo(adj,v);
        Collections.reverse(res);
        if(res.size()!=v)
            return new int[0];
        int[] r = new int[v];
        int i=0;
        for(Integer it:res)
            r[i++] = it;
        
        return r;
    }
    
}
