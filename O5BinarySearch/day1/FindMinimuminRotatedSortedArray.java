package O5BinarySearch.day1;

public class FindMinimuminRotatedSortedArray {
    public static int findMin(int[] nums) {
        int s=0,e=nums.length-1;

        while(s<e){
            if(nums[s]<nums[e])
                return nums[s];

            int mid=s+(e-s)/2;

            /*
             * hum jaante hai ki start end se bada hai
             * to ab hum check karenge ky start mid se bhi bada hai
             * agar start mid se bhi bada hota hai that means mid chota hai start se
             * to mid ke baad wale elements to mid se bade hi honge to hume waha to humara ans milega nhi
             * par start se lekr mid tak mai humara ans ho sakta hai
             */
            if(nums[s]>nums[mid]){
                e=mid;
            }
            else
                s=mid+1;
        }
        return nums[s];
    }
    public static void main(String[] args) {
        System.out.println(findMin(new int[]{4,5,6,7,0,1,2}));
    }
}
