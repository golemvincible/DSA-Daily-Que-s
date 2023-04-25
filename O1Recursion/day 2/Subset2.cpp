#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    void helper(vector<int> nums, vector<vector<int>>& ans, vector<int> ds, int i){
        if(i==nums.size()){
            ans.push_back(ds);
            return;
        }
        
        //push
        ds.push_back(nums[i]);
        helper(nums, ans, ds, i+1);
        ds.pop_back();

        //skip
        while(i<nums.size()-1 && nums[i]==nums[i+1])i++;
        helper(nums, ans, ds, i+1);
    }

    vector<vector<int>> subsetsWithDup(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        vector<vector<int>> ans;
        vector<int> ds;
        helper(nums, ans, ds, 0);
        return ans;
    }
};

int main(){
    
    return 0;
}