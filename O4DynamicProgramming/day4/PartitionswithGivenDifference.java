package O4DynamicProgramming.day4;

public class PartitionswithGivenDifference {
    private static int perfectSumTabulation(int[] nums,int rs,int n,int[][] dp){
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
    public static int perfectSum(int[] arr,int n, int sum)
    {
        int[][] dp = new int[n+1][sum+1];
        dp = fill(dp);
        return perfectSumTabulation(arr,sum,n,dp);
    }
    private static int subsetsWithDiff(int[] a,int n,int diff){
        int sum=0;

        for (int i :
                a) {
            sum += i;
        }

        /*
        * sum(s1) + sum(s2) = sum(arr)  -(1)
        * sum(s1) - sum(s2) = diff      -(2)
        *
        * adding (1) and (2)
        *
        * sum(s1) = (sum(arr) + diff)/2
        *
        * so, now consider this array as example -> 1 1 2 3   diff = 1
        *
        * so, sum(arr) = 7 , diff = 1    => (7+1)/2 => 8/2 = 4 i.e. => sum(s1) = 4
        *
        * so humne mathematically nikal liya ke subset 1 ka sum 4 hona chahiye to unka difference automatically
        * 1 ho jayega
        *
        * so ab hume bss vo saare subsets count karne hai jinka sum 4 hoga
        */
        int sumS1 = (diff+sum)/2;
        System.out.println(sumS1);

        return perfectSum(a,n,sumS1);
    }
    public static void main(String[] args) {
        int[] a = {5, 2, 6, 4};
        int diff = 3;
        int n=a.length;

        System.out.println(subsetsWithDiff(a,n,diff));
    }   
}
