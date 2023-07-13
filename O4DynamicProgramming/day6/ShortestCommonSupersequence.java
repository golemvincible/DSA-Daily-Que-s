package O4DynamicProgramming.day6;

public class ShortestCommonSupersequence {
    private static void fill(String[][] dp){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++)
                dp[i][j]="";
        }
    }
    private static String lcs(String str1,int m,String str2,int n,String[][] dp){


        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1] + str1.charAt(i-1);
                else
                    dp[i][j] = dp[i-1][j].length()>dp[i][j-1].length()?dp[i-1][j]:dp[i][j-1];
            }
        }
        System.out.println(dp[m][n]);
        return dp[m][n];
    }

    private static String generatingSCS(String str1,String str2){

        int m=str1.length(),n=str2.length();
        String[][] dp = new String[m+1][n+1];
        fill(dp);

        String resLCS = lcs(str1,m,str2,n,dp);


        //removing lcs from it

        int ind = 0;
        String res = "";

        int i=0,j=0;
        for(int k=0;k<resLCS.length();k++){
            char c = resLCS.charAt(k);
            //adding all characters b4 lcs from string 1
            while(str1.charAt(i)!=c){
                res+=str1.charAt(i);
                i++;
            }
            while(str2.charAt(j)!=c){
                res+=str2.charAt(j);
                j++;
            }
            res+=c;
            i++;
            j++;
        }
        while(i<str1.length())  res+=str1.charAt(i++);
        while(j<str2.length())  res+=str2.charAt(j++);
        return res;
    }
    public static String shortestCommonSupersequence(String str1, String str2) {
        return generatingSCS(str1,str2);
    }

    public static void main(String[] args) {
        System.out.println(shortestCommonSupersequence("abac","cab"));
    }
}
