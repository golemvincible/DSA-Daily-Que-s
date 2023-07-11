package O4DynamicProgramming.day5;

public class LongestCommonSubsequence {
    private static int recursive(String t1,int m, String t2,int n){
        if(m==0 || n==0)    return 0;

        if(t1.charAt(m-1)==t2.charAt(n-1))
            return 1+recursive(t1,m-1,t2,n-1);

        return Math.max(recursive(t1,m-1,t2,n),recursive(t1,m,t2,n-1));
    }
    private static void fill(int[][] dp){
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j]=-1;
            }
        }
    }


    public static int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length(),n=text2.length();

        int[][] dp = new int[m+1][n+1];
        fill(dp);

        return memoization(text1,m,text2,n,dp);

//        return recursive(text1,m,text2,n);
    }

    private static int tabulation(String t1, int m, String t2, int n, int[][] dp) {

        for (int i = 0; i <= m; i++) {
            dp[i][0]=0;
        }
        for (int i = 0; i <= n; i++) {
            dp[0][i]=0;
        }

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
    private static int memoization(String t1, int m, String t2, int n, int[][] dp){
        if(m==0 || n==0)    return 0;

        if(dp[m][n]!=-1)    return dp[m][n];
        
        if(t1.charAt(m-1)==t2.charAt(n-1))
            return dp[m][n] = 1+memoization(t1,m-1,t2,n-1,dp);

        return dp[m][n] = Math.max(memoization(t1,m-1,t2,n,dp),memoization(t1,m,t2,n-1,dp));
    }

    public static void main(String[] args) {
        String text1 = "pmjghexybyrgzczy";
        String text2 = "hafcdqbgncrcbihkd";

        System.out.println(longestCommonSubsequence(text1,text2));
    }
}
