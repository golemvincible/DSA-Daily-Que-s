package O5BinarySearch.day1;

public class SingleElementinaSortedArray {
    public static int singleNonDuplicate(int[] arr) {


        int n = arr.length,s=0,e=n-1;

        while(s<=e){
            int m = s+(e-s)/2;

            if(m%2==1)  m++;


            if(m-1>=0 && arr[m-1]!=arr[m])
                s=m+2;
            else
                e=m-2;
        }

        return e>=0?arr[e]:arr[0];
    }
    public static void main(String[] args) {
        System.out.println(singleNonDuplicate(new int[]{4,5,6,7,0,1,2}));
    }
}
