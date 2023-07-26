package O4DynamicProgramming.day10;

public class LongestIncreasingSubsequence {
    static int ans = 0;
    public static int lengthOfLISOptimised(int[] nums) {
        
        // if(nums.length==1 && nums[0]==0)  return 0;
        
        int n = nums.length;
        
        //dp will store 
        int[] dp = new int[n];  
        
        for(int i=0;i<n;i++)   dp[i]=1;
        
        for(int i=0;i<n;i++){
            //maxi from dp
            int maxi=0, ele = nums[i];
            
            for(int j=0;j<i;j++){
                if(nums[j]<ele){
                    //then we need to find maximum of all nums[j]<ele from their dp array
                    maxi = Math.max(maxi,dp[j]);
                }
            }
            dp[i] = dp[i] + maxi;
            ans = Math.max(ans,dp[i]);
        }
        
        return ans;
    }
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
