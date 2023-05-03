#include<bits/stdc++.h>
using namespace std;

class Solution{
    public:
    
    void helper(vector<vector<int>> &m, int n, int i, int j, vector<string>& ans, string s){
        if(m[i][j]==0) return;
        if(i==n-1 && j==n-1){
            ans.push_back(s);
            return;
        }
        
        //down
        if(i<n-1 && m[i+1][j]==1){
            s+="D";
            m[i][j]=0;
            helper(m, n, i+1, j, ans, s);
            m[i][j]=1;
            s.pop_back();
        }
        //right
        if(j<n-1 && m[i][j+1]==1){
            s+="R";
            m[i][j]=0;
            helper(m, n, i, j+1, ans, s);
            m[i][j]=1;
            s.pop_back();
        }
        //up    
        if(i>0 && m[i-1][j]==1){
            s+="U";
            m[i][j]=0;
            helper(m, n, i-1, j, ans, s);
            m[i][j]=1;
            s.pop_back();
        }
        //left
        if(j>0 && m[i][j-1]==1){
            s+="L";
            m[i][j]=0;
            helper(m, n, i, j-1, ans, s);
            m[i][j]=1;
            s.pop_back();
        }
            
    }
    
    vector<string> findPath(vector<vector<int>> &m, int n) {
        // Your code goes here
        vector<string> ans;
        string s;
        helper(m, n, 0, 0, ans, s);
        if(ans.size()==0){
            ans.push_back("-1");
        }
        return ans;
    }
};

int main(){
    
    return 0;
}