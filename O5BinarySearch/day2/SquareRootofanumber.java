package O5BinarySearch.day2;

public class SquareRootofanumber {
    public static int sqrtN(long n) {
        if(n==1)	return 1;

        int s=1,e=(int)n/2;

        while(s<=e){
            int m = s+(e-s)/2;

            int sq = m*m;

            if(sq==n)	return m;

            if(sq<n){
                s=m+1;
            }
            else{
                e=m-1;
            }
        }

        return e;
    }

    public static void main(String[] args) {
        System.out.println(sqrtN(6));
    }
}
