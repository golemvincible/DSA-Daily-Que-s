package O4DynamicProgramming.day4;

public class O1Knapsack {
    private static int knapSackRecursive(int w, int wt[], int val[], int n)
    {
        if(w==0 || n==0)
            return 0;

        //include
        if(w>=wt[n-1]){
            return Math.max(val[n-1] + knapSackRecursive(w-wt[n-1],wt,val,n-1),knapSackRecursive(w,wt,val,n-1));
        }
        
        //exclude because out of capacity
        return knapSackRecursive(w,wt,val,n-1);
    }
    private static int knapSackRecursiveMem(int w, int wt[], int val[], int n,int[][] dp)
    {
        if(w<=0 || n==0)
            return 0;

        if(dp[n][w]!=-1)
            return dp[n][w];
        //include
        if(w>=wt[n-1]){
            dp[n][w] = Math.max(val[n-1] + knapSackRecursiveMem(w-wt[n-1],wt,val,n-1,dp),knapSackRecursiveMem(w,wt,val,n-1,dp));
            return dp[n][w];
        }

        dp[n][w] = knapSackRecursiveMem(w,wt,val,n-1,dp);
        return dp[n][w];
    }
    private static int topDown(int w, int wt[], int val[], int n,int[][] dp){

        //base condition init
        for(int i=1;i<n+1;i++){
            for(int j=1;j<w+1;j++)
                dp[i][j]=-1;
        }

        for(int i=1;i<n+1;i++){
            for(int remainingCap=1;remainingCap<w+1;remainingCap++){
                //include
                if(wt[i-1]<=remainingCap){
                    dp[i][remainingCap] = Math.max(val[i-1] + dp[i-1][remainingCap-wt[i-1]],dp[i-1][remainingCap]);

                }
                //exclude
                else
                    dp[i][remainingCap] = dp[i-1][remainingCap];
            }
        }
        return dp[n][w];
    }
    public static void main(String[] args) {
        int[] val = {1,2,3};
        int[] wt = {4,5,1};
        int w=4;
        int n=3;
        int[][] dp = new int[n+1][w+1];
//        for(int[] it:dp){
//            for(int i=0;i<dp[0].length;i++)
//                it[i] = -1;
//        }

        System.out.println(topDown(4,wt,val,3,dp));
    }
}
