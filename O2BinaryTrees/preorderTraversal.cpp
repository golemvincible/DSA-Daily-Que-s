#include<bits/stdc++.h>
using namespace std;

class Solution {

public:

    class TreeNode{
        public:
            int val;
            TreeNode* left;
            TreeNode* right;

            TreeNode(){
                left=NULL;
                right=NULL;
            }
    };

    vector<int> helper(TreeNode* root, vector<int>& ans){
        if(!root) return ans;

        ans.push_back(root->val);
        ans = helper(root->left, ans);
        ans = helper(root->right, ans);
        return ans;
    }

    vector<int> preorderTraversal(TreeNode* root) {
        vector<int> ans;
        return helper(root, ans);
    }
};

int main(){
    
    return 0;
}