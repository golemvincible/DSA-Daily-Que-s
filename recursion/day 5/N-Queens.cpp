#include<bits/stdc++.h>
using namespace std;

class Solution {
public:

    bool check(vector<string> ds, int i, int j, int n){
        for(int x=0; x<n; x++){
            if(x!=i && ds[x][j]=='Q') return false;
            if(x!=j && ds[i][x]=='Q') return false;
        }
        int x=i, y=j;
        while(x>=0 && y>=0){
            if(ds[x][y]=='Q') return false;
            x--;
            y--;
        }
        x=i, y=j;
        while(x>=0 && y<n){
            if(ds[x][y]=='Q') return false;
            x--;
            y++;
        }
         return true;
    }

    void helper(vector<vector<string>>& ans, vector<string> ds, int n, int i, int num){
        if(num==n){
            ans.push_back(ds);
            return;
        }
        if(i==n) return;
        for(int j=0; j<n; j++){
            if(check(ds, i, j, n)){
                ds[i][j]='Q';
                helper(ans, ds, n, i+1, num+1);
                ds[i][j]='.';
            }
        }
         }
    vector<vector<string>> solveNQueens(int n) {
        vector<string> ds(n, string(n, '.'));
        vector<vector<string>> ans;
        helper(ans, ds, n, 0, 0);
        return ans;
    }
};

int main(){
    
    return 0;
}