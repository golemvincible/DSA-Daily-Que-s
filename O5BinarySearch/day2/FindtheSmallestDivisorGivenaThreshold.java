package O5BinarySearch.day2;

public class FindtheSmallestDivisorGivenaThreshold {
    private static boolean isSafe(int[] nums, int t,int div){
        long s=0,thres=t;
        for(Integer it:nums){
            s+= it/div;
            s=it%div!=0?s+1:s;
        }
        return s<=thres;
    }
    public static int smallestDivisor(int[] nums, int t) {
        int s=1,e=0;
        for(Integer it:nums)
            e=Math.max(e,it);

        while(s<=e){
            int m=s+(e-s)/2;

            if(isSafe(nums,t,m))
                e=m-1;
            else
                s=m+1;
        }

        return s;
    }
    public static void main(String[] args) {
        System.out.println(smallestDivisor(new int[]{7,7,7,7,12,7,7},45));
    }
}
