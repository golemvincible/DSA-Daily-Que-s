#include<bits/stdc++.h>
using namespace std;

class Solution {
public:

    bool palindrome(string s ){
        int i=0, j=s.size()-1; 
        while(i<j){
            if(s[i]!=s[j]) return false;
            i++;
            j--;
        }
        return true;
    }

    void helper(string s, vector<vector<string>>& ans, vector<string> ds, int st){
        if(st==s.size()){
            ans.push_back(ds);
            return;
        }
        // here we are finding all possible palindrome substrings from the starting index
        string sub;
        for(int i=st; i<s.size(); i++){   
            sub+=s[i];                 
            if(palindrome(sub)){ 
                ds.push_back(sub);       
                helper(s, ans, ds, i+1);  
                ds.pop_back();            
            }
        }
    }

    vector<vector<string>> partition(string s) {
        vector<vector<string>> ans;//final vector storing all the palindrome partitioning of s
        vector<string> ds; //vector storing one partitioning of string
        helper(s, ans, ds, 0); // string, answer, ds, starting index
        return ans;
    }
};

int main(){
    
    return 0;
}