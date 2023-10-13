import java.util.Arrays;

public class NextPermutation {
    private void reverse(int[] a){
        int n=a.length;
        int i, t;
        for (i = 0; i < n / 2; i++) {
            t = a[i];
            a[i] = a[n - i - 1];
            a[n - i - 1] = t;
        }
    }
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i=n-2;
        while(i>=0 && nums[i]>=nums[i+1]){    
            i--;
        }
            System.out.println(i);
        
        if(i==-1)
            reverse(nums);
        else{
            Arrays.sort(nums,i+1,n);
            int j=i+1;
            for(;j<n;j++){
                if(nums[j]>nums[i]){
                    int temp = nums[j];
                    nums[j]=nums[i];
                    nums[i]=temp;
                    
                    break;
                }
            }
            
            if(j==n){
                int temp=nums[j-1];
                nums[j-1]=nums[i];
                nums[i]=temp;
            }
        }
    }
}
