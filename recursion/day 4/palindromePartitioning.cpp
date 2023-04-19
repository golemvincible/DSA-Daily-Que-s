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
        for(int i=0; i<s.size()-st; i++){   // i: length of substring, 
            string sub;
            for(int j=st; j<=st+i; j++){   // j: iterates from starting index till length 
                sub+=s[j];                 // substring of i length formed
            }
            if(palindrome(sub)){ 
                ds.push_back(sub);        // ds=[sub  ]
                helper(s, ans, ds, st+i+1);  // starting index after the length of substring and leave the rest to recursive call
                ds.pop_back();            // pop_back because we will now start from a diff length palindrome substring
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