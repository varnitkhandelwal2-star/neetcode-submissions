class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left =0 ;
        int n = matrix[0].length ;
        int m = matrix.length ;
        int right = m*n -1  ;
        while(left<=right ){
            int mid =left+((right-left)/2 ) ;
            int val = matrix[mid/n][mid%n] ;
            if (val>target){
                right = mid -1 ;
            }
            else if (val<target){
                left = mid+1 ;
            }
            else{ 
                return true ;
            }
        }
        return false ;
    }
}
