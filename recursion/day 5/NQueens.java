public class NQueens {
    public static void main(String[] args) {
        int n=4;
        int row = 0;
        boolean board[][] = new boolean[n][n];

        //we are not passing column because we have to start from 0 at every row
        int res = nQueens(board,row);
        System.out.println(res);

    }

    private static int nQueens(boolean[][] board, int row) {

        /*if row == board.length then we know we have placed queen on last row
          also that means now we got 1 ans that's why we are returning 1 and displaying
          the board
         */
        if(row == board.length){
            display(board);
            System.out.println();
            return 1;
        }

        /*for every call we are initializing count from 0 if we reach base condition
          1 will be returned then at the time of exit of the function we will add
          this 1 to the previous count and return count in the end
         */
        int count = 0;

        //placing queen and checking for every row and column
        for(int col=0;col< board.length;col++){
            //checking if the position is safe or not
            if(isSafe(board,row,col)){
                //placing queen
                board[row][col] = true;
                //placed queen and going to next row
                count = count + nQueens(board,row+1);
                //end of the function so reverting all the chnges we made
                board[row][col] = false;
            }
        }
        return count;
    }

    private static void display(boolean[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if(board[i][j]){
                    System.out.print("Q ");
                }else{
                    System.out.print("N ");
                }
            }
            System.out.println();
        }
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        //checking vertically
        for(int i=0;i<=row;i++){
            if(board[i][col])
                return false;
        }

        //checking left diagonal
        int i=row,j=col;
        while(i>=0 && j>=0){
            if(board[i][j])
                return false;
            i--;
            j--;
        }

        //checking right diagonal
        i=row;
        j=col;
        while(i>=0 && j<board.length){
            if(board[i][j])
                return false;
            i--;
            j++;
        }

        return true;
    }
}
