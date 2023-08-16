package O5BinarySearch.day1;

public class ImplementLowerBound{
    public static int lowerBound(int []arr, int n, int x) {
        int s=0,e=n-1;

        while(s<=e){
            int m = s+(e-s)/2;

            if(arr[m]==x)   return m;

            if(arr[m]<x)    s=m+1;

            else    e=m-1;
        }
        return s;
    }
    public static void main(String[] args) {
        System.out.println(lowerBound(new int[]{-1,3,5,12},4,2));
    }
}