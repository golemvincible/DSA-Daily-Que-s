#include<bits/stdc++.h>
using namespace std;

class Solution {
public:

    bool check(vector<vector<char>>& board, int i, int j, int num){
        for(int x=0; x<9; x++){
            if(board[i][x]==num+'0' || board[x][j]==num+'0'){
                return false;
            }
        }
        int row = (i / 3) * 3;
        int col = (j / 3) * 3;
        for(int x=row; x<row+3; x++){
            for(int y=col; y<col+3; y++){
                if(board[x][y]==num+'0') return false;
            }
        }
        return true;
    }

    bool helper(vector<vector<char>>& board, int i, int j){
        if(i==9) return true;

        if(board[i][j]=='.'){
            for(int x=1; x<=9; x++){
                if(check(board, i, j, x)){
                    board[i][j]=x+'0';
                    if(j==8){
                        if(helper(board, i+1, 0)) return true;
                    } else {
                        if(helper(board, i, j+1)) return true;
                    }
                    board[i][j]='.';
                }
            }
        } else {
            if(j==8){
                if(helper(board, i+1, 0)) return true;
            } else {
                if(helper(board, i, j+1)) return true;
            }
        }
        return false;
    }

    void solveSudoku(vector<vector<char>>& board) {
        bool ans = helper(board, 0, 0);
    }

};

int main(){
    
    return 0;
}