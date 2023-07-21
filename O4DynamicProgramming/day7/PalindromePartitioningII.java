package O4DynamicProgramming.day7;
public class PalindromePartitioningII {
    /*
        s = "aabb"
    * s = "a"|"a"|"b"|"b" -> 3 cuts -> so we can say that for every input answer will always exist
    * s = "aa"|"b"|"b" -> 2 cuts
    * s = "a"|"a"|"bb" -> 2 cuts
    * s = "aa"|"bb" -> 1 cuts (min)


    * s = "aabb"
    * s = "a"|"abb"
    * 1. 1 + "a"|"a"|"bb" + 1 + "aa"|"bb"

     */
    static boolean isPalindrome(String s,int start,int end){
        while(start<end){
            if(s.charAt(start)!=s.charAt(end))return false;
            start++;
            end--;
        }
        return true;
    }
    static int getMinCutsUtil(String s,int start,int end,int[][] dp){
        if(start>=end)
            return 0;

        if(isPalindrome(s, start, end))
            return dp[start][end]=0;

        if(dp[start][end]!=-1)
            return dp[start][end];

        int mini=Integer.MAX_VALUE;

        for(int i=start;i<end;i++){

            int res=Integer.MAX_VALUE;
            /*
                * Instead of writing below standard line
                * We will recurse for only right part
                * Only when left part turns out to be palindrome

				* Reason : If left substring becomes palindrome then there is no need to partition it further
				* (which in turn reduces the number of recursive calls)

                * int temp =  solve (s, i, k, dp, palindrome) + solve (s, k+1, j, dp, palindrome) + 1;

            */
            if(isPalindrome(s,start,i)){

                res=1+getMinCutsUtil(s,i+1,end,dp);

            }
            mini=Math.min(mini,res);

        }
        return dp[start][end]=mini;
    }
    public static int minCut(String s) {
        int[][] dp=new int[s.length()][s.length()];

        for(int i=0;i<dp.length;i++){

            for(int j=0;j<dp[0].length;j++){

                dp[i][j]=-1;

            }
        }

        return getMinCutsUtil(s,0,s.length()-1,dp);
    }

    public static void main(String[] args) {
        System.out.println(minCut("aabb"));
    }
}