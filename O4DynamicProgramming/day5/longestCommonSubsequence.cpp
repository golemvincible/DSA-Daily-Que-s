class Solution {
public:

    int helper(string t1, string t2, int m, int n){
        vector<vector<int>> dp(m+1, vector<int>(n+1, -1));
        for(int i=0; i<=m; i++) dp[i][0]= 0;
        for(int i=0; i<=n; i++) dp[0][i]=0;

        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(t1[i-1]==t2[j-1]){
                    dp[i][j]= 1+ dp[i-1][j-1];
                }else{
                    dp[i][j]= max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }

    int longestCommonSubsequence(string text1, string text2) {
        int m = text1.size();
        int n = text2.size();
        return helper(text1, text2, m, n);
    }
};
