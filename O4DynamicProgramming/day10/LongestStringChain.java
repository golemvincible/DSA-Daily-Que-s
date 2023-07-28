package O4DynamicProgramming.day10;

import java.util.Arrays;

public class LongestStringChain {
    private static boolean isPredecessor(String str1,String str2){
        //str1 small str2 large
        if(str2.length()-str1.length()!=1)    return false;

        int si=0,li=0;
        while(li<str2.length()){
            if(si<str1.length() && str1.charAt(si)==str2.charAt(li)){
                si++;
                li++;
            }
            else{
                li++;
            }
        }

        return si == str1.length() && li == str2.length();
    }
    private static int helper(String[] words){
        int n = words.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp,1);
        int maxi=0;
        for(int i=0;i<n;i++){

            for(int j=0;j<i;j++){
                if(isPredecessor(words[j],words[i]) && 1 + dp[j]>dp[i]){
                    dp[i] = 1 + dp[j];
                }
            }
            maxi=Math.max(maxi,dp[i]);
        }
        return maxi;
    }
    private static void sort(String[] words){
        for(int i=0;i<words.length-1;i++){
            for(int j=i+1;j<words.length;j++){
                if(words[i].length()>words[j].length()){
                    String temp = words[i];
                    words[i] = words[j];
                    words[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(words));
    }
    public static int longestStrChain(String[] words) {
        sort(words);

        return helper(words);
    }

    public static void main(String[] args) {
        System.out.println(longestStrChain(new String[]{"a","b","ba","bca","bda","bdca"}));
    }
}
