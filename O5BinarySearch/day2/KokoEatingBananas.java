package O5BinarySearch.day2;

public class KokoEatingBananas {
    private static boolean isSafe(int[] piles,int hs,int k){
        long h = hs;
        long hrs=0;

        for(int i=0;i<piles.length;i++){
            hrs+= piles[i]/k;

            hrs = piles[i]%k!=0?hrs+1:hrs;
        }

        return hrs <= h;
    }
    public static int minEatingSpeed(int[] piles, int h) {
        int maxi=0;
        for(Integer it:piles)
            maxi=Math.max(maxi,it);
        int min=Integer.MAX_VALUE;
        int s=1,e=maxi;

        while(s<=e){
            int m = s+(e-s)/2;

            if(isSafe(piles,h,m)){
                min=m;
                e=m-1;
            }
            else{
                s=m+1;
            }
        }

        return min;
    }
    public static void main(String[] args) {
        System.out.println(minEatingSpeed(new int[]{-1,3,5,12},4));
    }
}
