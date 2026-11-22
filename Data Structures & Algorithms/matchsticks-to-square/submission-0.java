class Solution {
    int[] sides = new int[4] ;
    public boolean makesquare(int[] matchsticks) {
        int sum = 0 ;
           for(int i=0 ; i<matchsticks.length ; i++ ){
             sum += matchsticks[i] ;
         }
        if(sum %4 != 0 || matchsticks.length<4 ) return false ;
        int target = sum/4 ;
        if (backtrack(0,matchsticks,target) )return true ;
        return false ;
    }
    boolean backtrack (int i, int[] matchsticks, int target) {
    if(i == matchsticks.length) return true;
     for(int j=0 ; j<4 ; j++){
    if (sides[j] + matchsticks[i] > target ) continue ;
        sides[j] +=matchsticks[i] ;
    if(backtrack(i+1 , matchsticks , target)) return true ;
     sides[j] -= matchsticks[i] ;
     }
        return false ;
    }
}