package O6Graph.day3;
class Node{
    int dis,r,c;
    Node(int dis,int r,int c){
        this.dis=dis;
        this.r=r;
        this.c=c;
    }
}
public class PathWithMinimumEffort {
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<Node> pq = new PriorityQueue<Node>((x,y) -> x.dis - y.dis);
        
        int m=heights.length;
        int n=heights[0].length;
        
        int[][] dist = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++)
                dist[i][j]=Integer.MAX_VALUE;
        }
        dist[0][0]=0;
        pq.offer(new Node(0,0,0));
        
        int[] dr = {0,1,-1,0};
        int[] dc = {1,0,0,-1};
        
        while(!pq.isEmpty()){
            int r = pq.peek().r;
            int c = pq.peek().c;
            int diff = pq.peek().dis;
            pq.remove();
            
            if(r==m-1 && c==n-1)
                return diff;
            
            for(int i=0;i<dr.length;i++){
                int nr = dr[i]+r;
                int nc = dc[i]+c;
                
                if(nr>=m || nc>=n || nr<0 || nc<0)  
                    continue;
                int neweffort = Math.max(Math.abs(heights[nr][nc]-heights[r][c]),diff);
                if(neweffort<dist[nr][nc]){
                    dist[nr][nc]=neweffort;
                    pq.offer(new Node(neweffort,nr,nc));
                }
            }
            
        }
        return 0;
    }
}
