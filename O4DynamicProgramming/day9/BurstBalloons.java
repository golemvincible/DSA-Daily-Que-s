package O4DynamicProgramming.day9;

import java.util.ArrayList;
import java.util.List;

public class BurstBalloons {
    private static int solveTab(List<Integer> arr,int n){
        int[][] dp = new int[n+2][n+2];

        for(int i=n;i>=1;i--){
            for (int j = 1; j <= n; j++) {

                if(i>j) continue;

                int max = Integer.MIN_VALUE;

                for(int k=i;k<=j;k++){
                    int temp = dp[i][k-1] + dp[k+1][j] + arr.get(i-1) * arr.get(j+1) * arr.get(k);

                    max = Math.max(temp,max);
                }

                dp[i][j] = max;
            }
        }

        return dp[1][n];
    }
    private static int solve(List<Integer> arr,int i,int j,int[][] dp){
        if(i>j) return 0;

        if(dp[i][j]!=-1)    return dp[i][j];

        int max = Integer.MIN_VALUE;

        for(int k=i;k<=j;k++){
            int temp = solve(arr,i,k-1,dp) + solve(arr,k+1,j,dp) + arr.get(i-1) * arr.get(j+1) * arr.get(k);

            max = Math.max(temp,max);
        }

        return dp[i][j] = max;
    }
    private static void fill(int[][] dp){
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j]=-1;
            }
        }
    }
    public static int maxCoins(int[] nums) {
        List<Integer> arr = new ArrayList<>();

        arr.add(1);
        for(int i:nums) arr.add(i);
        arr.add(1);
        System.out.println(arr);

        /*
         * we inserted 1 at beginning and at ending
         * so now nums indexes in arr array starts from 1 and ends at nums.length that's why we passed it
         */
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];
        fill(dp);
        return solve(arr,1,nums.length,dp);
    }

    public static void main(String[] args) {
        System.out.println(maxCoins(new int[]{3,1,5,8}));
    }
}