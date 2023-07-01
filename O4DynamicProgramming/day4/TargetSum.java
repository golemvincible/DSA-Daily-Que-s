package O4DynamicProgramming.day4;

public class TargetSum {
    private static int tabulation(int[] nums,int rs,int n,int[][] dp){
        int mod = (int)1e9+7;

        dp[0][0]=1;

        for (int i = 1; i <= rs; i++) {
            dp[0][i]=0;
        }
        for(int i=1;i<=n;i++){
            for(int j=0;j<=rs;j++){

                if(j>=nums[i-1]){
                    dp[i][j] = (dp[i-1][j-nums[i-1]] + dp[i-1][j])%mod;
                }
                else
                    dp[i][j]=dp[i-1][j]%mod;
            }
        }
        return dp[n][rs]%mod;
    }

    private static int[][] fill(int[][] dp){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[1].length;j++)
                dp[i][j]=-1;
        }
        return dp;
    }
    private static void sort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]<arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
    public static int perfectSum(int arr[],int n, int sum)
    {
        int[][] dp = new int[n+1][sum+1];
        dp = fill(dp);

        sort(arr);

        return tabulation(arr,sum,n,dp);
    }

    private static int subsetsWithDiff(int[] a,int n,int diff){
        int sum=0;
        int mod = (int)1e9+7;
        for (int i :
                a) {
            sum+= i%mod;
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
        if(sum-diff < 0 || (diff+sum)%2!=0 || Math.abs(diff)>sum) return 0;

        int sumS1 = (diff+sum)/2;



        return perfectSum(a,n,sumS1)%mod;
    }
    public static int findTargetSumWays(int[] nums, int target) {
        return subsetsWithDiff(nums,nums.length,target);
    }

    public static void main(String[] args) {
        int[] arr = {1,1,2,3};

        int n=arr.length,target=1;

        System.out.println(findTargetSumWays(arr,target));
    }
}
