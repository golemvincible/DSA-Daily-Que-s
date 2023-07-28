int helper(string t1, string t2, int n, int m){
        vector<vector<int>> dp(n+1, vector<int>(m+1, -1));
        for(int i=0; i<=n; i++) dp[i][0]= 0;
        for(int i=0; i<=m; i++) dp[0][i]=0;

        int maxi=0;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(t1[i-1]==t2[j-1]){
                    dp[i][j]= 1+ dp[i-1][j-1];
                }else{
                    dp[i][j]= 0;
                }
                maxi = max(maxi, dp[i][j]); 
            }
        }
        return maxi;
    }
    
    int longestCommonSubstr (string S1, string S2, int n, int m)
    {
        // your code here
        return helper(S1, S2, n, m);
    }
