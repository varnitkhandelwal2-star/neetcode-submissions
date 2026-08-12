class Solution {
    public int trap(int[] height) {
        int n = height.length ;
        int[] prefix = new int[n] ;
        int[] surfix = new int[n];
        prefix[0] = height[0] ;
     for (int i=1 ; i<n;i++){
        prefix[i] = Math.max(prefix[i-1], height[i]) ;
            }
            surfix[n-1] = height[n-1] ;
     for(int i= n-2 ; i>=0 ;i--){
        surfix[i] = Math.max(surfix[i+1], height[i]) ;
            }
           int area = 0;
     for(int i=0 ; i<n ;i++){
            area +=  Math.min(prefix[i], surfix[i]) - height[i] ;
           }
        
        return area ;
    }
}
