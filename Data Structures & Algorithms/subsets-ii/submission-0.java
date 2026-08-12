class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> current = new ArrayList<>() ;
        List<List<Integer>> result = new ArrayList<>() ;
        Arrays.sort(nums) ;
        backtracking(nums,0,current,result) ;
        return result ;
    }

        void backtracking(int[] nums,int start,List<Integer>current,List<List<Integer>>result){
            result.add(new ArrayList<>(current)) ;
        for(int i=start ; i<nums.length ; i++){
        if(i>start && nums[i]==nums[i-1]){
                continue ;
            }
                current.add(nums[i]) ;                   
                backtracking(nums,i+1,current,result) ;
                current.remove(current.size()-1) ;
        }
        
    }
}