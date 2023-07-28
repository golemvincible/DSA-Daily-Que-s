package O4DynamicProgramming.day10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LargestDivisibleSubset {
    private static List<Integer> solve(int[] nums){
        List<Integer> res = new ArrayList<>();

        Arrays.sort(nums);

        int n = nums.length;
        int[] dp = new int[n];
        int[] parent = new int[n];

        Arrays.fill(dp,1);
        Arrays.fill(parent,-1);

        int maxOverall=0,maxOverallInd=0;

        for(int i=0;i<n;i++){

            int maxi=-1,maxiInd=-1;

            for(int j=0;j<i;j++){

                if(nums[i]%nums[j]==0){

                    if(dp[j]>maxi){

                        maxi=dp[j];
                        maxiInd = j;

                    }

                }
            }
            dp[i] = dp[i] + maxi;
            parent[i] = maxiInd;
            // maxOverall = Math.max(maxOverall,dp[i]);
            if(dp[i]>maxOverall){
                //tail
                maxOverallInd = i;
                maxOverall = dp[i];
            }
        }


        int i = maxOverallInd;

        while(i!=-1){

            res.add(nums[i]);
            i = parent[i];

        }
        Collections.reverse(res);

        return res;
    }
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        return solve(nums);
    }

    public static void main(String[] args) {
        largestDivisibleSubset(new int[]{1,16,7,8,4});
    }
}