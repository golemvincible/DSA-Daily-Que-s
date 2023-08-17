package O5BinarySearch.day2;

public class MinimumNumberofDaystoMakemBouquets {
    private static boolean isSafe(int[] b, int m, int k,int day){
        int streak=0,bloom=0;

        for(Integer it:b){
            if(it<=day){
                bloom++;
            }
            else
                bloom=0;

            if(bloom==k){
                streak++;
                bloom=0;
            }
        }
        return streak>=m;
    }
    public static int minDays(int[] bloomDay, int m, int k) {
        int maxi = Integer.MIN_VALUE,mini=Integer.MAX_VALUE;
        for(Integer it:bloomDay){
            maxi=Math.max(maxi,it);
            mini=Math.min(mini,it);
        }

        int s=mini,e=maxi;

        while(s<=e){
            int mid = s+(e-s)/2;

            if(isSafe(bloomDay,m,k,mid))
                e=mid-1;
            else
                s=mid+1;
        }

        return s==maxi+1?-1:s;
    }
    public static void main(String[] args) {
        System.out.println(minDays(new int[]{7,7,7,7,12,7,7},2,3));
    }
}
