//https://leetcode.com/problems/subsets-ii/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets2 {
    private static void helpersubsetsWithDup(int[] nums,List<Integer> op,List<List<Integer>> res,int start){

        res.add(new ArrayList<>(op));

        for(int i=start;i<nums.length;i++){
            /*
                we have included start element thats why we will start checking
                from next element of start
                if the next ele is equal to prev we will skip
                no further recursion calls for them as they will generate
                same answers
            */
            if(i>start && nums[i]==nums[i-1])
                continue;

            op.add(nums[i]);
            helpersubsetsWithDup(nums,op,res,i+1);
            op.remove(op.size()-1);
        }

    }
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> op = new ArrayList<>();
        /*
            because we are dealing with positions so we want to skip duplicates
            which can only be done if they all come together thats why we are sorting
            the array
        */
        Arrays.sort(nums);
        helpersubsetsWithDup(nums,op,res,0);

        return res;
    }

    public static void main(String[] args) {
        int arr[]={1,2,2};
        System.out.println(subsetsWithDup(arr));
    }
}

