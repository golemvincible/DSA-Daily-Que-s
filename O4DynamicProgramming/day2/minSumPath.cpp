class Solution {
public:

    int helper(vector<vector<int>>& grid, int r, int c){
        vector<vector<int>> dp(r+1, vector<int>(c+1, -1));
        for(int i=0; i<=r; i++){
            for(int j=0; j<=c; j++){
                if(i==0 && j==0) dp[0][0]=0;
                else{
                    int up = INT_MAX, down = INT_MAX;
                    if(i>0) up = grid[i-1][j] + dp[i-1][j];
                    if(j>0) down = grid[i][j-1]+ dp[i][j-1];
                    dp[i][j]=min(up, down);
                }
            }
        }
        return dp[r][c];
    }

    int minPathSum(vector<vector<int>>& grid) {
        int r = grid.size()-1;
        int c = grid[0].size()-1;
        return helper(grid, r, c)+grid[r][c];
    }
};
