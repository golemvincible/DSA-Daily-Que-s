package O5BinarySearch.day1;

public class TimesArrayISRotated {
    public static int findKRotation(int []arr){
        int s=0,e=arr.length-1;

        while(s<=e){
            if(arr[s]<arr[e])   return s;

            int m = s+(e-s)/2;

            if(arr[s]>arr[m])
                e=m;
            else
                s=m+1;
        }

        return s-1;
    }
    public static void main(String[] args) {
        System.out.println(findKRotation(new int[]{4,5,6,7,0,1,2}));
    }
}
