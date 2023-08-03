class Solution {
public:

    int lcs(string w1, string w2, int n1, int n2){
        vector<vector<int>> dp(n1+1, vector<int>(n2+1, -1));

        for(int i=0; i<=n1; i++) dp[i][0]= 0;
        for(int i=0; i<=n2; i++) dp[0][i]= 0;

        for(int i=1; i<=n1; i++){
            for(int j=1; j<=n2; j++){
                if(w1[i-1]==w2[j-1]){
                    dp[i][j] = 1+ dp[i-1][j-1];
                }else{
                    dp[i][j]= max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n1][n2];
    }

    int minDeletion(string w1, string w2){
        int n1 = w1.size();
        int n2 = w2.size();
        int Lcs = lcs(w1, w2, n1, n2); 
        int ans = n1+n2-(2*Lcs);
        return ans;
    }

    int minDistance(string word1, string word2) {
        return minDeletion(word1, word2);
    }
};
