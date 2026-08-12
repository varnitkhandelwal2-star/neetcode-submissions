class Solution {
    public String longestCommonPrefix(String[] strs) {
        String result = strs[0] ;
        for(int i=1 ; i<strs.length ; i++){
            String current = strs[i] ;
            int j=0 ;
            while(j<result.length() && j<current.length() && result.charAt(j)==current.charAt(j)){
                j++ ;
            }
            result = result.substring(0,j) ;
        } 
        if(result.isEmpty()) return "" ;
        return result ;
    }
}   