class Solution {
public:
    bool isSubsequence(string s, string t) {
        int i=0;
        for(char x: t){
            if(x==s[i]) i++;
            if(s[i]=='\0') return true;
        }
        if(s[i]=='\0') return true;
        return false;
    }
};
