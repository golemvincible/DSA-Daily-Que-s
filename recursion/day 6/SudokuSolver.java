class SudokuSolver {
    private boolean isSafe(char num,char[][] board,int row,int col,int n){
        // 3 conditions should be satisfied
        
        int i=row,j=col;
        
        //no. should not present in entire col i.e same col different row
        for(i=0;i<n;i++){
            if(board[i][col]==num)
                return false;
        }
        
        //no. should not present in entire row i.e same row different col
        for(i=0;i<n;i++){
            if(board[row][i]==num)
                return false;
        }
        
        //no. should not present in grid
        //dry run it
        i=(row/3)*3;j=(col/3)*3;
        for(int x=i;x<=(i+2);x++){
            for(int y=j;y<=(j+2);y++){
                if(board[x][y]==num)
                return false;
            }
        }
        return true;
    }
    private boolean solvingSudoku(char[][] board,int n){
        for(int row=0;row<n;row++){
            for(int col=0;col<n;col++){
                
                // it means we need to fill this block
                if(board[row][col]=='.'){
                    
                    //we will try all the numbers from 1-9 to fill this block
                    for(char num='1';num<='9';num++){
                        // we will se if the number can be placed here or not
                        if(isSafe(num,board,row,col,n)){
                            /*
                                After placing the number on this block we will call recursion again
                                to see if we can place all the numbers on the board and it will
                                continue till we have placed all the numbers on the board
                                and if we successfully placed all the numbers on the board we will return
                                true till then we will keep trying to place numbers from 1-9
                            */
                            board[row][col]=num;
                            
                            if(solvingSudoku(board,n))
                                return true;
                            
                            //if it is returning false then we will keep on going so backtracking
                            board[row][col]='.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public void solveSudoku(char[][] board) {
        int n=board.length;
        solvingSudoku(board,n);
    }
}
