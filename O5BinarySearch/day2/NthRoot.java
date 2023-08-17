package O5BinarySearch.day2;

public class NthRoot {
    public static int nthRoot(int n, int m) {
        int s=0,e=m/2;

        while(s<=e){
            int mid = s+(e-s)/2;

            if(Math.pow(mid,n)==m){
                return mid;
            }

            if(Math.pow(mid,n)>m){
                e=mid-1;
            }
            else{
                s=mid+1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(nthRoot(27,3));
    }
}
