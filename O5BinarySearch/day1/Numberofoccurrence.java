package O5BinarySearch.day1;

public class Numberofoccurrence {
    private static int upperBound(int arr[], int n,int x){
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
    private static int lowerBound(int[] arr,int n,int x){
        int s=0,e=n-1;

        while(s<=e){
            int m=s+(e-s)/2;

            if(arr[m]>=x){
                e=m-1;
            }
            else{
                s=m+1;
            }
        }

        return e;
    }
    private static int count(int arr[], int n, int x) {
        int uB = upperBound(arr, n, x);
        int lB = lowerBound(arr, n, x);

        int fO=0,lO=0;

        if(uB-1>=0 && arr[uB-1]==x){
            lO = uB-1;
        }
        else{
            return 0;
        }

        if(lB+1<n && arr[lB+1]==x){
            fO = lB+1;
        }

        return lO-fO+1;
    }

    public static void main(String[] args) {
        System.out.println(count(new int[]{-1,3,5,5,12},5,5));
    }
}
