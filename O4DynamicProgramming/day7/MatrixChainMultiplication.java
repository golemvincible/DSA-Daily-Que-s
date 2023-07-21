package O4DynamicProgramming.day7;

public class MatrixChainMultiplication {
    private static int mmRecursive(int arr[],int i,int j){
        if(i>=j)    return 0;

        int min = Integer.MAX_VALUE;

        for(int k=i;k<=j-1;k++){
            int temp = mmRecursive(arr,i,k) + mmRecursive(arr,k+1,j) + (arr[i-1] * arr[k] * arr[j]);

            min = Math.min(temp,min);
        }

        return min;
    }
    static void fill(int[][] dp){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }
    }
    static int mmMemo(int arr[],int i,int j,int[][] dp){
        if(i>=j)    return dp[i][j] = 0;

        if(dp[i][j]!=-1)    return dp[i][j];

        int min = Integer.MAX_VALUE;

        for(int k=i;k<=j-1;k++){
            int temp = mmMemo(arr,i,k,dp) + mmMemo(arr,k+1,j,dp) + (arr[i-1] * arr[k] * arr[j]);

            min = Math.min(temp,min);
        }

        return dp[i][j] = min;
    }
    static int matrixMultiplication(int N, int arr[])
    {
        int[][] dp = new int[N+1][N+1];
        fill(dp);
        return mmMemo(arr,1,N-1,dp);

    }

    public static void main(String[] args) {
        int[] arr = {40, 20, 30, 10, 30};

        System.out.println(matrixMultiplication(arr.length,arr));
    }
}
