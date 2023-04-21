#include<bits/stdc++.h>
using namespace std;

class Solution {
public:

    void helper(vector<int> nums, vector<vector<int>>& ans, vector<int> ds, unordered_map<int, bool> m){
        if(ds.size()==nums.size()){
            ans.push_back(ds);
            return;
        }
        for(int i=0; i<nums.size(); i++){
            if(m[i]) continue;
            if(i>0 &&nums[i-1]==nums[i] && !m[i-1]) continue;
            ds.push_back(nums[i]);
            m[i]=true;
            helper(nums, ans, ds, m);
            m[i]=false;
            ds.pop_back();
        }
    }

    vector<vector<int>> permuteUnique(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        vector<vector<int>> ans;
        vector<int> ds;
        unordered_map<int, bool> m;
        for(int i=0; i<nums.size(); i++) m[i]=false;
        helper(nums, ans, ds, m);
        return ans;
    }

};

int main(){
    
    return 0;
}