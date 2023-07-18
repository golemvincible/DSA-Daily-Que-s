class Solution {
public:

    int helper(vector<int>& co, int am, int n){
        vector<vector<int>> dp(n+1, vector<int>(am+1, -1));

        for(int i=0; i<=am; i++) dp[0][i]= INT_MAX -1;
        for(int i=1; i<=n; i++) dp[i][0] = 0;
        for(int i=1; i<=am; i++){
            if(i%co[0]==0) dp[1][i]= i/co[0];
            else dp[1][i]= INT_MAX -1;
        }

        for(int i=2; i<=n; i++){
            for(int j=1; j<=am; j++){
                if(j<=co[i-1]){
                    dp[i][j] = min(1+dp[i][am-co[i-1]], dp[i-1][j]);
                }else{
                    dp[i][j]= dp[i-1][j];
                }
            }
        }
        return dp[n][am];
    }

    int coinChange(vector<int>& coins, int amount) {
        int n = coins.size();
        return helper(coins, amount, n);
    }
};
