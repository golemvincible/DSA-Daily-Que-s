package O4DynamicProgramming.day7;

public class LongestRepeatingSubsequence {
    private static int recursive(String str1,int m, String str2,int n){
        if(m==0 || n==0)    return 0;

        if(str1.charAt(m-1)==str2.charAt(n-1) && m!=n){
            return 1 + recursive(str1,m-1,str2,n-1);
        }

        return Math.max(recursive(str1,m,str2,n-1),recursive(str1,m-1,str2,n));
    }
    private static int memoize(String str1,int m, String str2,int n,int[][] dp){
        if(m==0 || n==0)    return 0;

        if(dp[m][n]!=-1)    return dp[m][n];

        if(str1.charAt(m-1)==str2.charAt(n-1) && m!=n){
            return dp[m][n] = 1 + recursive(str1,m-1,str2,n-1);
        }

        return dp[m][n] = Math.max(recursive(str1,m,str2,n-1),recursive(str1,m-1,str2,n));
    }
    private static void fill(int[][] dp){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }
    }
    private static int tabulation(String str1,int m, String str2,int n,int[][] dp){
        for(int i=0;i<dp.length;i++){
            dp[i][0] = 0;
        }
        for(int i=0;i<dp[0].length;i++){
            dp[0][i] = 0;
        }

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1) && i!=j)
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
            }
        }
        return dp[m][n];
    }
    public static int LongestRepeatingSubsequence(String str)
    {
        int m=str.length(),n=str.length();
        int[][] dp = new int[m+1][n+1];
        fill(dp);
        return tabulation(str,m,str,n,dp);
    }
    public static void main(String[] args) {
        String str = "axxzxy";

        System.out.println(LongestRepeatingSubsequence(str));
    }
}
