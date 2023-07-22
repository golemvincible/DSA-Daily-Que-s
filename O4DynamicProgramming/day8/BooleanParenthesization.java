public class BooleanParenthesization {
    static int mod = 1003;
    //isTrue hume bata raha hai ki humara target kya hai
    private static int solve(int n,String s,int i,int j,boolean isTrue,int[][][] dp){
        //invalid string
        if(i>j)
            return 0;

        //only one character
        if(i==j){

            if(isTrue){
                //matlab main true dhundh raha hoon
                return s.charAt(i)=='T'?1:0;
            }
            else{
                //matlab main false dhundh raha hoon
                return s.charAt(i)=='F'?1:0;
            }
        }

        // String st = Integer.toString(i)+" "+Integer.toString(j)+" "+String.valueOf(isTrue);

        int iT = isTrue?1:0;

        if(dp[iT][i][j]!=-1){
            return dp[iT][i][j];
        }

        int ans=0;

        /*
         * k will always be on operator
         * i and j will be on operand
         * as said k will always be an operator that's why we are incrementing it k = k+2
         * j is at an operand(right most) that's why we are going till j-1
         * i is also at an oprand that's why going from i+1
         * k must only land at operator that's why incrementing by 2
         */
        for(int k=i+1;k<=j-1;k=k+2){
            /*
             * we are searching for true as well as false because

             * f ^ f = f
             * t ^ t = f
             * f ^ t = t
             * t ^ f = t

             * so, in order to find all true's we also need to find all false's because,

             * f ^ t = t
             * t ^ f = t

             * there are only these 2 conditions that can give us result as true
             * which means to obtain the result true we need either one to be false and other one to be true
             * to ensure or do so we need to find false
             * as we can see f ^ t = t here f is in left, t is in right that's why we calulate lf,rt
             * as we can see t ^ f = t here t is in left, f is in right that's why we calulate lt,rf

             * similarly we can check for | as well as &

             */
            int lf = solve(n,s,i,k-1,false,dp)%mod;

            int lt = solve(n,s,i,k-1,true,dp)%mod;

            int rt = solve(n,s,k+1,j,true,dp)%mod;

            int rf = solve(n,s,k+1,j,false,dp)%mod;

            // conditions for evaluation

            if(s.charAt(k)=='&'){
                if(isTrue==true){
                    // for & only T & T = T so that means lt * rt will generate our ans for true case
                    ans+=lt*rt;
                }
                else{
                    // for & only F & T = F, T & F = F, F & F = F so that means lf * rt,lt * rf,lf * rf will generate our ans for false case
                    ans+= lf * rt + lt * rf + lf * rf;
                }
            }
            else if(s.charAt(k)=='|'){
                if(isTrue==true){
                    // for |,  T | T, T | F, F | T = T so that means lt * rt, lt * rf, lf * rt will generate our ans for true case

                    ans+= lt * rt + lf * rt + lt * rf;
                }
                else{
                    // for |,  F | F so that means lf * rf will generate our ans for false case
                    ans+= lf * rf;
                }
            }
            else if(s.charAt(k)=='^'){
                if(isTrue==true){
                    // for ^,  f ^ t, t ^ f  so that means lf * rt, lt * rf will generate our ans for this case

                    ans+= lf * rt + lt * rf;
                }
                else{
                    // for ^,  f ^ f , t ^ t  so that means lf * rf, lt * rt will generate our ans for false case

                    ans+= lf * rf + lt * rt;
                }
            }

        }
        dp[iT][i][j]=ans%mod;
        return dp[iT][i][j];
    }
    static void fill(int[][][] dp,int n){
        for(int i=0;i<=1;i++){
            for(int j=0;j<=n;j++){
                for(int k=0;k<=n;k++){
                    dp[i][j][k]=-1;
                }
            }
        }
    }
    static int countWays(int N, String S){
        // isTrue i j
        int[][][] dp = new int[2][N+1][N+1];

        fill(dp,N);
        // Map<String,Integer> dp = new HashMap<>();
        return solve(N,S,0,N-1,true,dp);
    }

    public static void main(String[] args) {
        System.out.println(countWays(35,"T|F^F&T|F^F^F^T|T&T^T|F^T^F&F^T|T^F"));
    }

}

