import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    private static long nCr(int n,int r){
        /*
            r-1
                C
                  c-1
        */
        
        long res = 1;
        
        for(int i=0;i<r;i++){
            res = res * (n-i);
            res = res / (i+1);
        }
        
        return res;
    }
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> res = new ArrayList<>();
        
        for(int row=0;row<n;row++){
            List<Integer> currRow = new ArrayList<>();
            
            for(int col=0;col<row+1;col++){
                
                currRow.add((int)nCr(row,col));
            }
            
            res.add(currRow);
        }
        
        return res;
    }
}
