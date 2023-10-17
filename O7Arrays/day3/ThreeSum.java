import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
// [-2,-2,-2,-1,-1,-1,0,0,0,2,2,2,2]
public class ThreeSum {
    private static List<List<Integer>> app1(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        Set<List<Integer>> st = new HashSet<>();
        
        for(int i=0;i<nums.length-1;i++){
            Set<Integer> s = new HashSet<>();
            
            for(int j=i+1;j<nums.length;j++){
                
                int num = -(nums[i] + nums[j]);
                    
                if(!s.isEmpty() && s.contains(num)){
                    List<Integer> op=new ArrayList<>();
                    op.add(num);
                    op.add(nums[i]);
                    op.add(nums[j]);
                    Collections.sort(op);
                    st.add(new ArrayList<>(op));
                }
                
                s.add(nums[j]);
            }
        }
        for(List a:st){
            res.add(a);
        }
        return res;
    }
    private static List<List<Integer>> twoptr(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        
        Arrays.sort(nums);
        int n = nums.length;
        
        for(int i=0;i<n-1;i++){
            if(i>0 && nums[i]==nums[i-1])   continue;
            // List<Integer> op = new ArrayList<>();
            int j=i+1,k=n-1;
            
            while(j<k){
                int ans = nums[i] + nums[j] + nums[k];
                
                if(ans==0){
                    List<Integer> op = new ArrayList<>();
                    op.add(nums[i]);
                    op.add(nums[j]);
                    op.add(nums[k]);

                    res.add(op);
                    // res.add(new ArrayList<Integer>(nums[i],nums[j],nums[k]));
                    int jele = nums[j], kele = nums[k];
                    
                    while(jele==nums[j] && j<k)    j++;
                    
                    while(kele==nums[k] && k>j)    k--;

                }
                
                else if(ans<0){
                    j++;
                }
                else{
                    k--;
                }
            }
        }
        return res;
    }
    public List<List<Integer>> threeSum(int[] nums) {
        // return app1(nums);
        
        return twoptr(nums);
    }
}
