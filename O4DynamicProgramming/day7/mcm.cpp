class Solution{
public:

    int helper(int arr[], int i, int j, vector<vector<int>> &dp){
        if(i>=j) return 0;
        
        if(dp[i][j]!=-1) return dp[i][j];
        int ans= INT_MAX;
        for(int k=i; k<j; k++){
            int temp = helper(arr, i, k, dp)+ helper(arr, k+1, j, dp)+ arr[i-1]*arr[k]*arr[j];
            ans= min(temp, ans);
        }
        return dp[i][j]= ans;
    }

    int matrixMultiplication(int N, int arr[])
    {
        // code here
        int i=1;
        int j= N-1;
        vector<vector<int>> dp(101, vector<int>(101, -1)); 
        return helper(arr, i, j, dp);
    }
};
