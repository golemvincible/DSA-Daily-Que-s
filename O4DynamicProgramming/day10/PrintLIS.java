package O4DynamicProgramming.day10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrintLIS {
    static int ans = 0,indans=-1;
    public static List<Integer> lengthOfLISOptimised(int[] nums) {

        int n = nums.length;

        //dp will store
        int[] dp = new int[n];

        int[] prvind = new int[n];

        for(int i=0;i<n;i++)   dp[i]=1;

        for(int i=0;i<n;i++)   prvind[i]=-1;

        for(int i=0;i<n;i++){
            //maxi from dp
            int maxi=0, ele = nums[i],prvi=-1;

            for(int j=0;j<i;j++){
                if(nums[j]<ele){
                    //then we need to find maximum of all nums[j]<ele from their dp array

//                    maxi = Math.max(maxi,dp[j]);

                    if(maxi<dp[j]){
                        maxi = dp[j];
                        prvi=j;
                    }
                }
            }
            dp[i] = dp[i] + maxi;
            prvind[i] = prvi;
//            ans = Math.max(ans,dp[i]);
            if(ans<dp[i]){
                ans = dp[i];
                indans = i;
            }
        }
        List<Integer> res = new ArrayList<>();

        res.add(nums[indans]);

        int i = indans;

        while (prvind[i]!=-1){
            int ind = prvind[i];

            res.add(nums[ind]);

            i=ind;
        }
        Collections.reverse(res);
        // System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLISOptimised(new int[]{10,9,2,5,3,7,101,18}));
    }
}
