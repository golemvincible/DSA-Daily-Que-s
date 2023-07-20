class Solution {
public:

    int helper(int am, vector<int>& coins, int n){
        vector<vector<int>> dp(n+1, vector<int>(am+1, -1));
        for(int i=0; i<=n; i++) dp[i][0]=1;
        for(int i=1; i<=am; i++) dp[0][i]=0;

        for(int i=1; i<=n; i++){
            for(int j=1; j<= am; j++){
                if(j>=coins[i-1]){
                    dp[i][j]= dp[i][j-coins[i-1]]+ dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][am];
    }

    int change(int amount, vector<int>& coins) {
        int n = coins.size();
        return helper(amount, coins, n);
    }
};
