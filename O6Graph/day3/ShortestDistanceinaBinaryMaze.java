package O6Graph.day3;

import java.util.PriorityQueue;

class Node{
    int dis,x,y;
    Node(int dis,int x,int y){
        this.dis=dis;
        this.x=x;
        this.y=y;
    }
}
public class ShortestDistanceinaBinaryMaze {
    private static void fill(int[][] dis){
        for(int i=0;i<dis.length;i++){
            for(int j=0;j<dis[0].length;j++){
                dis[i][j]=Integer.MAX_VALUE;
            }
        }
    }
    int shortestPath(int[][] grid, int[] source, int[] destination) {
        
        if(grid[source[0]][source[1]]==0)   return -1;
        
        int n = grid.length,m=grid[0].length;
        int[][] dis = new int[n][m];
        
        fill(dis);
        
        dis[source[0]][source[1]]=0;
        
        PriorityQueue<Node> q = new PriorityQueue<>((Node a,Node b)->{
           return a.dis-b.dis; 
        });
        
        q.offer(new Node(0,source[0],source[1]));
        int[] xd = {1,-1,0,0};
        int[] yd = {0,0,-1,1};
        
        while(!q.isEmpty()){
            Node nd = q.poll();
            
            int x = nd.x;
            int y = nd.y;
            int ds = nd.dis;
            
            for(int i=0;i<xd.length;i++){
                
                int nx = x+xd[i];
                int ny = y+yd[i];
                
                if(nx<0 || ny<0 || nx>=n || ny>=m || grid[nx][ny]==0)   continue;
                
                if(ds+1 <dis[nx][ny]){
                    q.offer(new Node(ds+1,nx,ny));
                    dis[nx][ny] = ds+1;
                }
            }
        }
        
        return dis[destination[0]][destination[1]]==Integer.MAX_VALUE?-1:dis[destination[0]][destination[1]];
    }
}
