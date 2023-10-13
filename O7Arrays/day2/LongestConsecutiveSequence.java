import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        int maxi=0,len=0;
        
        Set<Integer> st = new HashSet<>();
        
        for(int i:nums)
            st.add(i);
        
        int sz = st.size();
        
        for(Integer ele:st){
            // int ele;
            
            len=1;
            if(!st.contains(ele-1)){
                while(st.contains(ele+1)){
                    //means from here we start
                    len++;
                    ele=ele+1;
                }
                maxi = Math.max(maxi,len);
            }
        }
        
        return maxi;
    }
}
