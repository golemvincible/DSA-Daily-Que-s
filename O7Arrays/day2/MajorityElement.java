public class MajorityElement {
    private static int mooreVotingAlgo(int[] nums){
        int ans=nums[0],count=1;
        int ele = nums[0];
        
        
        for(int i=1;i<nums.length;i++){
            if(count==0){
                ele = nums[i];
                ans=nums[i];
            }
            
            if(nums[i]!=ele){
                count--;
            }
            else{
                count++;
            }
        }
        
        return ans;
    }
    public int majorityElement(int[] nums) {
        return mooreVotingAlgo(nums);
    }
}
