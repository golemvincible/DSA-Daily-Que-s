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

    void helper(TreeNode* root, vector<int>& ans){
        if(!root) return;

        helper(root->left, ans);
        helper(root->right, ans);
        ans.push_back(root->val);
    }

    vector<int> postorderTraversal(TreeNode* root) {
        vector<int> ans;
        helper(root, ans);
        return ans;
    }
};

int main(){
    
    return 0;
}