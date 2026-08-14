class Solution {
    public boolean validPalindrome(String s) {
       int right = s.length()-1 ;
        int left = 0 ;
       while (left<right){
        if(s.charAt(left) == s.charAt(right)) {
    left++;
    right--;
}
          else{
             return isPalindrome(s, left+1, right) || isPalindrome(s, left, right-1) ;
          }
       }
       return true ;
    }
    public boolean isPalindrome(String s , int left , int right ){
     
        while(left<right) {
     if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)) ){
            return false  ;
          }
          
           right -- ;
            left ++ ;

        }
        return true ; 
    }
}