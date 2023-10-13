import java.util.*;
class TwoSum{
    private static int[] brute(int[] nums, int t){
        int n=nums.length;
        int[] ans = new int[2];
        
        for(int i=0;i<n;i++){
            
            for(int j=i+1;j<n;j++){
                
                if(nums[i]+nums[j]==t){
                    return new int[]{i,j};
                }
            }
        }
        
        return new int[]{-1,-1};
    }
    
    private static int[] hashing(int[] nums,int t){
        int n=nums.length;

        HashMap<Integer,Integer> m = new HashMap<>();
        
        for(int i=0;i<n;i++){
            int req = t - nums[i];
            
            if(m.containsKey(req)){
                return new int[]{m.get(req),i};
            }
            else{
                m.put(nums[i],i);
            }
            
        }
        
        return new int[]{-1,-1};
    }
    public int[] twoSum(int[] nums, int target) {
        // return brute(nums,target);
        
        return hashing(nums,target);
    }
}