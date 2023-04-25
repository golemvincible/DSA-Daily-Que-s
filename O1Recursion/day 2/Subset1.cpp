#include<bits/stdc++.h>
using namespace std;

class Solution {
public:

    void helper(vector<int>& nums, vector<vector<int>>& ans, vector<int> ds, int ind){
        if(ind==nums.size()) return;
        for(int i=ind; i<nums.size(); i++){
            ds.push_back(nums[i]);
            ans.push_back(ds);
            helper(nums, ans, ds, i+1);
            ds.pop_back();
        }
    }

    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> ans;
        vector<int> ds;
        ans.push_back(ds);
        helper(nums, ans, ds, 0);
        return ans;
    }
};

int main(){
    
    return 0;
}