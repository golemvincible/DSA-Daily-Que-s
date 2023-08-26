package O6Graph.day2;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort{
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