int helper(int arr[], int n, int sum){
	   int mod = 1e9+7;
	    
	   sort(arr, arr + n, greater<int>());
	   vector<vector<int>> dp(n+1, vector<int>(sum+1, -1));
	   for(int i=0; i<=n; i++){
	       dp[i][0]=1;
	   }
	   for(int i=1; i<=sum; i++){
	       dp[0][i]=0;
	   }
	   
	   for(int i=1; i<=n; i++){
	       for(int j=1; j<=sum; j++){
	           if(arr[i-1]<=j)
	            dp[i][j] = (dp[i-1][j-arr[i-1]]+ dp[i-1][j])%mod;
	           else
	            dp[i][j] = dp[i-1][j]%mod;
	       }
	   }
	   return dp[n][sum]%mod;
	}
	
	int perfectSum(int arr[], int n, int sum)
	{
	   
        return helper(arr, n, sum);
	}
