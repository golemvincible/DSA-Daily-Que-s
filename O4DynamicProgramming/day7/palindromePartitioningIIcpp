class Solution {
public:

    bool isPalindrome(string s, int i, int j){
        while(i<j){
            if(s[i++]!=s[j--]) return false;
        }
        return true;
    }

    // int helper(string s, int i, int j, vector<vector<int>> &dp){
    //     if(i>=j) return 0;
    //     if(isPalindrome(s, i, j)) return 0;

    //     if(dp[i][j]!=-1) return dp[i][j];
    //     int ans = INT_MAX;
    //     for(int k=i; k<j; k++){
    //         int left, right;

    //         if(dp[i][k]!=-1) left=dp[i][k];
    //         else{
    //             left = helper(s, i, k, dp);
    //             dp[i][k]= left;
    //         } 
    //         if(dp[k+1][j]!=-1) right= dp[k+1][j];
    //         else{
    //             right = helper(s, k+1, j, dp);
    //             dp[k+1][j]= right;
    //         } 

    //         int temp = 1+ left+ right;
    //         ans= min(ans, temp);
    //     }
    //     return dp[i][j]= ans;
    // }

    int helper2(string s){
        // if(i==n) return 0;
        
        // if(dp[i]!=-1) return dp[i];
        // int ans = INT_MAX;
        // for(int k=i; k<n; k++){
        //     if(isPalindrome(s, i, k)){
        //         int temp = 1+ helper2(s, k+1, n, dp);
        //         ans = min(ans, temp);
        //     }
        // }
        // return dp[i]= ans;
        int n= s.size();
        vector<int> dp(n+1, 0);
        dp[n]=0;

        for(int i=n-1; i>=0; i--){
            int ans = INT_MAX;
            for(int j=i; j<n; j++){
                if(isPalindrome(s, i, j)){
                    int temp = 1+ dp[j+1];
                    ans = min(ans, temp);
                }
            }
            dp[i]= ans;
        }
        return dp[0]-1;
    }

    int minCut(string s) {
        // int i=0, j= s.size()-1;
        // vector<vector<int>> dp(2001, vector<int>(2001, -1));
        // return helper(s, i, j, dp);

        // int i=0, n=s.size();
        // vector<int> dp(2001, -1);
        return helper2(s);
    }
};
