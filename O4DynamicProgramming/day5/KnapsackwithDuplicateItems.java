package O4DynamicProgramming.day5;

public class KnapsackwithDuplicateItems {
    private static int tabulation(int n,int w,int[] val,int[] wt,int[][] dp){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=w;j++){
                if(wt[i-1]<=j){
                    dp[i][j] = Math.max(val[i-1]+dp[i][j-wt[i-1]],dp[i-1][j]);
                }else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][w];
    }
    private static int recursive(int n,int w,int[] val,int[] wt){
        if(w==0 || n==0)    return 0;

        if(wt[n-1]<=w){
            return Math.max(val[n-1]+recursive(n,w-wt[n-1],val,wt),recursive(n-1,w,val,wt));
        }

        return recursive(n-1,w,val,wt);
    }
    private static int recursiveMem(int n,int w,int[] val,int[] wt,int[][] dp){
        if(w==0 || n==0)    return 0;

        if(dp[n][w]!=-1)   return dp[n][w];
        if(wt[n-1]<=w){
            return dp[n][w] = Math.max(val[n-1]+recursiveMem(n,w-wt[n-1],val,wt,dp),recursiveMem(n-1,w,val,wt,dp));
        }

        return dp[n][w] = recursiveMem(n-1,w,val,wt,dp);
    }
    static void fill(int[][] dp){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }
    }
    static int knapSack(int N, int W, int val[], int wt[])
    {
        int[][] dp = new int[N+1][W+1];
        fill(dp);
        for(int i=0;i<dp.length;i++)
            dp[i][0] = 0;
        for(int i=0;i<dp[0].length;i++){
            dp[0][i] = 0;
        }
        return tabulation(N,W,val,wt,dp);
        // return recursiveMem(N,W,val,wt,dp);
        // return recursive(N,W,val,wt);
    }

    public static void main(String[] args) {
        int[] val = {1,4,5,7};
        int[] wt = {1,3,4,5};
        int n=4,w=8;

        System.out.println(knapSack(n,w,val,wt));
    }
}
