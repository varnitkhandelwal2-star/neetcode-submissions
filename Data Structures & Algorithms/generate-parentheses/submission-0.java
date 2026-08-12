class Solution {
    public List<String> generateParenthesis(int n) {
        String current = new String() ;
        List<String> result = new ArrayList<>() ;
        backtracking(n, 0, 0, current , result) ;
        return result ;
    }

    void backtracking(int n ,int open,int close,String current ,List<String> result){
        if(current.length()==2*n){
            result.add(current) ;
            return ;
        }
       if(open < n) {
    backtracking(n, open+1, close, current + "(", result);
    }

    if(close < open) {
        backtracking(n, open, close+1, current + ")", result);
    }
  }

}
