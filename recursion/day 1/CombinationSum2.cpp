#include<bits/stdc++.h>
using namespace std;

class Solution {
public:

    void helper(vector<int>& candidates, int target, vector<vector<int>>& ans, vector<int> ds, int ind){
        if(target<=0){
            if(target==0) ans.push_back(ds);
            return; 
        }
        for(int i=ind; i<candidates.size(); i++){
            if(i==ind || candidates[i]!=candidates[i-1]){
                ds.push_back(candidates[i]);
                target-=candidates[i];
                helper(candidates, target, ans, ds, i+1);
                ds.pop_back();
                target+=candidates[i];
            }
        }
    }

    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        sort(candidates.begin(), candidates.end());
        vector<vector<int>> ans;
        vector<int> ds;
        helper(candidates, target, ans, ds, 0);
        return ans;
    }
};

int main(){
    
    return 0;
}