package O4DynamicProgramming.day5;

public class PrintLCS {
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
    static String printinglongestCommonSubstr(String text1, String text2, int m, int n){

        int[][] dp = new int[m+1][n+1];
        fill(dp);
        tabulation(text1,m,text2,n,dp);

        return printingLCS(text1,m,text2,n,dp);
    }

    private static String printingLCS(String text1,int m, String text2,int n, int[][] dp) {
        int i=m,j=n;
        String res = "";
        while(i>0 && j>0){
            if(text1.charAt(i-1)==text2.charAt(j-1)){
                res=text1.charAt(i-1) + res;

                i = i-1;
                j = j-1;
            }
            else{
                if(dp[i-1][j]>dp[i][j-1]){
                    i=i-1;
                }
                else{
                    j=j-1;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String st1 = "abcdaf";
        String st2 = "acbcf";

        System.out.println(printinglongestCommonSubstr(st1,st2,st1.length(),st2.length()));
    }
}
