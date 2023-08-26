package O6Graph.day2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TopologicalSort{
    //bfs is this
    private static int[] kahnsAlgo(ArrayList<ArrayList<Integer>> adj,int v){
        int[] res = new int[v];
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
            res[i++] = n;
            //reducing indegree of its adj nodes
            for(Integer it:adj.get(n)){
                indegree[it]--;
                if(indegree[it]==0)
                    q.offer(it);
            }
        }
        
        return res;
    }
    private static void dfs(ArrayList<ArrayList<Integer>> adj,int v,Stack<Integer> st,int node,boolean[] vis){
        vis[node] = true;

        for(Integer it: adj.get(node)){
            if(!vis[it])
                dfs(adj,v,st,it,vis);
        }
        st.push(node);
    }
    static int[] topoSort(int v, ArrayList<ArrayList<Integer>> adj) 
    {
        Stack<Integer> st = new Stack<>();
        boolean[] vis = new boolean[v+1];

        for(int i=0;i<v;i++){
            if(!vis[i])
                dfs(adj,v,st,i,vis);
        }
        
        int[] res = new int[v];
        
        int i=0;
        while(!st.isEmpty())
            res[i++] = st.pop();
        return res;
    }
}