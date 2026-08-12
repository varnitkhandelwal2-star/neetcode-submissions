class NumMatrix {   
    int[][] prefix ;
    public NumMatrix(int[][] matrix) {
        int m  = matrix.length ; 
int n = matrix[0].length ;
prefix =  new int[m+1][n+1] ;
for(int i=1 ; i<m+1 ; i++){
    for (int j=1 ; j<n+1 ; j++){
        prefix[i][j] = prefix[i-1][j] 
             + prefix[i][j-1] 
             - prefix[i-1][j-1] 
             + matrix[i-1][j-1] ;
    }
}
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int result = prefix[row2+1][col2+1] 
          - prefix[row2+1][col1]    // remove left part
          - prefix[row1][col2+1]    // remove top part
          + prefix[row1][col1]  ; // add back overlap
      return result ; 
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */