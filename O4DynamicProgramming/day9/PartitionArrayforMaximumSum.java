package O4DynamicProgramming.day9;

public class PartitionArrayforMaximumSum {
    //no need to take j as only 1 changing parameter is there
    private static int solve(int[] arr,int k,int i,int[] dp){
        if(i==arr.length)
            return 0;

        if(dp[i]!=-1)   return dp[i];

        int len = 0,maxele=Integer.MIN_VALUE,maxSum = Integer.MIN_VALUE;


        /*
         * eg. 1st test case -> arr = [1,15,7,9,2,5,10], k = 3
         * for this we are looping from j=0 to j<3
         * this means j will have value 0,1,2

         * so image we are dividing the array like this that means we can divide the array like this

         * for j = 0 -> {1} {15,7,9,2,5,10} now this both will be independent subproblems
         * for j = 1 -> {1,15} {7,9,2,5,10} now this both will be independent subproblems
         * for j = 2 -> {1,15,7} {9,2,5,10} now this both will be independent subproblems

         * now we will calculate answers for them and will select the maximum out of them

         * we are using this condition j<Math.min(k+i,arr.length) because
         * eg we are solving this subproblem {9,2,5,10} where i = 3 so cond. becomes j<min(6,7)
         * so for j=3 {9} {2,5,10}
         * for j=4 {9,2} {5,10}
         * for j=5 {9,2,5} {10}

         * then we will call the func for i=6
         * so cond. becomes j=6 ; j<min(9,7)
         * so we only have one element in array so we only need to solve for it that's why we are taking min
         * so we will solve for {10} subproblem

         * then calling the recursion for j+1 i.e j=7
         * b.c. will be reached (i==arr.length) and we'll get 0 returned
         */
        for(int j=i;j<Math.min(k+i,arr.length);j++){
            len++;

            maxele = Math.max(maxele,arr[j]);

            /*
                * suppose our loop is running having len=3 i.e. length of subarray so all the elements
                  in it must be replaced by maxele
                * len is telling us how many elements are there in subarray so multiplying it with maxele
                  will give us the sum
                * suppose there are 4 maxelement i.e 15 so to calc sum we do 15+15+15+15 or 15*4 yeilds the same ans
            */

            int temp = len*maxele + solve(arr,k,j+1,dp);

            maxSum = Math.max(temp,maxSum);
        }
        return dp[i] = maxSum;
    }
    private static void fill(int[] dp){
        for (int i = 0; i < dp.length; i++) {

            dp[i]=-1;

        }
    }
    public static int maxSumAfterPartitioning(int[] arr, int k) {

        int[] dp= new int[arr.length+1];
        fill(dp);
        return solve(arr,k,0,dp);
    }

    public static void main(String[] args) {
        System.out.println(maxSumAfterPartitioning(new int[]{1,15,7,9,2,5,10},3));
    }
}
