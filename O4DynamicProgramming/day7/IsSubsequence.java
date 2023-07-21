package O4DynamicProgramming.day7;

public class IsSubsequence {
    private static int tabulation(String s1,int m,String s2,int n,int[][] dp){
        String res = "";

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }

        return dp[m][n];
    }
    public static boolean isSubsequence(String s, String t) {
        int m = s.length(),n = t.length();

        int[][] dp = new int[m+1][n+1];

        if(tabulation(s,m,t,n,dp) == m)
            return true;
        return false;
    }

    public static void main(String[] args) {

        String s1="abc";
        String s2 = "ahbgdc";

        System.out.println(isSubsequence(s1,s2));
    }
}
