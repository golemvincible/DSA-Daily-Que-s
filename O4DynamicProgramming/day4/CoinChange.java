package O4DynamicProgramming.day4;

import java.util.HashMap;
import java.util.Map;

public class CoinChange {
    public static void main(String[] args) {
        int[] curr={1,2,3};
        int target=7;
        Map<Integer,Integer> m = new HashMap<Integer,Integer>();
        int res=util(curr,target,m);
        if(res==Integer.MAX_VALUE){
            res=-1;
        }
        System.out.println(res);
    }

    private static int util(int[] curr, int target,Map<Integer,Integer> m) {
        if(target==0){
            return 0;
        }
        if(target<0){
            return Integer.MAX_VALUE;
        }
        int min=Integer.MAX_VALUE;
        if(m.containsKey(target)){
            return m.get(target);
        }
        for(int i=0;i<curr.length;i++){
            int partialAns = util(curr,target-curr[i],m);

            if(partialAns!=Integer.MAX_VALUE){
                min=Math.min(min,partialAns+1);
            }
        }
        m.put(target,min);
        return m.get(target);
    }
}
