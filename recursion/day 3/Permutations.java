import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/permutations/
public class Permutations {
    private static void helper(int[] nums,boolean[] vis,List<Integer> op,List<List<Integer>> res){
        if(op.size()==nums.length){
            res.add(new ArrayList<>(op));
            return;
        }

        for(int i=0;i<nums.length;i++){
            // we are dealing withb positions not value that's why we are checking whether the pos is filled or not
            if(!vis[i]){

                vis[i]=true;
                op.add(nums[i]);

                helper(nums,vis,op,res);

                op.remove(op.size()-1);
                vis[i]=false;

            }
        }

    }
    public static List<List<Integer>> permute(int[] nums) {
        boolean[] vis = new boolean[nums.length];
        List<Integer> op = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        helper(nums,vis,op,res);

        return res;
    }

    public static void main(String[] args) {
        int[] arr={1,2,3};
        System.out.println(permute(arr));
    }
}
