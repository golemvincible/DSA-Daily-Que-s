class Solution {
public:

    int mod = (int)(1e9 + 7);
  
    int help(int n, int t, vector<int>& nums ){
        int sum=0;
        for(auto i: nums) sum+=i;
        if(sum<t || (sum-t)%2) return 0;
        sort(nums.begin(), nums.end(), greater<int>());
        int s = (sum-t)/2;
        vector<vector<int>> dp(n+1, vector<int>(s+1, -1));
        
        // for(int i=0; i<=n; i++) dp[i][0]=1;
        dp[0][0] = 1;
        for(int i=1; i<=s; i++) dp[0][i]=0;
        
        for(int i=1; i<=n; i++){
            for(int j=0; j<=s; j++ ){
                if(j>=nums[i-1]){
                    dp[i][j] = (dp[i-1][j-nums[i-1]]+ dp[i-1][j])%mod;
                }else{
                    dp[i][j]= dp[i-1][j]%mod;
                }
            }
        }
        return dp[n][s]%mod;
    }

    int findTargetSumWays(vector<int>& nums, int target) {
        int n=nums.size();
        return help(n, target, nums);
    }
};
