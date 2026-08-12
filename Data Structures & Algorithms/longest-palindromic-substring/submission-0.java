class Solution {
    public String longestPalindrome(String s) {
        String result = new String() ;
        for(int i=0 ;i<s.length() ; i++){
            int l=i ;
            int r=i ;
            while(l >= 0 && r < s.length() && s.charAt(l)==s.charAt(r)){
                l-- ;
                r++ ;
            }
            String odd = s.substring(l+1, r ) ;
            if(odd.length()>result.length()){
                result = odd ;
            }
            l=i ;
            r=i+1 ;
            while(l >= 0 && r < s.length() && s.charAt(l)==s.charAt(r)){
                l-- ;
                r++ ;
            }
            String even = s.substring(l+1, r) ;
            if(even.length()>result.length()){
                result = even ;
            }
        }
        return result ;
    }
}
