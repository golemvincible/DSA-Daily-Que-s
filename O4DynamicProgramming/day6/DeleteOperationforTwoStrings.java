package O4DynamicProgramming.day6;

public class DeleteOperationforTwoStrings {
    private static void fill(String[][] dp){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]="";
            }
        }
    }
    private static String lcs(String s1,int m,String s2,int n){

        String[][] dp = new String[m+1][n+1];

        fill(dp);



        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + s1.charAt(i-1);
                }
                else{
                    dp[i][j] = dp[i-1][j].length()>dp[i][j-1].length()?dp[i-1][j]:dp[i][j-1];
                }
            }
        }

        System.out.println(dp[m][n]);
        return dp[m][n];
    }
    public static int minDistance(String s1, String s2) {

        int m = s1.length();
        int n = s2.length();

        String resLCS = lcs(s1,m,s2,n);

        int r1 = m-resLCS.length();
        int r2 = n-resLCS.length();

        int total = r1 + r2;

        return total;
    }

    public static void main(String[] args) {
        System.out.println(minDistance("sea","eat"));
    }
}
