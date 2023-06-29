package O4DynamicProgramming.day3;

public class PartitionEqualSubsetSum {
    private static boolean recursive(int[] nums,int n,int rs,int sum){
        if(rs==sum) return true;

        if(n==0)    return false;

        if(rs>=nums[n-1]){
            return recursive(nums,n-1,rs-nums[n-1],sum+nums[n-1]) || recursive(nums,n-1,rs,sum);
        }

        return recursive(nums,n-1,rs,sum);
    }
    private static int[][] fill(int[][] dp){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[1].length;j++)
                dp[i][j]=-1;
        }
        return dp;
    }
    private static boolean recursive2(int[] nums,int n,int rs){
        if(rs==0) return true;

        if(n==0)    return false;

        if(rs>=nums[n-1]){
            return recursive2(nums,n-1,rs-nums[n-1]) || recursive2(nums,n-1,rs);
        }

        return recursive2(nums,n-1,rs);
    }
    private static boolean tabulation(int[] nums,int n,int rs){
        int[][] dp = new int[n+1][rs+1];

        dp = fill(dp);

        for(int i=0;i<=n;i++){
            dp[i][0] = 1;
        }

        for(int i=1;i<=rs;i++){
            dp[0][i]=0;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=rs;j++){

                if(j>=nums[i-1]){
                    if(dp[i-1][j-nums[i-1]]!=0 || dp[i-1][j]!=0)
                        dp[i][j]=1;
                    else
                        dp[i][j]=0;
                }
                else
                    dp[i][j]=dp[i-1][j];
            }
        }

        return dp[n][rs]==0?false:true;
    }
    public static boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum=0;
        int rs=0;

        for(int i:nums)
            rs+=i;

//        return recursive(nums,n,rs,sum);
        return tabulation(nums,n,rs/2);
    }

    public static void main(String[] args) {
        int[] a = {2,3,9,8,10};

        System.out.println(canPartition(a));
    }
}
