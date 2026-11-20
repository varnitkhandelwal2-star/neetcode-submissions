class Solution {
    List<Integer> curr = new ArrayList<>() ;
    List<List<Integer>> result = new ArrayList <>() ;
    public List<List<Integer>> combine(int n, int k) {
        if(k>n) return null ;
        backtrack (1,n,k) ;
        return result ;
    }
    void backtrack (int start , int n , int k ){
        if(curr.size() == k ) result.add(new ArrayList(curr)) ;
       for(int i = start ; i<=n ; i++){
        curr.add(i) ;
        backtrack(i+1 , n , k) ;
        curr.remove(curr.size()-1) ;
       }
    }
}