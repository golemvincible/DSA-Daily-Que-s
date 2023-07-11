    class Solution{   
public:
// Recursive
    bool helper(vector<int>nums, int s1, int s2, int n){
        
        if(s1==s2) return true;
        if(n==0) return false;

        return helper(nums, s1-nums[n-1], s2+nums[n-1], n-1) || 
        helper(nums, s1, s2, n-1);
    }
    bool canPartition(vector<int>& nums) {
        int n = nums.size();
        int sum1=0;
        int sum2 = 0;
        for(int i=0; i<n; i++) sum1+= nums[i];
        return helper(nums, sum1, sum2, n);
    }

//Memoization
bool helper(vector<int>& nums, int s1, int s2, int n, vector<vector<int>>& dp){
        if(s1==s2) return true;
        if(n==0) return false;

        if(dp[n][s1]!=-1) return dp[n][s1]==0? false: true;
        dp[n][s1]= helper(nums, s1-nums[n-1], s2+nums[n-1], n-1, dp) || 
        helper(nums, s1, s2, n-1, dp);
        return dp[n][s1]==0?false: true;
    }

    bool canPartition(vector<int>& nums) {
        int n = nums.size();
        int sum1=0;
        int sum2 = 0;
        for(int i=0; i<n; i++) sum1+= nums[i];
        vector<vector<int>> dp(n+1, vector<int>(sum1+1, -1));
        return helper(nums, sum1, sum2, n, dp);
    }

//tabulation
    bool helper(vector<int>& nums, int n){

        int sum=0;
        for(int i=0; i<n; i++){ sum+= nums[i];}

        vector<vector<int>> dp(n+1, vector<int>(sum+1, -1));
        for(int i=0; i<=n; i++){
            dp[i][0] = 1;
        }
        for(int i=1; i<=sum; i++){
            dp[0][i] = 0;
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=sum; j++){
                if(j>=nums[i-1]){
                    if(dp[i-1][j-nums[i-1]]!=0 || dp[i-1][j]!=0)
                        dp[i][j]=1;
                    else
                        dp[i][j]=0;
                }
                else
                    dp[i][j]=dp[i-1][j];
            }
        }
        return dp[n][sum]==0? false: true;
    }

    bool canPartition(vector<int>& nums) {
        int n = nums.size();
        return helper(nums, n);
    }
};
