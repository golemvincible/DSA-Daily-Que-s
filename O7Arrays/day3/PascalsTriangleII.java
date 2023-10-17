import java.util.ArrayList;
import java.util.List;

class PascalsTriangleII{
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
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        
        for(int i=0;i<rowIndex+1;i++){
            row.add((int)(nCr(rowIndex,i)));
        }
        
        return row;
    }
}