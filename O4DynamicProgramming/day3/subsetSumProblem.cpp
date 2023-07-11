class Solution{   
public:

    bool helper(vector<int>arr, int sum, int n){
        
        vector<vector<int>> dp(n+1, vector<int>(sum+1, -1));
        
        for(int i=0; i<=n; i++){
            dp[0][i]= 0;
            dp[i][0]= 1;
        }
        
        for(int i=1; i<=n; i++){
            for(int j=1; j<=sum; j++){
                if(arr[i-1]<=j){
                    if(dp[i-1][j-arr[i-1]] ==1 || dp[i-1][j] ==1)
                        dp[i][j]=1;
                    else
                        dp[i][j]=0;
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][sum]!=0?true:false;
    }
        
    bool isSubsetSum(vector<int>arr, int sum){
        // code here 
        int n = arr.size();
        return helper(arr, sum, n);
    }
};
