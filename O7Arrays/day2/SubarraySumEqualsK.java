import java.util.HashMap;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int ans=0;
        HashMap<Integer,Integer> m = new HashMap<>();
        m.put(0,1);
        
        int sum=0,count=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            
            int rem = sum-k;
            
            if(m.containsKey(rem)){
                
                count+=m.get(rem);
                // m.put(rem,m.get(rem)+1);
            }
            if(m.containsKey(sum))
                m.put(sum,m.get(sum)+1);
            else
                m.put(sum,1);       
        }
        
        return count;
    }
}
