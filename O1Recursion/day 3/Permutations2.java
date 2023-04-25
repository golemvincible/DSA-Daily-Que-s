import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//https://leetcode.com/problems/permutations-ii/
public class Permutations2 {
    private static void helperPermuteUnique(int[] nums,List<List<Integer>> res,List<Integer> op,boolean[] used){
        if(op.size()==nums.length){
            res.add(new ArrayList<>(op));
            return;
        }

        for(int i=0;i<nums.length;i++){
            /*
                nums[i]==nums[i-1] && !used[i-1]
                Agar iske pehle wala used hai that means vo 1st position pr fill
                ho chuka hai
                to hum next same(consecutive same) ko use kr skte hai pr agar 1st
                wala unused hai that means hum 1st wale ke liye recursion call
                complete kr chuke hai ans le chuke hai phir backtrack kra hai
                isliye unused hai vo

                basically prev used hai that means isse just pehle wali pos pr fill kr chuke
                hai to ab hum next same ko next position pr fill kr skte hai
            */
            if(used[i] || i>0 && nums[i]==nums[i-1] && !used[i-1])
                continue;

            used[i]=true;

            op.add(nums[i]);
            helperPermuteUnique(nums,res,op,used);
            op.remove(op.size()-1);

            used[i]=false;
        }
    }
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> op = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);

        helperPermuteUnique(nums,res,op,used);

        return res;
    }

    public static void main(String[] args) {
        int[] nums={1,1,2};
        System.out.println(permuteUnique(nums));
    }
}
