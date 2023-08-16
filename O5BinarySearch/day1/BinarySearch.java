package O5BinarySearch.day1;

public class BinarySearch {
    private static int bs(int[] nums,int t,int s,int e){
        if(s>e)
            return -1;
        int mid=s+(e-s)/2;

        if(nums[mid]==t)
            return mid;
        else if(t<nums[mid])
            e=mid-1;
        else
            s=mid+1;
        return bs(nums,t,s,e);
    }
    public static int search(int[] nums, int target) {
        return bs(nums,target,0,nums.length-1);
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{-1,3,5,12},2));
    }
}
