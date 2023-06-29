package O4DynamicProgramming.day3;

public class PerfectSumProblem {
    private static int recursive(int[] nums,int rs,int n){
        if(rs==0)
            return 1;

        if(n==0)
            return 0;

        if(rs>=nums[n-1]){
            return recursive(nums,rs-nums[n-1],n-1)+recursive(nums,rs,n-1);
        }

        return recursive(nums,rs,n-1);
    }
    private static int tabulation(int[] nums,int rs,int n,int[][] dp){
        for (int i = 0; i <= n; i++) {
            dp[i][0]=1;
        }

        for (int i = 1; i <= rs; i++) {
            dp[0][i]=0;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=rs;j++){

                if(j>=nums[i-1]){
                    dp[i][j] = dp[i-1][j-nums[i-1]] + dp[i-1][j];
                }
                else
                    dp[i][j]=dp[i-1][j];
            }
        }
        return dp[n][rs];
    }
    private static int[][] fill(int[][] dp){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[1].length;j++)
                dp[i][j]=-1;
        }
        return dp;
    }
    public static int perfectSum(int arr[],int n, int sum)
    {
        int[][] dp = new int[n+1][sum+1];
        dp = fill(dp);
        return tabulation(arr,sum,n,dp);
    }
}
