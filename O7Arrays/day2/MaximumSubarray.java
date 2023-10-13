public class MaximumSubarray {
    private static int prefixSum(int[] nums){
        int n=nums.length;
        
        //it will store prefix sum
        int[] p = new int[n];
        p[0]=nums[0];
        
        for(int i=1;i<n;i++){
            p[i] = p[i-1] + nums[i];
        }
        
        /*
            we can say that to calculate sum of a subarray which is always contiguous
            
            * we know in prefix sum array we have stored sum of all the elements including that element
            * on its respective index position
            * so to calculate sum of a subarray whose we have start and end point (ofcourse)
            * we can just do this p[end] - p[start-1] = sum of subarray from start ind to end ind
            * since we know p[start-1] will store sum of all elements excluding the current element
              till the current element (current element in this case if nums[start])
            * p[end] will store sum of all elements including current element (current element in this case if nums[end])
            * so by subtracting them we will get our sum of subarray
        */
        int maxi=Integer.MIN_VALUE;
        for(int start = 0; start<n; start++){
            
            int currSum; //sum of subarray from start ind to end ind

            for(int end = start; end<n; end++){
                /*
                    * note that our formula is p[end] - p[start-1] = sum of subarray from start ind to end ind
                    * but when start==0 then we can't get start-1 or we'll get exception
                    * to imagine this taking eg. 1  5  2
                    * start = 0, end = 2;
                    * nums[start] = 1 , nums[end] = 2
                    * p[start] = 1 , p[end] = 8
                    * we know sum of subarray from start to end is 8 which is also nums[end] 
                    * so when our subarray starts from start=0 always it is common sense that
                      p[end] will be the sum from start to end
                */
                if(start==0){
                    currSum = p[end];
                }
                else{
                    currSum = p[end]-p[start-1];
                }
                
                maxi = Math.max(currSum,maxi);
            }
            
        }
        
        return maxi;
    }
    private static int brute(int[] nums){
        int maxi=Integer.MIN_VALUE;
        
        for(int i=0;i<nums.length;i++){
            int sum=0;
            for(int j=i;j<nums.length;j++){
                sum+=nums[j];
                maxi = Math.max(sum,maxi);
            }
        }
        
        return maxi;
    }
    private static int kedane(int[] nums){
        int sum=0,maxi=0,maxEle=nums[0];
        //we are also calculating maxElement because if all the elements are -ve we will return it
        
        /*
            * so basically if anytime the sum becomes < 0 then we will reset it to 0
            * also we will compare it with maxi everytime and find out the max sum
        */
        
        for(Integer it:nums){
            sum+=it;
            
            maxi = Math.max(sum,maxi);
            
            if(sum<0)   sum=0;
            maxEle = Math.max(maxEle,it);
        }
        
        return maxi==0?maxEle:maxi;
    }
    public int maxSubArray(int[] nums) {
        // return brute(nums);
        // return prefixSum(nums);
        return kedane(nums);
    }
}
