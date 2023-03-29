

import java.util.Arrays;
import java.util.Stack;

public class StockSpanProblem {
    private static int[] stockSpan(int[] arr){
        int[] res = new int[arr.length];

        Stack<int[]> st = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            int span=1;

            /*
            agr hume iss while loop ke andr entry milti hai that means stack ka top current price se chota
            hai ya barabar hai
            to hum uske span ko humare ans ka part maan skte h qki hume pta h vo current price se chota h
            to hum useke span ko humare span m add kr denge
            Vo price uske pehle wali jitni bhi uss price se small ya barabar price thi unke span lekr bethi
            thi to humne uske span ko humare ans m add kr liya to ultimately usse jitne bhi chote consecutive
            prices the unn sbke span bhi aa gye
        */
            while(!st.isEmpty() && st.peek()[0]<=arr[i]){
                //arr[0] -> ele, arr[1] -> span
                span+= st.pop()[1];
            }
            st.push(new int[]{arr[i],span});
            res[i]=span;
        }
        return res;
    }
    public static void main(String[] args) {
        int[] prices={100,80,60,70,60,75,85};
        System.out.println(Arrays.toString(stockSpan(prices)));
    }
}
