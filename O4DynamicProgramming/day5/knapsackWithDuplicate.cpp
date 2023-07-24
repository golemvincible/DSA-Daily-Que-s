class Solution{
public:

int helper(int n, int w, int val[], int wt[]){
        
        vector<vector<int>> dp(n+1, vector<int>(w+1, -1));
        
        for(int i=0; i<=n; i++) dp[i][0]=0;
        for(int i=0; i<=w; i++) dp[0][i]=0;
        
        for(int i=1; i<=n; i++){
            for(int j=1; j<=w; j++){
                if(wt[i-1]<=j){
                    dp[i][j]= max(dp[i][j-wt[i-1]]+val[i-1], dp[i-1][j]);
                }else{
                    dp[i][j]= dp[i-1][j];
                }
            }
        }
        return dp[n][w];
    }

    int knapSackTabulation(int N, int W, int val[], int wt[])
    {
        // code here
        return helper(N, W, val, wt);
    }


    int helper(int n, int w, int val[], int wt[], vector<vector<int>>& dp){
        if(n == 0 || w == 0) return 0;
        
        if(dp[n][w] != -1) return dp[n][w];
        
        if(w >= wt[n-1]){
            return dp[n][w] = helper(n, w - wt[n-1], val, wt, dp) + helper(n-1, w, val, wt, dp);
        }
        
        return dp[n][w] = helper(n-1, w, val, wt, dp);
    }

    int knapSackRecMem(int N, int W, int val[], int wt[])
    {
        // code here
        vector<vector<int>> dp(N+1, vector<int>(W+1, -1));
        return helper(N, W, val, wt, dp);
    }
};
