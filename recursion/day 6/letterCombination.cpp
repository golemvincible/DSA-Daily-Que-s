#include<bits/stdc++.h>
using namespace std;

class Solution {
public:

    void helper(string digits, vector<string>& ans,
    string s, unordered_map<int, string> m, int ind){
        if(s.size()==digits.size()){
            ans.push_back(s);
            return;
        }
        string st = m[(digits[ind]-'0')];
        for(auto i: st){
            s+=i;
            helper(digits, ans, s, m, ind+1);
            s.pop_back();
        }
    }

    vector<string> letterCombinations(string digits) {
        if(digits.size()==0) return {};
        unordered_map<int, string> m;
        char l ='a';
        for(int i=2; i<10; i++){
            string s ;
            if(i==7 || i==9){
                for(int a=0; a<4; a++){
                    s+=l;
                    l+=1;
                }
            }else{
                for(int a=0; a<3; a++){
                    s+=l;
                    l+=1;
                }
            }
            m[i]=s;
        }
        vector<string> ans;
        string s;
        helper(digits, ans, s, m, 0);
        return ans;
    }
};

int main(){
    
    return 0;
}