package src.Recursion.Backtracking;

import java.util.ArrayList;

public class RatInAMaze {
    public static void main(String[] args) {
        int[][] m = {{1, 0},
                    {1, 0}};
        int n=2;
        System.out.println(findPath(m,n));
    }

    private static void dfs(int[][] m, int n,boolean[][] vis,ArrayList<String> res,String route,int x,int y){

        if(x<0 || y<0 || x>=n || y>=n || m[x][y]==0 || vis[x][y])
            return;

        //got a valid answer because we reached destination
        if(x==n-1 && y==n-1){
            vis[n-1][n-1]=true;
            res.add(route);
            return;
        }

        vis[x][y]=true;

        //down
        dfs(m,n,vis,res,route+'D',x+1,y);

        //right
        dfs(m,n,vis,res,route+'R',x,y+1);

        //left
        dfs(m,n,vis,res,route+'L',x,y-1);

        //up
        dfs(m,n,vis,res,route+'U',x-1,y);

        //backtracking
        vis[x][y]=false;
    }
    public static ArrayList<String> findPath(int[][] m, int n) {

        boolean[][] vis = new boolean[n][n];

        ArrayList<String> res = new ArrayList<>();
        boolean reached=false;

        dfs(m,n,vis,res,"",0,0);
        ArrayList<String> emp=new ArrayList<>();
        emp.add("-1");
        return res.isEmpty()?emp:res;
    }
}
