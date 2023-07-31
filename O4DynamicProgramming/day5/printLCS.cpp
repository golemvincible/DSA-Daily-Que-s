void reverse(string &s){
	int n= s.size()-1;
	int i=0;
	while(i<n){
		swap(s[i++], s[n--]);
	}
}

string helper(int n, int m, string &s1, string &s2){
	vector<vector<int>> dp(n+1, vector<int>(m+1, -1));
	for(int i=0; i<=n; i++) dp[i][0]= 0;
	for(int i=0; i<=m; i++) dp[0][i]= 0;

	for(int i=1; i<=n; i++){
		for(int j=1; j<=m; j++){
			if(s1[i-1]=s2[j-1]){
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
	
	reverse(ans);
	return ans;
}

string findLCS(int n, int m,string &s1, string &s2){
	// Write your code here.	
	return helper(n, m, s1, s2);
}
