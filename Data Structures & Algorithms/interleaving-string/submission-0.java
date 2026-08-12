class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        boolean[][] memo = new boolean[s1.length()+1][s2.length()+1];
        if (s1.length() + s2.length() != s3.length()) return false ;
        return solve(0,0,s1,s2,s3,memo) ;
    }
    public boolean  solve(int i, int j , String s1, String s2, String s3 , boolean [][] memo){
        boolean ans = false ;
        if(i==s1.length() && j==s2.length()) return true ;
        
        if(i<s1.length() && s1.charAt(i)==s3.charAt(i+j)){
            ans = ans || solve(i+1,j,s1,s2,s3,memo) ;
        }
        if(j<s2.length() && s2.charAt(j)==s3.charAt(i+j)) {
            ans= ans|| solve(i,j+1,s1,s2,s3,memo) ;
        }
        return memo[i][j] = ans ; 
    }
}
