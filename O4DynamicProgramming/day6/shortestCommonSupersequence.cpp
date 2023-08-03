class Solution {
public:

    string reverse(string s){
        int n= s.size()-1;
        int i=0;
        while(i<n){
            swap(s[n--], s[i++]);
        }
        return s;
    }

    string lcs(string s1, string s2){
        int n= s1.size();
        int m= s2.size();
        vector<vector<int>> dp(n+1, vector<int>(m+1, -1));
        for(int i=0; i<=n; i++) dp[i][0]= 0;
        for(int i=0; i<=m; i++) dp[0][i]= 0;

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(s1[i-1]==s2[j-1]){
                    dp[i][j] = 1+ dp[i-1][j-1];
                }else{
                    dp[i][j] = max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        string ans;
        int i=n, j=m;
        while(i>0 && j>0){
            if(s1[i-1]==s2[j-1]){
                ans.push_back(s1[i-1]);
                i--;
                j--;
            }else{
                if(dp[i-1][j]>dp[i][j-1]) i--;
                else j--;
            }
        }
        
        ans = reverse(ans);
        return ans;
    }
    string shortestCommonSupersequence(string str1, string str2) {
        string a = lcs(str1, str2);
        string ans= "";
        int i=0, j=0;
        for(char x: a){
            while(str1[i]!=x){
                ans.push_back(str1[i++]);
            }
            while(str2[j]!=x){
                ans.push_back(str2[j++]);
            }
            ans.push_back(x);
            i++;
            j++;
        }
        while(str1[i]!='\0') ans.push_back(str1[i++]);
        while(str2[j]!='\0') ans.push_back(str2[j++]);
        return ans;
    }
};
