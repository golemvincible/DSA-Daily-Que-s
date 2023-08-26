package O6Graph.day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindEventualSafeStates {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res=new ArrayList<>();
        
        int v = graph.length;
        int[] outdegree = new int[v];
        Queue<Integer> q = new LinkedList<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<v;i++)    adj.add(new ArrayList<>());
        
        for(int i=0;i<v;i++){
            for(int j=0;j<graph[i].length;j++){
                adj.get(graph[i][j]).add(i);
            }
            outdegree[i] = graph[i].length;
            
            if(outdegree[i]==0)
                q.offer(i);
        }
        
        while(!q.isEmpty()){
            int n = q.poll();
            
            res.add(n);
            
            for(Integer it:adj.get(n)){
                outdegree[it]--;
                if(outdegree[it]==0)
                    q.offer(it);
            }
        }
        
        Collections.sort(res);
        
        return res;
    }
}
