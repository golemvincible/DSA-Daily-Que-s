//https://leetcode.com/problems/combination-sum/
//approach 2 using loops and recursion

import java.util.ArrayList;
import java.util.List;

public class CombinationSum1ii {
    public static void main(String[] args) {
        int[] arr = {2,3,6,7};
        int t=7;
        System.out.println(combinationSum(arr,t));
    }

    public static List<List<Integer>> combinationSum(int[] c, int t) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> op = new ArrayList<>();

        calculatingSum(c,t,res,op,0);

        return res;
    }

    private static void calculatingSum(int[] c, int t, List<List<Integer>> res, List<Integer> op,int start) {
        if(t<0)
            return;
        else if(t==0){
            res.add(new ArrayList<>(op));
        }
        else{
            for (int i = start; i < c.length; i++) {
                op.add(c[i]);
                calculatingSum(c,t-c[i],res,op,i);
                op.remove(op.size()-1);
            }
        }
    }
}