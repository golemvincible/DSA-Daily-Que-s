package O4DynamicProgramming.day6;

public class LongestPalindromicSubsequence {
    private static int lcs(String t1, int m, String t2, int n, int[][] dp) {



        for(int i=1;i<=m;i++){
            for (int j = 1; j <= n; j++) {
                if(t1.charAt(i-1)==t2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max ( dp[i][j-1] , dp[i-1][j] );
            }
        }
        return dp[m][n];
    }
    private static String reverse(String s){
        String res="";
        for(int i=s.length()-1;i>=0;i--){
            res+=s.charAt(i);
        }
        return res;
    }
    public static int longestPalindromeSubseq(String s) {
        String s1 = s;
        String s2 = reverse(s);

        int m=s1.length(),n=s2.length();

        int[][] dp = new int[m+1][n+1];

        int resLCS = lcs(s1,m,s2,n,dp);

        return resLCS;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindromeSubseq("bbbab"));
    }
}
