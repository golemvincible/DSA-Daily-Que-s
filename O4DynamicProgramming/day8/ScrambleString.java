import java.util.HashMap;
import java.util.Map;

public class ScrambleString {
    private static boolean solve(String s1,String s2,Map<String,Boolean> dp){

        if(s1.length()!=s2.length())
            return false;

        if(s1.length()==0 && s2.length()==0)
            return true;

        if(s1.equals(s2))
            return true;

        /*
         * mtlb either humare paas 1 character hai ya phir
         * 0 character hai
         * iske just upper wali condition mein humne check kara hai jo aakhri bacha character
         * hai vo equal hai ya nahi par agar hum iss condition tak aa gye hai that means
         * equal nahi h bcha hua character to hum false return kar denge
         */
        if(s1.length()<=1)
            return false;

        String temp = s1 + " " + s2;

        if(dp.containsKey(temp))
            return dp.get(temp);

        // int n = s1.length();
//         for(int i=1;i<n;i++){
//             if(

//                 (solve(s1.substring(0,i),s2.substring(0,i),dp) && solve(s1.substring(i+1,n),s2.substring(i+1,n),dp))
//                             ||
//                             (solve(s1.substring(0,i+1),s2.substring(n-1-i,n),dp) && solve(s1.substring(i+1,n),s2.substring(0,i+1),dp))
//               )

//             {
//                 dp.put(temp,true);
//                 return dp.get(temp);
//             }
//         }
//         dp.put(temp,false);
        boolean flag=false;
        int n=s1.length();
        for(int i=1;i<n;i++)
        {
            boolean swap=(solve(s1.substring(0, i),s2.substring(n - i,n),dp) && solve(s1.substring(i, n),s2.substring(0, n-i),dp));

            boolean noswap=(solve(s1.substring(0, i),s2.substring(0, i),dp)  && solve(s1.substring(i, n),s2.substring(i, n),dp));

            if(noswap||swap)
            {
                flag=true;
                break;
            }
        }
        dp.put(temp,flag);
        return dp.get(temp);
    }
    private static void fill(int[][] dp){
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j]=-1;
            }
        }
    }
    public static boolean isScramble(String s1, String s2) {
        int n = s1.length();
        Map<String,Boolean> dp = new HashMap<>();
        // fill(dp);
        return solve(s1,s2,dp);
    }

    public static void main(String[] args) {
        System.out.println(isScramble("great","rgeat"));
    }
}
