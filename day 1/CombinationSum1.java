import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/combination-sum/
//approach 1 only recursion no loops
public class CombinationSum1 {
    private static void calculatingSum(int[] c, int t,List<List<Integer>> res,List<Integer> op,int ind){
        
        if(ind==c.length){
            if(t==0){
                res.add(new ArrayList<>(op));
            }
            return;
        }
        
        //include
        if(t-c[ind]>=0){
            op.add(c[ind]);
            calculatingSum(c,t-c[ind],res,op,ind);
            op.remove(op.size()-1);
        }
        
        //exclude
        calculatingSum(c,t,res,op,ind+1);
    }
    public static List<List<Integer>> combinationSum(int[] c, int t) {
        
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> op = new ArrayList<>();
        
        calculatingSum(c,t,res,op,0);
        
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        int t=8;
        System.out.println(combinationSum(arr,t));
    }
}
