package O5BinarySearch.day1;

public class SearchinRotatedSortedArray {
    public static int search(int[] nums, int target) {
        int s=0,e=nums.length-1;

        // if(nums.length==2){
        //     if(nums[0]==target)
        //         return 0;
        //     else if(nums[1]==target)
        //         return 1;
        //     return -1;
        // }

        while(s<=e){
            int mid=s+(e-s)/2;

            if(nums[mid]==target)
                return mid;

            //left half of arr is sorted
            if(nums[mid]>=nums[s]){
                //figuring out whether the element lies on left half or not
                if(target>=nums[s] && target<nums[mid]){
                    e=mid-1;
                }
                else
                    s=mid+1;
            }

            //right side is sorted
            else{
                if(target>nums[mid] && target<=nums[e])
                    s=mid+1;
                else
                    e=mid-1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(search(new int[]{4,5,6,7,0,1,2},0));
    }
}
