package O6Graph.day3;

import java.util.ArrayList;
class Pair{
    int node,dis;
    Pair(int node,int dis){
        this.node=node;
        this.dis=dis;
    }
}
public class FindtheCityWiththeSmallestNumberofNeighborsataThresholdDistance{
    private static int floydWarshall(int n,ArrayList<ArrayList<Pair>> adj,int dT){
        int[][] dp = new int[n][n];
        
        //initialization
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j)    
                    dp[i][j]=Integer.MAX_VALUE;
            }
        }
        
        for(int i=0;i<n;i++){
            ArrayList<Pair> a = adj.get(i);
            
            for(Pair it:a){
                int nd = it.node;
                int dis = it.dis;
                
                dp[i][nd] = dis;
            }
        }
        
        //now we only deal with matrix
        for(int via=0;via<n;via++){
            
            for(int i=0;i<n;i++){
                
                for(int j=0;j<n;j++){
                    //now i have to go from i to j
                    /*
                        *to go from i to j
                        *we have to go via
                        *i.e i->j = i->via + via->j
                        *i.e. [i][j] = [i][via] + [via][j]
                        
                    */
                    if(dp[i][via]!=Integer.MAX_VALUE && dp[via][j]!=Integer.MAX_VALUE)
                        dp[i][j] = Math.min(dp[i][j],dp[i][via]+dp[via][j]);
                }
            }
        }
        
        int ans=0,mini=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int c=0;
            for(int j=0;j<n;j++){
                if(dp[i][j]<=dT)
                    c++;
            }
            
            if(c<mini){
                mini=c;
                ans=i;
            }
            else if(c==mini){
                ans = ans>i?ans:i;
            }
        }
        
        
        return ans;
    }
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int dis=edges[i][2];

            adj.get(u).add(new Pair(v,dis));
            adj.get(v).add(new Pair(u,dis));

        }
        
        return floydWarshall(n,adj,distanceThreshold);
    }
}