//https://leetcode.com/problems/combination-sum-ii/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class CombinationSum2 {
    private static void combinationSum(int[] c, int t,int ind,List<Integer> ans,List<List<Integer>> res){
        if(t==0){
            res.add(new ArrayList<>(ans));
            return;
        }

        for(int i=ind;i<c.length;i++){

            // picking the first element from same elements coz i==ind is the first element and skipping all the same elements
            if(i>ind && c[i]==c[i-1])
                continue;
            /*
                we won't check any further because we know array is sorted if current ele is greater than target
                then all the next elements will also be greater than target this is the reason why we sorted
                the array in the first place
            */
            if(c[i]>t){
                break;
            }

            /*
                if we are here that means c[i]<=t so we will reduce our target
                add c[i] to our data structure
                and call the recursion for further
            */
            ans.add(c[i]);
            combinationSum(c,t-c[i],i+1,ans,res);
            /*
                we know first left recursion happens then right so now we need to backtrack so that right
                recursion can happen
            */
            ans.remove(ans.size()-1);
        }
    }
    public static List<List<Integer>> combinationSum2(int[] c, int t) {
        Arrays.sort(c);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        combinationSum(c,t,0,ans,res);

        return res;
    }
    public static void main(String[] args) {
        int[] arr = {10,1,2,7,6,1,5};
        int t=8;
        System.out.println(combinationSum2(arr,t));
    }
}