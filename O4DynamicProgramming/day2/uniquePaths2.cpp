class Solution {
public:

    int helper(vector<vector<int>>& obstacleGrid){
        int r = obstacleGrid.size();
        int c = obstacleGrid[0].size();
        vector<vector<int>> dp(r, vector<int>(c));

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(i==0 && j==0){
                    if(obstacleGrid[r-1][c-1]==1)  return 0;
                    else dp[0][0]=1;
                }else{
                    int up=0, down =0;
                    if(i>0 && obstacleGrid[i-1][j]==0) up = dp[i-1][j];
                    if(j>0 && obstacleGrid[i][j-1]==0) down = dp[i][j-1];
                    dp[i][j]= up+down;
                }
            }
        }
        return dp[r-1][c-1];
    }

    int uniquePathsWithObstacles(vector<vector<int>>& obstacleGrid) {
        return helper(obstacleGrid);
    }
};
