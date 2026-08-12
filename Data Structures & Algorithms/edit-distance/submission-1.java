class Solution {
        int[][] memo ; 
        String word1 , word2 ;
    public int minDistance(String word1, String word2) {
     this.word1 = word1 ;
     this.word2 = word2 ;
     memo = new int [ word1.length() +1][word2.length() +1] ;
     for(int[] row :memo) Arrays.fill(row,-1) ;
     return solve(0,0) ;

    }
    public int solve (int i , int j ){
        if(i==word1.length()) return word2.length()-j;
        if(j==word2.length()) return word1.length()-i;

        if (memo[i][j] != -1) return memo[i][j];
          int res  ;
        if(word1.charAt(i)==word2.charAt(j)){
           res = solve(i+1, j+1) ;
        }else{
        int replace = 1+ solve(i+1,j+1) ;
        int delete = 1+ solve(i+1,j) ;
        int insert = 1+ solve(i,j+1) ;
        res = Math.min(replace, Math.min(delete ,insert )) ;
        }
        return memo[i][j] = res ;

    }
}
