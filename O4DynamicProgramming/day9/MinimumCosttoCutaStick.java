package O4DynamicProgramming.day9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimumCosttoCutaStick {
    private static int solve(List<Integer> cuts,int i,int j,int[][] dp){
        if(i>j) return 0;

        if(dp[i][j]!=-1)    return dp[i][j];


        int min = Integer.MAX_VALUE;

        for(int k=i;k<=j;k++){

            int currcost = cuts.get(j+1)-cuts.get(i-1);

            int left = dp[i][k-1]!=-1?dp[i][k-1]:solve(cuts,i,k-1,dp);
            int right = dp[k+1][j]!=-1?dp[k+1][j]:solve(cuts,k+1,j,dp);
            // System.out.println(i + " " + j);
            int temp = left + right + currcost;
            min = Math.min(min,temp);
        }

        return dp[i][j] = min;
    }

    private static int solveTab(List<Integer> cuts,int c){
        int[][] dp = new int[c+2][c+2];

        // 1 -> n

        for(int i=c;i>=1;i--){
            for(int j=1;j<=c;j++){

                if(i>j) continue;

                int min = Integer.MAX_VALUE;

                for(int k=i;k<=j;k++){

                    int currcost = cuts.get(j+1)-cuts.get(i-1);

                    int left = dp[i][k-1];
                    int right = dp[k+1][j];

                    // System.out.println(i + " " + j);
                    int temp = left + right + currcost;
                    min = Math.min(min,temp);
                }
                dp[i][j]=min;
            }
        }
        return dp[1][c];
    }

    private static void fill(int[][] dp){
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j]=-1;
            }
        }
    }
    public static int minCost(int n, int[] cuts) {
        int c = cuts.length;

        List<Integer> cut = new ArrayList<>();
        cut.add(0);
        // cut.addAll(cuts);

        for(int it:cuts)
            cut.add(it);


        cut.add(n);
        Collections.sort(cut);
        int[][] dp = new int[c+1][c+1];
        fill(dp);
        // return solve(cut,1,c,dp);
        return solveTab(cut,c);
    }

    public static void main(String[] args) {
        System.out.println(minCost(7,new int[]{1,3,4,5}));
    }
}
