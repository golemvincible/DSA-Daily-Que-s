package O6Graph.day4;
import java.util.*;

class DSU{
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    public DSU(int n) {
        for(int i = 0;i<=n;i++) {
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }
    public int findPar(int node) {
        if(node == parent.get(node)) {
            return node;
        }
        int ulp = findPar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }
    public void unionByRank(int u, int v) {
        int ulp_u = findPar(u);
        int ulp_v = findPar(v);
        if(ulp_u == ulp_v) return;
        if(rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
        }
        else if(rank.get(ulp_v) < rank.get(ulp_u)) {
            parent.set(ulp_v, ulp_u);
        }
        else {
            parent.set(ulp_v, ulp_u);
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u, rankU + 1);
        }
    }
    public void unionBysize(int u, int v) {
        int ulp_u = findPar(u);
        int ulp_v = findPar(v);
        if(ulp_u == ulp_v) return;
        if(size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        }
        else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}
public class NumberofOperationstoMakeNetworkConnected {
    public int makeConnected(int n, int[][] c) {
        DSU dsu = new DSU(n);
        int extra=0;
        
        for(int i=0;i<c.length;i++){
            int ulp_u = dsu.findPar(c[i][0]);
            int ulp_v = dsu.findPar(c[i][1]);

            
            if(ulp_u!=ulp_v)
                dsu.unionBysize(c[i][0],c[i][1]);
            
            else
                extra++;
        }
        
        //to find no. of components
        int comp=0;
        for(int i=0;i<n;i++){
            if(dsu.findPar(i)==i)
                comp++;
        }
        
        
        //we know if there are n vertices, min no. of edges should be n-1
        
        return extra>=comp-1?comp-1:-1;
    }
}
