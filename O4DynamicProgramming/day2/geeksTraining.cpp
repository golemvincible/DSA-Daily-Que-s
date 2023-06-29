int helper(vector<vector<int>>& matrix){
        int n = matrix.size();

        vector<vector<int>> dp(n, vector<int>(n));
        for(int i=0; i<n; i++)
            dp[n-1][i] = matrix[n-1][i];
        
        for(int i=n-2; i>=0; i--){
            for(int j=0; j<n; j++){
                int m = INT_MAX;
                if(j==0) m = min(matrix[i+1][j], matrix[i+1][j+1]);
                else if(j==n-1) m = min(matrix[i+1][j], matrix[i+1][j-1]);
                else m = min(matrix[i+1][j], min(matrix[i+1][j-1], matrix[i+1][j+1]));
                dp[i][j]= matrix[i][j] + m;
            }
        }
        int minans = INT_MAX;
        for(int i=0; i<n; i++){
            minans = min(minans, dp[0][i]);
        }
        return minans;
    }
    int minFallingPathSum(vector<vector<int>>& matrix) {
        return helper(matrix);
    }
