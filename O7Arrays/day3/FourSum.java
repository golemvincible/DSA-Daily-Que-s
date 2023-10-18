import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FourSum {
    //  [1,1,1,2,2,2,3,3,3,4,4,4,5,5]
    private static List<List<Integer>> twoptrs(int[] nums,int t){
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        
        Arrays.sort(nums);
        
        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1])   continue;
            
            for(int j=i+1;j<nums.length;j++){
                if(j>i+1 && nums[j]==nums[j-1])   continue;
                
                int k=j+1,l=n-1;
                
                while(k<l){
                    // long ans = nums[i] + nums[j] + nums[k] + nums[l];
                    long ans = 0;
                    ans+= nums[i];
                    ans+= nums[j];
                    ans+= nums[k];
                    ans+= nums[l];

                    
                    // System.out.println(nums[i]);
                    // System.out.println(nums[j]);
                    // System.out.println(nums[k]);
                    // System.out.println(nums[l]);
                    // System.out.println(ans);

                    
                    if(ans==(long)(t)){
                        System.out.println(ans);
                        List<Integer> li = new ArrayList<>();
                        
                        li.add(nums[i]);
                        li.add(nums[j]);
                        li.add(nums[k]);
                        li.add(nums[l]);
                        
                        res.add(li);
                        
                        k++;
                        l--;
                        
                        while(k<l && nums[k]==nums[k-1])    k++;
                        
                        while(l>k && nums[l]==nums[l+1])    l--;

                    }
                    
                    else if(ans<t){
                        k++;
                    }
                    else{
                        l--;
                    }
                }
            }
            
        }
        
        return res;
    }
    private static List<List<Integer>> hashing(int[] nums,int t){
        List<List<Integer>> res = new ArrayList<>();
        
        
        /*
            nums[i] + nums[j] + nums[k] + nums[l] = target
            
            nums[i] + nums[j] + nums[k] - target = nums[l]
        */
        
        Set<List<Integer>> s = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            
            for(int j=i+1;j<nums.length;j++){
                
                Map<Integer,Integer> m = new HashMap<>();
                for(int k=j+1;k<nums.length;k++){
                    
                    int ans = t - (nums[i] + nums[j] + nums[k]);
                    
                    // int ans = -(nums[i] + nums[j] + nums[k]); //t=0 in this que
                    
                    if(m.containsKey(ans)){
                        List<Integer> li = new ArrayList<>();
                        
                        li.add(nums[i]);
                        li.add(nums[j]);
                        li.add(nums[k]);
                        li.add(ans);
                        
                        Collections.sort(li);
                        s.add(li);

                    }
                    
                    m.put(nums[k],k);
                }
                
            }
        }
        
        
        for(List a:s){
            res.add(a);
        }
        return res;
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // return hashing(nums,target);
        
        return twoptrs(nums,target);
    }
}
