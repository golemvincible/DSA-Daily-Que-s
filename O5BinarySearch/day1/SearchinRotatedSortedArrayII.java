package O5BinarySearch.day1;

public class SearchinRotatedSortedArrayII{
    public static boolean search(int[] nums, int target) {
        int s=0,e=nums.length-1;

        while(s<=e){
            int mid = s+(e-s)/2;

            if(nums[mid]==target)
                return true;
            //can't tell
            if(nums[s]==nums[mid]){
                s=s+1;
                continue;
            }
            //left half is sorted
            if(nums[s]<=nums[mid]){
                //lies in left half
                if(nums[s]<=target && target<nums[mid]){
                    e=mid-1;
                }
                else{
                    s=mid+1;
                }
            }
            //right half is sorted
            else{
                if(nums[mid]<target && target<=nums[e]){
                    s=mid+1;
                }
                else{
                    e=mid-1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{4,5,6,7,0,1,2},0));
    }
}