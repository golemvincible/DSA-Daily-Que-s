#include<bits/stdc++.h>
using namespace std;

class Solution {
public:

    void helper(unordered_map<int, bool> m, vector<vector<int>>& ans, vector<int> ds, vector<int> nums){
        if(ds.size()==nums.size()){
            ans.push_back(ds);
            return;
        }
        for(int i=0; i<nums.size(); i++){
            if(!m[i]){
                ds.push_back(nums[i]);
                m[i]=true;
                helper(m, ans, ds, nums);
                ds.pop_back();
                m[i]=false;
            } 
        }
    }

    vector<vector<int>> permute(vector<int>& nums) {
        unordered_map<int, bool> m;
        for(int i=0; i<nums.size(); i++) m[i]=false;
        vector<vector<int>> ans;
        vector<int> ds;
        helper( m, ans, ds, nums);
        return ans;
    }
};

int main(){
    
    return 0;
}