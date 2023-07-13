
class Solution {
  public:
  
    int helper(int n, int d, vector<int>& arr){
        int sum=0;
        for(auto i: arr) sum+=i;
        int s = (sum+d)/2;
        
        int mod = 1e9 + 7;
        sort(arr.begin(), arr.end(), greater<>());
        vector<vector<int>> dp(n+1, vector<int>(sum+1, -1));
        
        for(int i=0; i<=n; i++) dp[i][0]=1;
        for(int i=1; i<=s; i++) dp[0][i]=0;
        
        for(int i=1; i<=n; i++){
            for(int j=1; j<=s; j++){
                if(j>=arr[i-1]){
                    dp[i][j] = dp[i-1][j-arr[i-1]] + dp[i-1][j];
                }else{
                    dp[i][j]= dp[i-1][j];
                }
            }
        }
        return dp[n][s]%mod;
    }
  
    int countPartitions(int n, int d, vector<int>& arr) {
        return helper(n, d, arr);
    }
};
