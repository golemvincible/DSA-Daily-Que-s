package O4DynamicProgramming.day3;

public class SubsetSumProblem {
    static boolean recursive(int n, int arr[], int sum){
        if(sum==0)  return true;

        if(n==0)    return false;

        if(arr[n-1]<=sum)
            return recursive(n-1,arr,sum-arr[n-1]) || recursive(n-1,arr,sum);

        return recursive(n-1,arr,sum);

    }

    static boolean isSubsetSum(int N, int arr[], int sum){
        return recursive(N,arr,sum);
    }
    private static int memoize(int n, int arr[], int sum,int[][] dp){
        if(sum==0)  return 1;

        if(n==0)    return 0;

        if(dp[n][sum]!=-1)
            return dp[n][sum];

        if(arr[n-1]<=sum){
            if(memoize(n-1,arr,sum-arr[n-1],dp)!=0 || memoize(n-1,arr,sum,dp)!=0)
                return dp[n][sum]=1;
            return dp[n][sum]=0;
        }

        dp[n][sum] = memoize(n-1,arr,sum,dp);

        return dp[n][sum];
    }
    private static int[][] fill(int[][] dp){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[1].length;j++)
                dp[i][j]=-1;
        }
        return dp;
    }
    private static boolean tabulation(int n, int arr[], int sum,int[][] dp){
        for(int i=0;i<=5;i++){
            dp[i][0] = 1;
        }
        for(int i=1;i<=sum;i++)
            dp[0][i] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if(arr[i-1]<=j){
                    if(dp[i-1][j-arr[i-1]] !=0 || dp[i-1][j] !=0)
                        dp[i][j]=1;
                    else
                        dp[i][j]=0;
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][sum]==0?false:true;
    }
    public static void main(String[] args) {
        int[] a = {2,3,9,8,10};
        int sum=11;
        int[][] dp = new int[5+1][sum+1];
        dp = fill(dp);
        System.out.println(isSubsetSum(5,a,sum));
        for(int i=0;i<=5;i++){
            dp[i][0] = 1;
        }
        for(int i=1;i<=sum;i++)
            dp[0][i] = 0;

        System.out.println(memoize(5,a,sum,dp));

        dp = fill(dp);

        System.out.println(tabulation(5,a,sum,dp));

    }
}
