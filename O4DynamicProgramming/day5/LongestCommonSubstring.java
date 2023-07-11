package O4DynamicProgramming.day5;

public class LongestCommonSubstring {
    private static void fill(int[][] dp){
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j]=-1;
            }
        }
    }
    private static int tabulation(String t1, int m, String t2, int n, int[][] dp) {
        int max=0;
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
                    dp[i][j] = 0;

                max = Math.max(max,dp[i][j]);
            }
        }
        return max;
    }
    static int longestCommonSubstr(String text1, String text2, int m, int n){

        int[][] dp = new int[m+1][n+1];
        fill(dp);
        return tabulation(text1,m,text2,n,dp);

    }

    public static void main(String[] args) {
        String st1 = "ABCDGH";
        String st2 = "ACDGHR";

        System.out.println(longestCommonSubstr(st1,st2,st1.length(),st2.length()));
    }
}
