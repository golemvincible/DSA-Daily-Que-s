import java.util.Arrays;

public class WordSearch {
    private static boolean dfs(char[][] board,boolean[][] vis, String word,int x,int y,int ind){

        int m = board.length; //row
        int n = board[0].length;  //col

        //if index reaches word length then we know we got our word
        if(word.length()==ind){
            return true;
        }

        /*
            * checking whether x,y is valid or not

            * to keep track of where we came from we use visited array so that we are
              not trapped in a loop (i.e. not visiting same nodes where we came from again and again)

            * if the node is visited we'll return (it implies we already came from that ndoe so we can't
              go there again)

            * ind traverses word string

            * word.charAt(ind) is the character we want to search on board
              board[x][y] is the character we got on current coordinates on board

            * if they won't match we will return

        * */
        if(x<0 || y<0 || x>= m|| y>=n || vis[x][y] || ind>=word.length() ||word.charAt(ind)!=board[x][y])
            return false;
        //if we are here that means letter of word matched i.e. word.charAt(ind)==board[x][y]
        vis[x][y]=true;
        ind++;

        /*
            * we will call recursion for all 4 directions and search for the word
            * as soon as we get a true we will return immediately and no more recursion calls and we get our answer
            * if we don't get true we will continue our recursion till we get it and in the end we will return false
              which means the letter at board[x][y] where the recursion was called cannot generate answer
            * that's why we are looping in our main function and finding starting letter of word and calling
              recursion on that.
         */
        //down
        if(dfs(board,vis,word,x+1,y,ind))
            return true;

        //right
        if(dfs(board,vis,word,x,y+1,ind)){
            return true;
        }

        //left
        if(dfs(board,vis,word,x,y-1,ind)){
            return true;
        }

        //up
        if(dfs(board,vis,word,x-1,y,ind)){
            return true;
        }
        
        //backtracking
        vis[x][y]=false;
        
        return false;
    }

    public static boolean exist(char[][] board, String word) {

        char sw= word.charAt(0); //starting word
        boolean[][] vis = new boolean[board.length][board[0].length];
        /*
            * if we don't get true we will continue our recursion till we get it and in the end we will return false
              which means the letter at board[x][y] where the recursion was called cannot generate answer
            * that's why we are looping  and finding starting letter of word and calling
              recursion on that.
        */
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(sw==board[i][j] && dfs(board,vis,word,i,j,0))
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(exist(board,"ABCCED"));
    }
}
