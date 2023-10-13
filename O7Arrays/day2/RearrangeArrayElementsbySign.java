public class RearrangeArrayElementsbySign {
    private int[] solve(int[] nums){
        int n = nums.length;
        int[] res = new int[n];
        int k=0;
        
        int i=0;
        while(nums[i]<0)    i++;
        
        res[k] = nums[i++];
        k=2;

        //+
        for(;i<n && k<n;i++){
            if(nums[i]>0){
        // System.out.println(i);
        // System.out.println(k);
                res[k] = nums[i];
                k=k+2;
            }
        }
        // System.out.println(Arrays.toString(res));
        k=1;
        for(i=0;i<n && k<n;i++){
            if(nums[i]<0){
                res[k] = nums[i];
                k=k+2;
            }
        }
        
        return res;
    }
    
    public int[] rearrangeArray(int[] nums) {
        return solve(nums);
    }
}
