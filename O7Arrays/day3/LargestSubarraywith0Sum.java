import java.util.HashMap;

public class LargestSubarraywith0Sum {
    int hashing(int[] arr,int n){
        HashMap<Long,Integer> m = new HashMap<>();
        long sum=0;int maxi=0;
        for(int i=0;i<n;i++){
            
            sum+=arr[i];
            if(sum==0)  maxi=i+1;
            
            if(m.containsKey(sum)){
                maxi = Math.max(maxi,i-m.get(sum));
            }
            else
                m.put(sum,i);
        }
        
        return maxi;
    }
    int maxLen(int arr[], int n)
    {
        return hashing(arr,n);
    }
}
