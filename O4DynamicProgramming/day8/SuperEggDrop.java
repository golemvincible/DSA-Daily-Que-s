public class SuperEggDrop {
    /*
        The basic idea is, we have to find the minimum number of attempts to find the
        Threshold Floor, that means, above that floor the egg will break and below that
        floor the egg will not break

        So, we have two choices
        1. Egg will break
        2. Egg will not break

        -> For the first case if the egg will break from a particular floor then we have to go below
        that floor
        -> For the second case if the egg will not break from a particular floor then we have to go
        above to find the threshold floor

        Base Conditions:
        1. It is given that egg the will not be 0 so no check for this in code
        2. If the egg will be 1 i.e. k = 1, So we need at minimum n moves to determine what the value
            of floor is i.e n attempts.
        3. If the n is 0 then no floor 0 attempt.
        4. If the n is 1 then only 1 attempt.
*/
    private static int solve(int eggs,int f,int[][] dp){
         if(f==0 || f==1){
             return f;
         }
         if(eggs==1)
             return f;

         if(dp[eggs][f]!=-1)
             return dp[eggs][f];

         int min = Integer.MAX_VALUE;
        /*
            * It is very important to understand why we are sending (f-k) in case of egg didn't break and again
            * using a for loop where k is initiated from 1 again.

            * the reason is we are checking for a range where we are min number of possibly attempt where egg didn't break.

            Let's say in simple terms there are 10 floor.
            Egg didn't break from 7th floor. So now only 10-7 = 3 floor needs to be checked.
            But to check the next 3 floor we need to use a k loop again.
            Here k=1 will represent 8th floor.
            Here k=2  will represent 9th floor.
            Here k=3  will represent 10th floor.

            So to answer the initial question , we need to check the min number of attempts in next 3 floors and that is why we are sending (f-k) and k range is (1,f-k)

        */
         for(int i=1;i<=f;i++){

             int down = dp[eggs-1][i-1]!=-1?dp[eggs-1][i-1]:solve(eggs-1,i-1,dp);
             int up = dp[eggs][f-i]!=-1?dp[eggs][f-i]:solve(eggs,f-i,dp);

             int attempts = 1 + Math.max(down,up);

             min = Math.min(min,attempts);
         }

         return dp[eggs][f]=min;
     }
    private static void fill(int[][] dp){
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j]=-1;
            }
        }
    }
    private static int solveOptimized(int eggs,int f,int[][] dp){
        if(f==0 || f==1){
            return f;
        }
        if(eggs==1)
            return f;

        if(dp[eggs][f]!=-1)
            return dp[eggs][f];

        int min = Integer.MAX_VALUE;

        int low = 0,high = f,temp=0;

        while(low<=high){
            int mid = (low+high)/2;
            /*
             * representing both the choices with memo
             * First one, if the egg will break, no. of eggs will decreased and we have to
             * down from that floor.
             * Second one, if the egg will not break, no. of eggs will not decreased and we
             * have to go above form that floor.
             */
            int down = solveOptimized(eggs-1,mid-1,dp);
            int up = solveOptimized(eggs,f-mid,dp);

            temp = 1 + Math.max(down,up);

            //since we need more temp value in worst case, so need to go above
            if(down<up){
                low = mid + 1;
            }
            else{
                high = mid - 1;     //move to the downward
            }

            min = Math.min(min,temp);
        }
        return dp[eggs][f] = min;
    }
    public static int superEggDrop(int k, int n) {
        int[][] dp = new int[k+1][n+1];
        fill(dp);
//        return solve(k,n,dp);
        return solveOptimized(k,n,dp);
    }

    public static void main(String[] args) {
        System.out.println(superEggDrop(7,1000));
    }
}

