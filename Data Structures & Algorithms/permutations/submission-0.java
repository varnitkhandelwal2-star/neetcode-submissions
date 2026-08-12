class Solution {

    public List<List<Integer>> permute(int[] nums) {
       List<Integer> current = new ArrayList<>();
       List<List<Integer>> result = new ArrayList<>();
      boolean[] visited = new boolean[nums.length];
      backtracking(nums,current,result,visited) ;
      return result ;  
    }

    void backtracking(int[] nums,List<Integer>current ,List<List<Integer>> result,boolean[]visited ){;
        if(current.size()==nums.length){
            result.add(new ArrayList<>(current)) ;
            return ;
        }
        for(int i=0 ; i < nums.length ;i++){
            if(!visited[i]){
             visited[i] = true ;
             current.add(nums[i]) ;
             backtracking(nums,current,result,visited) ;
             visited[i] = false ;
             current.remove(current.size()-1) ;
            }
          
        }
    }
}
