class Solution {
public:

    string reverse(string s){
        int n= s.size()-1;
        int i=0;
        while(i<n){
            swap(s[i++], s[n--]);
        }
        return s;
    }

    int helper(string s1, string s2, int n){
        vector<vector<int>> dp(n+1, vector<int>(n+1, -1));
        for(int i=0; i<=n; i++){
            dp[i][0]=0;
            dp[0][i]=0;
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(s1[i-1]==s2[j-1]){
                    dp[i][j] = 1+ dp[i-1][j-1];
                }else{
                    dp[i][j] = max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][n];
    }

    int longestPalindromeSubseq(string s) {
        string s2 = reverse(s);
        int n = s.size();
        return helper(s, s2, n);
    }
};
