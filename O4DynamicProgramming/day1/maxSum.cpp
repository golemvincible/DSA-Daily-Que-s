class Solution{
public:	
	// calculate the maximum sum with out adjacent
	
    int helper(int* arr, int n, vector<int>& dp) {
	   dp[0] = arr[0];
	   if(n>=1) dp[1] = max(arr[1], arr[0]);
	   
	   for(int i=2; i<=n; i++){
	       int inc = arr[i] + dp[i-2];
	       int exc = dp[i-1];
	       dp[i]= max(inc, exc);
	   }
	   return dp[n];
    }
    
    int findMaxSum(int* arr, int n) {
        vector<int> dp(n, 0);
        return helper(arr, n - 1, dp);
    }
};
