class Solution {
public:

    int helper(int m, int n){

        vector<vector<int>> dp(m+1, vector<int>(n+1, 0));
        for(int i=0; i<=m; i++){
            for(int j=0; j<=n; j++){
                if(i==0 && j==0){
                    dp[0][0]= 1;
                    continue;
                } 

                int up=0, down= 0;
                if(i>0) up = dp[i-1][j];
                if(j>0) down = dp[i][j-1];
                dp[i][j]=up+down;
            }
        }
        return dp[m][n];
    }

    int uniquePaths(int m, int n) {
        return helper(m-1, n-1);
    }
};
