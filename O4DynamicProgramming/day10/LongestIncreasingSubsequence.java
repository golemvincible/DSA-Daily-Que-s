package O4DynamicProgramming.day10;

public class LongestIncreasingSubsequence {
    private static int solve(int[] nums,int curr,int prv,int[][] dp){
        if(curr<0) return 0;
        
        int maxi = 0;
        
        if(dp[curr][prv+1]!=-1) return dp[curr][prv+1];
        
        //inc
        if(prv==-1 || nums[curr]<nums[prv]){
            maxi = solve(nums,curr-1,curr,dp) + 1;
        }
        
        //exc
        maxi = Math.max(maxi,solve(nums,curr-1,prv,dp));
        
        return dp[curr][prv+1] = maxi;
    }
        private static void fill(int[][] dp){
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j]=-1;
            }
        }
    }
    public int lengthOfLIS(int[] nums) {
        //because we need to store -1 as prv ind 
        int[][] dp = new int[nums.length+1][nums.length+2];
        
        fill(dp);
        
        return solve(nums,nums.length-1,-1,dp);
    }
}
