package O6Graph.day4;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class DisjointSet{
    List<Integer> parent = new ArrayList<>();
    List<Integer> rank = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    
    public DisjointSet(int n){
        for(int i=0;i<n;i++){
            parent.add(i);
            rank.add(0);
            size.add(1);
        }
    }
    
    public int findParent(int node){
        if(node == parent.get(node)) {
            return node;
        }
        int ulp = findParent(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }
    
    public void unionByRank(int u,int v){
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);
        
        if(rank.get(ulp_u)<rank.get(ulp_v)){
            
            parent.set(ulp_u,ulp_v);
            
        }
        
        else if(rank.get(ulp_u)>rank.get(ulp_v)){
            
            parent.set(ulp_v,ulp_u);
            
        }
        else{
            parent.set(ulp_v,ulp_u);
            rank.set(ulp_u,rank.get(ulp_u)+1);
        }
    }
    
    public void unionBySize(int u,int v){
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);
        
        if(size.get(ulp_u)<size.get(ulp_v)){
            
            parent.set(ulp_u,ulp_v);
            size.set(ulp_v,size.get(ulp_v)+size.get(ulp_u));
        }
        
        else {
            
            parent.set(ulp_v,ulp_u);
            size.set(ulp_u,size.get(ulp_u)+size.get(ulp_v));
        }
        
    }
}
class Node{
    int u,v,dis;
    
    Node(int u,int v,int dis){
        this.u=u;
        this.v=v;
        this.dis=dis;
    }
}
public class KruskalsAlgo {
    static int spanningTree(int V, int E, int edges[][]){
	    
	    PriorityQueue<Node> q = new PriorityQueue<>((Node a,Node b)->{
	        return a.dis-b.dis;
	    });
	    
	    for(int i=0;i<edges.length;i++){
	        
	        for(int j=0;j<3;j++){
	            q.offer(new Node(edges[i][0],edges[i][1],edges[i][2]));
	        }
	    }
	    
	    int sum=0;
	    DisjointSet ds = new DisjointSet(V);
	    
	    while(!q.isEmpty()){
	        Node n = q.poll();
	        
	        int u = n.u;
	        int v = n.v;
	        int dis = n.dis;
	        
	        //if u and v's ultimate parent are diffrent that means they belong to different componenets
            if(ds.findParent(u)!=ds.findParent(v)){
                sum+=dis;
                ds.unionBySize(u,v);
            }

	    }
	    
	    return sum;
	}
}
