public class SetMatrixZeroes {
    private static void better(int[][] m){
        int n = m.length;
        
        int[] r = new int[m.length];
        int[] c = new int[m[0].length];
        
        for(int i=0;i<m.length;i++){
            for(int j=0;j<m[0].length;j++){
                
                if(m[i][j]==0){
                    r[i]=1;
                    c[j]=1;
                }
            }
        }
        
        for(int i=0;i<m.length;i++){
            for(int j=0;j<m[0].length;j++){
                
                if(r[i]==1 || c[j]==1){
                    m[i][j]=0;
                }
            }
        }
    }
    public void setZeroes(int[][] matrix) {
        better(matrix);
    }
}
