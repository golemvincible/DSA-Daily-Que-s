package O5BinarySearch.day1;

public class ImplementUpperBound {
    public static int upperBound(int []arr, int x, int n){
        int s=0,e=n-1;

        while(s<=e){
            int m=s+(e-s)/2;

            if(arr[m]<=x){
                s=m+1;
            }
            else{
                e=m-1;
            }
        }
        return s;
    }
    public static void main(String[] args) {
        System.out.println(upperBound(new int[]{-1,3,5,12},4,2));
    }
}
