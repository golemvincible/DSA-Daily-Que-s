#include<bits/stdc++.h>
using namespace std;

class Solution {
public:

    void helper(vector<int>& candidates, int target, vector<vector<int>>& ans, vector<int> ds, int sum, int i){
        if(sum>=target){
            if(sum==target) ans.push_back(ds);
            return;
        }
        while(i<candidates.size()){
            sum+=candidates[i];
            ds.push_back(candidates[i]);
            helper(candidates, target, ans, ds, sum, i);
            sum-=candidates[i];
            ds.pop_back();
            i++;
        }
    }
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        sort(candidates.begin(), candidates.end());
        vector<int> ds;
        vector<vector<int>> ans;
        helper(candidates, target, ans, ds, 0, 0);
        return ans;
    }
};

int main(){
    
    return 0;
}