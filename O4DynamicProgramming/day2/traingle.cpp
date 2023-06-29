class Solution {
public:

    int helper(vector<vector<int>>& t){
        int n= t.size();
        vector<vector<int>> dp(n, vector<int>(n, -1));

        for(int j=0; j<n; j++)
            dp[n-1][j]=t[n-1][j];
        
        for(int i=n-2; i>=0; i--){
            for(int j=0; j<=i; j++){
                dp[i][j] = t[i][j] + min(dp[i+1][j], dp[i+1][j+1]);
            }
        }
        return dp[0][0];
    }

    int minimumTotal(vector<vector<int>>& triangle) {
        return helper(triangle);
    }
};
