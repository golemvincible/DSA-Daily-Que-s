import java.util.ArrayList;
import java.util.List;

public class SuperiorElements {
    private static List<Integer> better(int[] a){
        int n = a.length;
        List<Integer> ans = new ArrayList<>();

        // int[] res = new int[n];
        int next=a[n-1];
        // res[n-1] = a[n-1];
        ans.add(a[n-1]);

        for(int i=n-2;i>=0;i--){
            if(a[i]>next){
                ans.add(a[i]);
                next = a[i];
            }
            
        }

        return ans;
    }
    public static List< Integer > superiorElements(int []a) {
        return better(a);
    }
}
