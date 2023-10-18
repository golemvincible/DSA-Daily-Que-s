import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MajorityElementII {
    /*
        try out this test case while dry run
        [2,1,1,3,1,4,5,6]
    */
    private static List<Integer> hashing(int[] nums){
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        
        
        // It will store the number of occurances of a number in the array
        HashMap<Integer,Integer> m = new HashMap<>();
        
        for(int i=0;i<n;i++){
            m.put(nums[i],m.getOrDefault(nums[i],0)+1);
        }
        
        int times = n/3;
        //if it is coming more than times we will simply return it
        for(Integer it:m.keySet()){
            if(m.get(it)>times){
                res.add(it);
            }
        }
        
        return res;
    }
    private static List<Integer> boyermoore(int[] nums){
        int count1=0,count2=0,e1=-1,e2=-1;
        
        for(int i=0;i<nums.length;i++){
            if(count1==0){
                count1=1;
                e1 = nums[i];
            }
            else if(count2==0){
                count2=1;
                e2=nums[i];
            }
            else if(e1==nums[i]){
                count1++;
            }
            else if(e2==nums[i]){
                count2++;
            }
            else{
                count1--;
                count2--;
            }
        }
        List<Integer> res = new ArrayList<>();
        res.add(e1);
        res.add(e2);
        
        
        
        return res;
    }
    public List<Integer> majorityElement(int[] nums) {
        return hashing(nums);
    }
}
