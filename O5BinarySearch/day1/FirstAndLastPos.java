package O5BinarySearch.day1;

import java.util.Arrays;

public class FirstAndLastPos {
    private static int lowerBound(int[] nums,int target){
        int s=0,e=nums.length-1;

        while(s<=e){
            int m=s+(e-s)/2;

            if(nums[m]>=target){
                e=m-1;
            }
            else{
                s=m+1;
            }

        }
        // System.out.println(s);

        return e;
    }
    private static int upperBound(int[] nums,int target){
        int s=0,e=nums.length-1;

        while(s<=e){
            int m=s+(e-s)/2;

            if(nums[m]<=target){
                s=m+1;
            }
            else{
                e=m-1;
            }

        }
        System.out.println(s);
        return s;
    }
    public static int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int lB = lowerBound(nums,target);
        int uB = upperBound(nums,target);

        int[] ans = new int[2];

        if(lB+1<n && nums[lB+1]==target)    ans[0] = lB+1;
        else{
            ans[0]=-1;
            ans[1]=-1;

            return ans;
        }

        if(uB-1>=0&& nums[uB-1]==target)    ans[1] = uB-1;

        return ans;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{-1, 3, 5, 12}, 4)));
    }
}
